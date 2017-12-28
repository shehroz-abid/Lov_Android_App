package app.lov.com.lov_android_app.Gui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import app.lov.com.lov_android_app.Fragments.PhoneLoginFragmentA;
import app.lov.com.lov_android_app.Fragments.PhoneLoginFragmentC;
import app.lov.com.lov_android_app.R;

/**
 * Created by Shehroz on 26-Dec-17.
 */

public class PhoneLoginActivityB extends Activity implements View.OnClickListener{


    FragmentTransaction transaction;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_phone_main);


        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();



//        transaction =  getFragmentManager().beginTransaction();
//        transaction.add(R.id.phone_login_framelayout, new PhoneLoginFragmentC());
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

