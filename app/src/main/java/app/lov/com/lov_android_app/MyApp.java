package app.lov.com.lov_android_app;

import android.app.Application;

import app.lov.com.lov_android_app.Utils.DiscreteScrollViewOptions;

/**
 * Created by macbookpro on 15/01/2018.
 */

public class MyApp extends Application {

    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DiscreteScrollViewOptions.init(this);
    }
}
