package app.lov.com.lov_android_app.Gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import app.lov.com.lov_android_app.R;

/**
 * Created by Shehroz on 20-Dec-17.
 */

public class LoginPhoneActivity extends Activity implements View.OnClickListener{

    EditText country_code_edttxt, phone_number_edttxt;
    Button send_cnfrm_btn;
    //LoginButton fb_signup_btn;
    TextView forgetPasswordTxt, signUp_txt;
    ProgressBar progressbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_phone_a_fragment);


        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();

        progressbar= new ProgressBar(this);

        country_code_edttxt = (EditText)findViewById(R.id.country_code_edttxt);
        phone_number_edttxt = (EditText)findViewById(R.id.phone_number_edttxt);



        send_cnfrm_btn =(Button)findViewById(R.id.send_cnfrm_btn);


        send_cnfrm_btn.setOnClickListener(this);
        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);


    }
    private void registerUser(){
        String phone = phone_number_edttxt.getText().toString().trim();
        String country_code = country_code_edttxt.getText().toString().trim();
        if(TextUtils.isEmpty(phone)){
            // Email is Empty
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(country_code)){
            // Password is Empty
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

    }


    @Override
    public void onClick(View v) {

        if(v == send_cnfrm_btn){
            //registerUser();
            /*Intent myIntent = new Intent(LoginPhoneActivity.this, ConfirmationPhoneLoginActivity.class);
            myIntent.putExtra("YourValueKey", "home");
            LoginActivity.this.startActivity(myIntent);*/

        }

        // implements your things
    }
}


