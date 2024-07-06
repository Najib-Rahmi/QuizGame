package com.example.sql;

import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView tvPERCENTAGE;
    Button CA, WA, FS ,btnRestart;
    public int LastScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        CA = (Button)findViewById(R.id.tvres);
        WA = (Button)findViewById(R.id.tvres2);
        FS = (Button)findViewById(R.id.tvres3);
        tvPERCENTAGE = (TextView)findViewById(R.id.tvPerc);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        Intent intent=getIntent();
        int finalscore=intent.getIntExtra("score",0);
        FS.setText("Final Score : "+finalscore);
        String wongans=intent.getStringExtra("wa");
        WA.setText("Wrong Answers : "+wongans);
        String correctans=intent.getStringExtra("ca");
        CA.setText("Correct Answers : "+correctans);
        LastScore=finalscore;
        tvPERCENTAGE.setText(finalscore/2+" %");


        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ResultActivity.this,MainActivity.class);
                in.putExtra("highscore",finalscore);
                startActivity(in);
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Alert !")
                .setMessage("Are you sure you want to go to Welcome page?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent in = new Intent(ResultActivity.this,MainActivity.class);
                        in.putExtra("highscore",LastScore);
                        startActivity(in);
                    }
                }).create().show();
    }

}
