package app.lov.com.lov_android_app.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.lov.com.lov_android_app.R;

/**
 * Created by Shehroz on 26-Dec-17.
 */

public class PhoneLoginFragmentC extends Fragment implements View.OnClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.login_phone_c_fragment, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();


        //active_order_from_address_txt = (TextView) v.findViewById(R.id.active_order_from_address_txt);
        //active_order_procceed_btn.setOnClickListener(this);

        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);

        return v;

    }

    @Override
    public void onClick(View v) {

        /*if(v == active_order_procceed_btn){


        }*/


        // implements your things
    }
}
