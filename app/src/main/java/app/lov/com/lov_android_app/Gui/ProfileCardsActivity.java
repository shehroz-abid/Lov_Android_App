package app.lov.com.lov_android_app.Gui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;

import app.lov.com.lov_android_app.Adapters.UserProfileAdapter;
import app.lov.com.lov_android_app.DataModels.Item;
import app.lov.com.lov_android_app.DataModels.Shop;
import app.lov.com.lov_android_app.R;
import app.lov.com.lov_android_app.Utils.DiscreteScrollViewOptions;


public class ProfileCardsActivity extends AppCompatActivity implements DiscreteScrollView.OnItemChangedListener,
        View.OnClickListener{

    private List<Item> data;
    private Shop shop;

    private ProgressBar progressBar;
    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter infiniteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_layout);

        shop = Shop.get();
        data = shop.getData();

        itemPicker = (DiscreteScrollView) findViewById(R.id.picker);
        itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new UserProfileAdapter(data));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setItemTransitionTimeMillis(DiscreteScrollViewOptions.getTransitionTime());
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        onItemChanged(data.get(0));
    }

    private void onItemChanged(Item item) {
//        currentItemName.setText(item.getName());
//        currentItemPrice.setText(item.getPrice());
//        changeRateButtonState(item);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
        int positionInDataSet = infiniteAdapter.getRealPosition(adapterPosition);
        onItemChanged(data.get(positionInDataSet));
    }
}
