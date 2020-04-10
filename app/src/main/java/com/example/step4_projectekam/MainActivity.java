package com.example.step4_projectekam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enterReview;
    private Button comment;
    private TextView reviewText;
    private CardView cardView;
    private Button backgroundOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterReview = findViewById(R.id.enterReview_editText);
        comment = findViewById(R.id.comment_Button);
        reviewText = findViewById(R.id.reviewTextView_CardView);
        cardView = findViewById(R.id.cardView_CardView);
        backgroundOne = findViewById(R.id.changeBackgroundColor_button);

        comment.setOnClickListener(this);
        backgroundOne.setOnClickListener(this);

        setActivityBackgroundColor(getResources().getColor(R.color.colorBackgroundOne));
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.comment_Button:
                String comment = enterReview.getText().toString();
                reviewText.setText(comment);
                break;

            case R.id.changeBackgroundColor_button:
                setActivityBackgroundColor(getResources().getColor(R.color.colorBackgroundTwo));
                break;

        }
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
