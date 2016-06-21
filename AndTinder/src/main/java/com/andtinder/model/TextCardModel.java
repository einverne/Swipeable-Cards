package com.andtinder.model;

/**
 * Created by einverne on 16/6/21.
 */

public class TextCardModel extends CardModel {

    private String textShow;

    public TextCardModel(String textShow) {
        this.textShow = textShow;
    }

    public String getTextShow() {
        return textShow;
    }

    public void setTextShow(String textShow) {
        this.textShow = textShow;
    }

}
