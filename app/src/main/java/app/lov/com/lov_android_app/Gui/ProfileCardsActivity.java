package app.lov.com.lov_android_app.Gui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import app.lov.com.lov_android_app.Adapters.ProfileCardAdapter;
import app.lov.com.lov_android_app.R;
import app.lov.com.lov_android_app.Utils.PersonsProfile;

public class ProfileCardsActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private CardStackView cardStackView;
    private ProfileCardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_profiles_layout);
        setup();
        reload();
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_reload:
                reload();
                break;
            case R.id.menu_activity_main_add_first:
                addFirst();
                break;
            case R.id.menu_activity_main_add_last:
                addLast();
                break;
            case R.id.menu_activity_main_remove_first:
                removeFirst();
                break;
            case R.id.menu_activity_main_remove_last:
                removeLast();
                break;
            case R.id.menu_activity_main_swipe_left:
                swipeLeft();
                break;
            case R.id.menu_activity_main_swipe_right:
                swipeRight();
                break;
            case R.id.menu_activity_main_reverse:
                reverse();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
*/

    private PersonsProfile createProfileSpot() {
        return new PersonsProfile("Yasaka Shrine", "Kyoto", "https://source.unsplash.com/Xq1ntWruZQI/600x800");
    }

    private List<PersonsProfile> createTouristSpots() {
        List<PersonsProfile> spots = new ArrayList<>();
        spots.add(new PersonsProfile("Yasaka Shrine", "Kyoto", "https://source.unsplash.com/Xq1ntWruZQI/600x800"));
        spots.add(new PersonsProfile("Fushimi Inari Shrine", "Kyoto", "https://source.unsplash.com/NYyCqdBOKwc/600x800"));
        spots.add(new PersonsProfile("Bamboo Forest", "Kyoto", "https://source.unsplash.com/buF62ewDLcQ/600x800"));
        spots.add(new PersonsProfile("Brooklyn Bridge", "New York", "https://source.unsplash.com/THozNzxEP3g/600x800"));
        spots.add(new PersonsProfile("Empire State Building", "New York", "https://source.unsplash.com/USrZRcRS2Lw/600x800"));
        spots.add(new PersonsProfile("The statue of Liberty", "New York", "https://source.unsplash.com/PeFk7fzxTdk/600x800"));
        spots.add(new PersonsProfile("Louvre Museum", "Paris", "https://source.unsplash.com/LrMWHKqilUw/600x800"));
        spots.add(new PersonsProfile("Eiffel Tower", "Paris", "https://source.unsplash.com/HN-5Z6AmxrM/600x800"));
        spots.add(new PersonsProfile("Big Ben", "London", "https://source.unsplash.com/CdVAUADdqEc/600x800"));
        spots.add(new PersonsProfile("Great Wall of China", "China", "https://source.unsplash.com/AWh9C-QjhE4/600x800"));
        return spots;
    }

    private ProfileCardAdapter createTouristSpotCardAdapter() {
        final ProfileCardAdapter adapter = new ProfileCardAdapter(getApplicationContext());
        adapter.addAll(createTouristSpots());
        return adapter;
    }

    private void setup() {
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress_bar);

        cardStackView = (CardStackView) findViewById(R.id.activity_main_card_stack_view);
        cardStackView.setCardEventListener(new CardStackView.CardEventListener() {
            @Override
            public void onCardDragging(float percentX, float percentY) {
                Log.d("CardStackView", "onCardDragging");
            }

            @Override
            public void onCardSwiped(SwipeDirection direction) {
                Log.d("CardStackView", "onCardSwiped: " + direction.toString());
                Log.d("CardStackView", "topIndex: " + cardStackView.getTopIndex());
                if (cardStackView.getTopIndex() == adapter.getCount() - 5) {
                    Log.d("CardStackView", "Paginate: " + cardStackView.getTopIndex());
                    paginate();
                }
            }

            @Override
            public void onCardReversed() {
                Log.d("CardStackView", "onCardReversed");
            }

            @Override
            public void onCardMovedToOrigin() {
                Log.d("CardStackView", "onCardMovedToOrigin");
            }

            @Override
            public void onCardClicked(int index) {
                Log.d("CardStackView", "onCardClicked: " + index);
            }
        });
    }

    private void reload() {
        cardStackView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter = createTouristSpotCardAdapter();
                cardStackView.setAdapter(adapter);
                cardStackView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        }, 1000);
    }

    private LinkedList<PersonsProfile> extractRemainingTouristSpots() {
        LinkedList<PersonsProfile> spots = new LinkedList<>();
        for (int i = cardStackView.getTopIndex(); i < adapter.getCount(); i++) {
            spots.add(adapter.getItem(i));
        }
        return spots;
    }

    private void addFirst() {
        LinkedList<PersonsProfile> spots = extractRemainingTouristSpots();
        spots.addFirst(createProfileSpot());
        adapter.clear();
        adapter.addAll(spots);
        adapter.notifyDataSetChanged();
    }

    private void addLast() {
        LinkedList<PersonsProfile> spots = extractRemainingTouristSpots();
        spots.addLast(createProfileSpot());
        adapter.clear();
        adapter.addAll(spots);
        adapter.notifyDataSetChanged();
    }

    private void removeFirst() {
        LinkedList<PersonsProfile> spots = extractRemainingTouristSpots();
        if (spots.isEmpty()) {
            return;
        }

        spots.removeFirst();
        adapter.clear();
        adapter.addAll(spots);
        adapter.notifyDataSetChanged();
    }

    private void removeLast() {
        LinkedList<PersonsProfile> spots = extractRemainingTouristSpots();
        if (spots.isEmpty()) {
            return;
        }

        spots.removeLast();
        adapter.clear();
        adapter.addAll(spots);
        adapter.notifyDataSetChanged();
    }

    private void paginate() {
        cardStackView.setPaginationReserved();
        adapter.addAll(createTouristSpots());
        adapter.notifyDataSetChanged();
    }

    public void swipeLeft() {
        List<PersonsProfile> spots = extractRemainingTouristSpots();
        if (spots.isEmpty()) {
            return;
        }

        View target = cardStackView.getTopView();

        ValueAnimator rotation = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("rotation", -10f));
        rotation.setDuration(200);
        ValueAnimator translateX = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationX", 0f, -2000f));
        ValueAnimator translateY = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationY", 0f, 500f));
        translateX.setStartDelay(100);
        translateY.setStartDelay(100);
        translateX.setDuration(500);
        translateY.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotation, translateX, translateY);

        cardStackView.swipe(SwipeDirection.Left, set);
    }

    public void swipeRight() {
        List<PersonsProfile> spots = extractRemainingTouristSpots();
        if (spots.isEmpty()) {
            return;
        }

        View target = cardStackView.getTopView();

        ValueAnimator rotation = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("rotation", 10f));
        rotation.setDuration(200);
        ValueAnimator translateX = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationX", 0f, 2000f));
        ValueAnimator translateY = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationY", 0f, 500f));
        translateX.setStartDelay(100);
        translateY.setStartDelay(100);
        translateX.setDuration(500);
        translateY.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotation, translateX, translateY);

        cardStackView.swipe(SwipeDirection.Right, set);
    }

    private void reverse() {
        cardStackView.reverse();
    }

}
