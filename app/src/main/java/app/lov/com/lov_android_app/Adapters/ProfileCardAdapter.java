package app.lov.com.lov_android_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import app.lov.com.lov_android_app.R;
import app.lov.com.lov_android_app.Utils.PersonsProfile;

/**
 * Created by Shehroz on 27-Dec-17.
 */

public class ProfileCardAdapter extends ArrayAdapter<PersonsProfile> {

    public ProfileCardAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        ViewHolder holder;

        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.item_profile_card, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        PersonsProfile spot = getItem(position);

        holder.name.setText(spot.name);
        holder.city.setText(spot.city);
        Glide.with(getContext()).load(spot.url).into(holder.image);

        return contentView;
    }

    private static class ViewHolder {
        public TextView name;
        public TextView city;
        public ImageView image;

        public ViewHolder(View view) {
            this.name = (TextView) view.findViewById(R.id.item_profile_card_name);
            this.city = (TextView) view.findViewById(R.id.item_profile_spot_card_city);
            this.image = (ImageView) view.findViewById(R.id.item_profile_spot_card_image);
        }
    }

}
