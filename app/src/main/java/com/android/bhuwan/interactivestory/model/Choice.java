package com.android.bhuwan.interactivestory.model;

/**
 * Created by bhuwan on 9/28/15.
 */
public class Choice {
    private String choice;
    private int id;

    public Choice(String ch, int id)
    {
        choice = ch;
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}
