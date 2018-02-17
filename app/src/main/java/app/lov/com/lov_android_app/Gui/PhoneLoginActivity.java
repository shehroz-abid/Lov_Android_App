package app.lov.com.lov_android_app.Gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import app.lov.com.lov_android_app.Fragments.PhoneLoginFragmentA;
import app.lov.com.lov_android_app.R;

/**
 * Created by Shehroz on 26-Dec-17.
 */

public class PhoneLoginActivity extends Activity implements View.OnClickListener{


    FragmentTransaction transaction;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_phone_main);


        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();



//        transaction =  getFragmentManager().beginTransaction();
//        transaction.add(R.id.phone_login_framelayout, new PhoneLoginFragmentA());
//        transaction.addToBackStack(null);
//        transaction.commit();



        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);


    }



    @Override
    public void onClick(View v) {
        // implements your things
    }
}
