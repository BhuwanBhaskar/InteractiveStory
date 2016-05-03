package com.android.bhuwan.interactivestory.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.bhuwan.interactivestory.R;

public class StoryActivity extends AppCompatActivity {

    private EditText mEditText ;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mEditText = (EditText)findViewById(R.id.nameText);
        mButton = (Button)findViewById(R.id.startButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mEditText.getText().toString();
                //Toast.makeText(StoryActivity.this,name,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(StoryActivity.this,BeginStoryActivity.class);
                intent.putExtra(getString(R.string.key_name), name);
                startActivity(intent);
            }
        });
    }

    protected void onResume()
    {
        super.onResume();
        mEditText.setText("");
    }
}
