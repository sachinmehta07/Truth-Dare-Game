package com.android.truthdaregame;

public class TruthItem{

    private String mText;
    private String mCategory;

    public TruthItem(String text, String category) {
        mText = text;
        mCategory = category;
    }

    public String getmText() {
        return mText;
    }

    public String getmCategory() {
        return mCategory;
    }

}