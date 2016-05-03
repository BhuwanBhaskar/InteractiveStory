package com.android.bhuwan.interactivestory.View;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.bhuwan.interactivestory.R;
import com.android.bhuwan.interactivestory.model.Story;
import com.android.bhuwan.interactivestory.model.StoryPage;

public class BeginStoryActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1, mChoice2;
    private Story mStory;
    private StoryPage mStoryPage;
    private String mName;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_begin_story);
            Intent intent = getIntent();
            mName = intent.getStringExtra(getString(R.string.key_name));
            mStory = new Story();
            mTextView = (TextView)findViewById(R.id.StoryTextView);
            mImageView = (ImageView)findViewById(R.id.storyImageView);
            mChoice1 = (Button)findViewById(R.id.choice1);
            mChoice2 = (Button)findViewById(R.id.choice2);
            loadStoryPage(0);

    }

    private void loadStoryPage(int index)
    {
        mStoryPage = mStory.getStoryPage(index);
        Drawable drawable = getResources().getDrawable(mStoryPage.getImageId());
        mImageView.setImageDrawable(drawable);
        String text = mStoryPage.getText();
        text = String.format(text,mName);
        mTextView.setText(text);

        if(mStoryPage.isClimax())
        {
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("Play Again !!!");

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else {
            mChoice1.setText(mStoryPage.getChoice1().getChoice());
            mChoice2.setText(mStoryPage.getChoice2().getChoice());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mStoryPage.getChoice1().getId();
                    loadStoryPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mStoryPage.getChoice2().getId();
                    loadStoryPage(nextPage);
                }
            });
        }
    }

}
