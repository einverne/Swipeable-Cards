package com.andtinder.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andtinder.model.TextCardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.TextCardStackAdapter;

public class TextCardActivity extends AppCompatActivity {

    private CardContainer mTextCardContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_card);

        mTextCardContainer = (CardContainer) findViewById(R.id.textCardContainer);

        TextCardStackAdapter textCardStackAdapter = new TextCardStackAdapter(this);
        textCardStackAdapter.add(new TextCardModel("text"));
        textCardStackAdapter.add(new TextCardModel("text2"));
        textCardStackAdapter.add(new TextCardModel("text3"));
        textCardStackAdapter.add(new TextCardModel("text4"));

        mTextCardContainer.setAdapter(textCardStackAdapter);

    }
}
