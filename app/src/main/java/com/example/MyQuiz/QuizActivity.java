package com.example.sql;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    Button confirmer,reponse1,reponse2,reponse3;
    TextView question,score,textViewTime,questionnumber;
    ProgressBar progressBar;
    List<Quiz> quesList;
    Quiz questionactual;
    int SC=0;
    int correct=0,wrong=0;
    int countQuestion = 1;
    int totalCountQuestion = 20;
    String bonnereponse="",hello="hello";
    final CounterClass timer = new CounterClass(60000, 1000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        question = (TextView) findViewById(R.id.question);
        reponse1 = (Button) findViewById(R.id.reponse1);
        reponse2 = (Button) findViewById(R.id.reponse2);
        reponse3 = (Button) findViewById(R.id.reponse3);
        confirmer=(Button) findViewById(R.id.confirmer);
        score = (TextView) findViewById(R.id.score);
        textViewTime = (TextView)findViewById(R.id.textViewTime);
        questionnumber = (TextView)findViewById(R.id.qn);

        reponse1.setOnClickListener(this);
        reponse2.setOnClickListener(this);
        reponse3.setOnClickListener(this);

        confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewTime.setText((timer).toString());

            if (countQuestion<=totalCountQuestion){
                setQuestionView();
            }
            else {
                Intent intent=new Intent(QuizActivity.this,ResultActivity.class);
                intent.putExtra("score",SC);
                intent.putExtra("ca",String.valueOf(correct));
                intent.putExtra("wa",String.valueOf(wrong));
                startActivity(intent);
            }
            }
        });

        QuestionDbHelper helper=new QuestionDbHelper(this);

               Toast.makeText(getApplicationContext(), "Please select one choice for each question ", Toast.LENGTH_LONG).show();

        quesList=helper.afficheQuiz();
        setQuestionView();
        Log.i("******", quesList.size()+"");

    }
    private void setQuestionView(){
            timer.start();
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setMax(totalCountQuestion);
            progressBar.setProgress(countQuestion);

            questionactual=quesList.get(countQuestion);

            questionnumber.setText("Question "+ countQuestion + "/" + totalCountQuestion);
            question.setText(questionactual.getQuestion());
            reponse1.setText(questionactual.getReponse1());
            reponse2.setText(questionactual.getReponse2());
            reponse3.setText(questionactual.getReponse3());
            bonnereponse = questionactual.getBonneReponse();
        reponse1.setEnabled(true);
        reponse2.setEnabled(true);
        reponse3.setEnabled(true);
            score.setText("Score :"+ SC);
        countQuestion++;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.reponse1) :
                if (reponse1.getText().equals(bonnereponse)){
                    correct++;
                    SC=SC+10;
                }
                else
                    wrong++;
                reponse1.setEnabled(false);
                reponse2.setEnabled(true);
                reponse3.setEnabled(true);
                break;
            case (R.id.reponse2) :
                if (reponse2.getText().toString().equals(bonnereponse)){
                    SC=SC+10;
                    correct++;
                }
                else
                    wrong++;
                reponse2.setEnabled(false);
                reponse1.setEnabled(true);
                reponse3.setEnabled(true);
                break;
            case (R.id.reponse3) :
                if (reponse3.getText().equals(bonnereponse)){
                    SC=SC+10;
                    correct++;
                }
                else
                    wrong++;
                reponse3.setEnabled(false);
                reponse2.setEnabled(true);
                reponse1.setEnabled(true);
                break;
        }
    }
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            long seconds = millisUntilFinished / 1000;
            long minutes = seconds / 60;
            long remainingSeconds = seconds % 60;

            String hms = String.format("%02d:%02d", minutes, remainingSeconds);
            textViewTime.setText(hms);
            if (seconds <= 10) {
                textViewTime.setTextColor(Color.RED);
            } else {
                // Reset text color to default (black or any other color you want)
                textViewTime.setTextColor(Color.BLACK); // Or another default color
            }
            if (seconds == 00){
                showTimeOverDialog();
            }
        }


        @Override
        public void onFinish() {

        }
    }
    public void showResult(){
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("If you close all your progress would not be saved \n Do you want to exit ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {finish();}
                });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {dialog.cancel();}
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private void showTimeOverDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Attention")
                .setMessage("Time is over!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle OK button click if needed
                        dialog.dismiss();
                        Intent in = new Intent(QuizActivity.this,ResultActivity.class);
                        in.putExtra("score",SC);
                        in.putExtra("ca",String.valueOf(correct));
                        in.putExtra("wa",String.valueOf(wrong));
                        startActivity(in);
                    }
                })
                .setCancelable(false); // Prevent dialog from being dismissed by back button

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
