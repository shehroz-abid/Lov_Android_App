package app.lov.com.lov_android_app.Gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import app.lov.com.lov_android_app.R;

/**
 * Created by Shehroz on 07-Dec-17.
 */

public class SplashScreen extends Activity implements View.OnClickListener{

    // Splash screen timer
    Button get_start_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        get_start_btn= (Button)findViewById(R.id.get_start_btn);
        get_start_btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        if(v == get_start_btn){

            Intent myIntent = new Intent(SplashScreen.this, HowItWorkActivity.class);
            SplashScreen.this.startActivity(myIntent);

        }

        // implements your things
    }

}

