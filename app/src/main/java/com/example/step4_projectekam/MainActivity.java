package com.example.step4_projectekam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.step4_projectekam.Util.Pref;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enterReview;
    private Button comment;
    private TextView reviewText;
    private CardView cardView;
    private Button blueButton;
    private Button redButton;
    private Pref pref;
    public static final  int BLUECOLOR = R.color.colorBackgroundBlue;
    public static final  int REDCOLOR = R.color.colorBackgroundRed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterReview = findViewById(R.id.enterReview_editText);
        comment = findViewById(R.id.comment_Button);
        reviewText = findViewById(R.id.reviewTextView_CardView);
        cardView = findViewById(R.id.cardView_CardView);
        redButton = findViewById(R.id.bgToRed_button);
        blueButton = findViewById(R.id.bgToBlue_button);

        redButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);

        comment.setOnClickListener(this);


        pref = new Pref(MainActivity.this);

        reviewText.setText(pref.getReview());
        Log.d("GETREVIEW", "onCreate: "+pref.getReview());

        setActivityBackgroundColor(pref.getState());
        Log.d("COLORSTATE", "onCreate: "+pref.getState());


//        setActivityBackgroundColor(getResources().getColor(R.color.colorBackgroundOne));
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.comment_Button:
                String comment = enterReview.getText().toString();
                reviewText.setText(comment);
                pref.saveReview(comment);
                break;

            case R.id.bgToRed_button:
                if(pref.getState() != getResources().getColor(REDCOLOR)){
                    setActivityBackgroundColor(getResources().getColor(REDCOLOR));
                    pref.setState(getResources().getColor(REDCOLOR));
                    Log.d("COLORBUTTON", "onClick: "+getResources().getColor(REDCOLOR)+" red color");
                }
                else{
                    Toast.makeText(getApplicationContext(),"ALREADY SELECTED ! \n Choose BLUE",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.bgToBlue_button:
                if(pref.getState() != getResources().getColor(BLUECOLOR)){
                    //Log.d("COLOR", "onClick: "+BLUECOLOR);
                    setActivityBackgroundColor(getResources().getColor(BLUECOLOR));
                    pref.setState(getResources().getColor(BLUECOLOR));
                    Log.d("COLORBUTTON", "onClick: "+getResources().getColor(BLUECOLOR)+" blue");
                }
                else{
                    Toast.makeText(getApplicationContext(),"ALREADY SELECTED ! \n Choose RED",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
