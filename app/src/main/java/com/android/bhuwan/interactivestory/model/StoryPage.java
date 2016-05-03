package com.android.bhuwan.interactivestory.model;

/**
 * Created by bhuwan on 9/28/15.
 */
public class StoryPage {
    private String mText;
    private int mImageId;
    private Choice mChoice1,mChoice2;
    private boolean isClimax = false;

    public StoryPage(int id, String text, Choice c1,Choice c2)
    {
        mImageId = id;
        mText = text;
        mChoice1 = c1;
        mChoice2 = c2;
    }

    public StoryPage(int id, String text)
    {
        mImageId = id;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        isClimax = true;
    }

    public String getText() {
        return mText;
    }

    public boolean isClimax() {
        return isClimax;
    }

    public int getImageId() {
        return mImageId;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public void setText(String text) {
        mText = text;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public void setIsClimax(boolean isClimax) {
        this.isClimax = isClimax;
    }
}
