package com.example.dineshbalajivenkataraman.scoreboardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {
    int scoreA;
    int scoreB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        if (savedInstanceState != null) {
            scoreA = savedInstanceState.getInt("Score_A");
            Log.i("ScoreBoard", "" +Integer.toString(scoreA));
            setValueA(scoreA);
            scoreB = savedInstanceState.getInt("Score_B");
            Log.i("ScoreBoard", "" +Integer.toString(scoreB));
            setValueB(scoreB);
        }

        TextView plusAOne = (TextView)findViewById(R.id.a_1_point);
        plusAOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewAone) {
                scoreA = scoreA+1;
                calculateScore(scoreA, viewAone);
            }
        });

        TextView plusATwo = (TextView)findViewById(R.id.a_3_point);
        plusATwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewAthree) {
                scoreA = scoreA+3;
                calculateScore(scoreA, viewAthree);
            }
        });
        TextView plusAFive = (TextView)findViewById(R.id.a_5_point);
        plusAFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewAfive) {
                scoreA = scoreA+5;
                calculateScore(scoreA, viewAfive);
            }
        });

        /********** Team B Score *******/

        TextView plusBOne = (TextView)findViewById(R.id.b_1_point);
        plusBOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewBone) {
                scoreB = scoreB+1;
                calculateScore(scoreB, viewBone);
            }
        });

        TextView plusBTwo = (TextView)findViewById(R.id.b_3_point);
        plusBTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewBthree) {
                scoreB = scoreB+3;
                calculateScore(scoreB, viewBthree);
            }
        });
        TextView plusBFive = (TextView)findViewById(R.id.b_5_point);
        plusBFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewBfive) {
                scoreB = scoreB+5;
                calculateScore(scoreB, viewBfive);
            }
        });

        Button resetMe = (Button)findViewById(R.id.reset);
        resetMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View resetview) {
                resetMe(resetview);
            }
        });
    }
    public void calculateScore(int scr, View view)
    {
        if(view.getId() == R.id.a_1_point || view.getId() == R.id.a_3_point|| view.getId() == R.id.a_5_point  )
        {
            TextView scoreA = (TextView) findViewById(R.id.teamAScore);
            scoreA.setText(String.valueOf(scr));
        }
        else
        {
            TextView scoreB = (TextView)findViewById(R.id.teamBScore);
            scoreB.setText(String.valueOf(scr));
        }
    }
    public void setValueA(int score)
    {
        TextView scA = (TextView) findViewById(R.id.teamAScore);
        scA.setText(String.valueOf(score));
    }
    public void setValueB(int score)
    {
        TextView scB = (TextView)findViewById(R.id.teamBScore);
        scB.setText(String.valueOf(score));
    }
    public void resetMe(View view)
    {
        scoreA=0;
        TextView scoreAv = (TextView) findViewById(R.id.teamAScore);
        scoreAv.setText(String.valueOf(scoreA));
        scoreB=0;
        TextView scoreBv = (TextView)findViewById(R.id.teamBScore);
        scoreBv.setText(String.valueOf(scoreB));
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Log.i(TAG, "onSaveInstanceState");
        Log.i("OnSavedInstance Method", "" +Integer.toString(scoreA));
        outState.putInt("Score_A", scoreA);
        outState.putInt("Score_B", scoreB);
        Log.i("OnSavedInstance Method", "" +Integer.toString(scoreB));
    }
}
