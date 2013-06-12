package com.camsh.dribble;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;

import java.util.Date;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new API.getSubreddit().execute("S");

        CardUI mCardView = (CardUI) findViewById(R.id.cardsview);
        mCardView.setSwipeable(true);

        // add one card
        mCardView.addCard(new MyImageCard("Nexus 4 Part 1",R.drawable.url1));
        mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 2",R.drawable.url2));
        mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 3", R.drawable.url3));

        // draw cards
        mCardView.refresh();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}