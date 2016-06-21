/**
 * AndTinder v0.1 for Android
 *
 * @Author: Enrique López Mañas <eenriquelopez@gmail.com>
 * http://www.lopez-manas.com
 *
 * TAndTinder is a native library for Android that provide a
 * Tinder card like effect. A card can be constructed using an
 * image and displayed with animation effects, dismiss-to-like
 * and dismiss-to-unlike, and use different sorting mechanisms.
 *
 * AndTinder is compatible with API Level 13 and upwards
 *
 * @copyright: Enrique López Mañas
 * @license: Apache License 2.0
 */

package com.andtinder.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.model.TextCardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * This variable is the container that will host our cards
     */
	private CardContainer mCardContainer;
    private Button btnDislike;
    private Button btnLike;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainlayout);

		mCardContainer = (CardContainer) findViewById(R.id.layoutview);
        btnDislike = (Button) findViewById(R.id.btn_dislike);
        btnLike = (Button) findViewById(R.id.btn_like);
        btnDislike.setOnClickListener(this);
        btnLike.setOnClickListener(this);

		Resources r = getResources();

		SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

		adapter.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1)));
		adapter.add(new CardModel("Title2", "Description goes here", r.getDrawable(R.drawable.picture2)));
		adapter.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.picture3)));
		adapter.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1)));
		adapter.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.picture2)));
		adapter.add(new CardModel("Title6", "Description goes here", r.getDrawable(R.drawable.picture3)));

        CardModel cardModel = new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1));
        mCardContainer.setOnClickListener(new CardContainer.OnClickListener() {
           @Override
           public void OnClickListener() {
               Log.i("Swipeable Cards","I am pressing the card");
           }
        });

        mCardContainer.setOnCardDismissedListener(new CardContainer.OnCardDismissedListener() {
			@Override
			public void onDismiss() {
				Log.i("Swipeable Cards", "dismiss cards");
			}

			@Override
            public void onLike() {
                Log.i("Swipeable Cards","I like the card");
            }

            @Override
            public void onDislike() {
                Log.i("Swipeable Cards","I dislike the card");
            }
        });

        mCardContainer.setOnSwipeListener(new CardContainer.OnSwipeListener() {
            @Override
            public void onSwipe(float dx) {
                Log.i("Swipe ", "dx : " + dx);
            }
        });

        adapter.add(cardModel);

		mCardContainer.setAdapter(adapter);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_text_card:
                Intent intent = new Intent(this, TextCardActivity.class);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_dislike:

                mCardContainer.dislike();

                break;
            case R.id.btn_like:

                mCardContainer.like();

                break;

        }
    }
}
