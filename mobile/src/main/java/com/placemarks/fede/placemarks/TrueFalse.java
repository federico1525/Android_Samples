package com.placemarks.fede.placemarks;

/**
 * Created by fede on 3/21/15.
 */
public class TrueFalse {

    private int mQuestion;  // this is an int because will include the resourceID, which is always an int
    private boolean mTrueQuestion;

    //constructor
    public TrueFalse(int mQuestion, boolean mTrueQuestion) {
        this.mQuestion = mQuestion;
        this.mTrueQuestion = mTrueQuestion;
    }

    // getter
    public int getmQuestion() {
        return mQuestion;
    }

    // getter
    public boolean ismTrueQuestion() {
        return mTrueQuestion;
    }

    // setter
    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    // setter
    public void setmTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }
}
