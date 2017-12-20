package app.lov.com.lov_android_app.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shehroz on 19-Dec-17.
 */

public class IntroManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    public IntroManager (Context context){
        this.context = context;
        pref= context.getSharedPreferences("first", 0);
        editor = pref.edit();

    }

    public void setfirst(boolean isfirst){

        editor.putBoolean("check", isfirst);
        editor.commit();
    }

    public boolean check(){
        return pref.getBoolean("check", true);
    }

}
