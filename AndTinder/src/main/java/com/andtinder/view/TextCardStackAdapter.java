package com.andtinder.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andtinder.R;
import com.andtinder.model.CardModel;
import com.andtinder.model.TextCardModel;

/**
 * Created by einverne on 16/6/21.
 */

public class TextCardStackAdapter extends CardStackAdapter {
    public TextCardStackAdapter(Context context) {
        super(context);
    }

    @Override
    protected View getCardView(int position, CardModel model, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.text_card_inner, parent, false);

            assert convertView != null;
        }

        ((TextView) convertView.findViewById(R.id.tv_main)).setText(((TextCardModel)model).getTextShow());

        return convertView;
    }
}
