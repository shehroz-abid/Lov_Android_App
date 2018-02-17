package app.lov.com.lov_android_app.Fragments;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import app.lov.com.lov_android_app.R;

/**
 * Created by Shehroz on 28-Dec-17.
 */

public class SearchStatusFragment extends Fragment implements View.OnClickListener{

    ImageView status_logo_img;
    TextView status_main_txt, status_sub_txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.searching_status_layout, container, false);

        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            LocationManager locMgr = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            if(!locMgr.isProviderEnabled(LocationManager.GPS_PROVIDER)){

                status_logo_img.setImageResource(R.drawable.nogps);
                status_main_txt.setText("No GPS");
                status_sub_txt.setVisibility(View.INVISIBLE);
        }
        else{
                status_logo_img.setImageResource(R.drawable.logosearching);
                status_main_txt.setText("Searching for someone special");
                status_sub_txt.setVisibility(View.INVISIBLE);
            }

        }

        else {

            status_logo_img.setImageResource(R.drawable.logonoconnection);
            status_main_txt.setText("No Connection");
            status_sub_txt.setVisibility(View.INVISIBLE);
        }


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

