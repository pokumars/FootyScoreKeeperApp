package com.viralandroid.footyscorekeeper;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;

    private Chronometer chronometer;
    private boolean running;
    private long pauseOffset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer =  findViewById(R.id.timer);

    }

    public void startTime(View v){
        if (!running){
            chronometer.setBase(SystemClock.elapsedRealtime()- pauseOffset);
            chronometer.start();
            running =true;
        }

    }

    public void pauseTime(View v){
        if (running){
            pauseOffset= SystemClock.elapsedRealtime() -chronometer.getBase();
            chronometer.stop();
            running =false;
        }


    }

    public void resetTime(View v){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset =0;

    }


    /**
     * Adds to team A score
     * @param view takes input from the ButtonView "+ 1"
     */
    public void addToTeamA (View view) {
        scoreA++;
        displayTeamA(scoreA);
    }

    /**
     * Adds to team A score
     * @param view takes input from the ButtonView "- 1"
     */
    public void subtractTeamA(View view){
        if(scoreA==0){
            scoreA=0;
            Toast.makeText(this,getString(R.string.negative_score),Toast.LENGTH_SHORT).show();
            //exit method as there is noting left to do
            return;
        }
        scoreA--;
        displayTeamA(scoreA);
    }

    /**Displays team A score
     *
     * @param score is the figure that the method takes when it is called and displays
     */
    public void displayTeamA (int score){
        TextView teamScoreA = (TextView) findViewById(R.id.score_A);
        teamScoreA.setText(String.valueOf(score));
    }

    /**
     * Adds to team B score
     * @param view takes input from the ButtonView "+ 1"
     */
    public void addToTeamB(View view){
        scoreB++;
        displayTeamB(scoreB);
    }

    /**
     * Adds to team B score
     * @param view takes input from the ButtonView "- 1"
     */
    public void subtractTeamB(View view){
        if(scoreB==0){
            scoreB=0;
            Toast.makeText(this,getString(R.string.negative_score),Toast.LENGTH_SHORT).show();
            //exit method as there is noting left to do
            return;
        }

        scoreB--;
        displayTeamB(scoreB);


    }

    /**Displays team B score
     *
     * @param score is the figure that the method takes when it is called and displays
     */
    public void displayTeamB(int score){
        TextView teamScoreB = (TextView) findViewById(R.id.score_B);
        teamScoreB.setText(String.valueOf(score));
    }

    /**
     * Set all the scores to 0
     * @param view Takes input from Buttonview "Reset"
     */
    public void reset (View view){
        scoreA = 0;
        scoreB=0;

        displayTeamA(scoreA);
        displayTeamB(scoreB);
    }

}
