package com.placemarks.fede.placemarks;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends ActionBarActivity {

    // just creating two buttons objects
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;


    // creating an array of TrueFalse objects -
    // to create I call the TrueFalso costructor several times and returned objects are stored in the array
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_canals, false),
            new TrueFalse(R.string.question_midest, true),
            new TrueFalse(R.string.question_pavia, true)
    };

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getmQuestion();
        // question is the resourceID which can be passed to setText method
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) throws InterruptedException {
        boolean isTruAnswer = mQuestionBank[mCurrentIndex].ismTrueQuestion();
        int messageResId;

        if (isTruAnswer == userPressedTrue){
            messageResId = R.string.correct_toast;
        }
        else {
            messageResId = R.string.incorrect_toast;
        }
        // MyActivity.this or just this ?
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
//        mNextButton.callOnClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // setting the textView initial question
        // casting as TextView the View
        mQuestionTextView = (TextView)findViewById(R.id.textView);
        // mCurrentIndex is 0 - getting first item of the Array, which is a mQuestionBank object
        // getmQuestion returns an int as it returns the resourceID that is always an int
        updateQuestion();


        // ##### BUTTONS
        // Getting the reference to the Widgets as defined in the xml and assigning it to the buttons object
        // Note that since the objects were Buttons, I have to cast the returned widget before assigning it
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mPrevButton = (ImageButton) findViewById(R.id.prev_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    checkAnswer(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    checkAnswer(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // gotta do something
                // update the mCurrentNUmber in the array
//                mCurrentIndex = (mCurrentIndex -1) % mQuestionBank.length;
                if (mCurrentIndex == 0) {
                    mCurrentIndex = (mQuestionBank.length -1);
                }
                else {
                    mCurrentIndex = (mCurrentIndex-1) % mQuestionBank.length;
                }
                System.out.println(mCurrentIndex);
                updateQuestion();
                // and update the text
            }
        });


        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex +1) % mQuestionBank.length;   // smart! returning 0 when index is the same of the lenght
                System.out.println(mCurrentIndex);
                updateQuestion();
            }
        });

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex +1) % mQuestionBank.length;   // smart! returning 0 when index is the same of the lenght
                System.out.println(mCurrentIndex);
                updateQuestion();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
