package com.example.android.bookcricket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int sum1 = 0,end=0, sum2 = 0, f = 0, w = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void resetall(View view) {
        sum1=0;sum2=0;w=0;f=0;end=0;
        TextView scores1 = (TextView) findViewById(R.id.play1score);
        TextView scores2 = (TextView) findViewById(R.id.play2score);
        TextView wicket1 = (TextView) findViewById(R.id.play1wickets);
        TextView wicket2 = (TextView) findViewById(R.id.play2wickets);
        TextView msg1 = (TextView) findViewById(R.id.message);
        scores1.setText("" + sum1);
        scores2.setText("" + sum2);
        wicket1.setText("" + w);
        wicket2.setText("" + w);
        msg1.setText("Player");
    }


    public void keepscore(View view) {
        if(end==0) {
            if (f == 0)
                keepscore1(view);
            else
                keepscore2(view);
        }
    }

    public void keepscore1(View view) {

        if (check_wickets1(view)==1) {
            TextView score1 = (TextView) findViewById(R.id.play1score);
            Random r = new Random();
            int a = r.nextInt(7 - 0) + 0;
            if (a != 0) {
                sum1 = sum1 + a;
                score1.setText("" + sum1);
                TextView msg = (TextView) findViewById(R.id.message);
                msg.setText("Player1 hit " + a + " runs.");
            } else {
                w++;
                if (w == 3) {
                    TextView wickets1 = (TextView) findViewById(R.id.play1wickets);
                    wickets1.setText("" + w);
                    f = 1;
                    w = 0;
                } else {
                    TextView wickets1 = (TextView) findViewById(R.id.play1wickets);
                    wickets1.setText("" + w);
                }
            }
        }
    }

    public int check_wickets1(View view) {
        TextView wickets1 = (TextView) findViewById(R.id.play1wickets);
        String a = wickets1.getText().toString();
        int cw = Integer.parseInt(a);
        if (cw != 3)
            return 1;
        else
            return 0;

    }

    public void keepscore2(View view) {

        if (check_wickets2(view)==1) {
            TextView score2 = (TextView) findViewById(R.id.play2score);
            Random r = new Random();
            int a = r.nextInt(7 - 0) + 0;
            if (a != 0) {
                sum2 = sum2 + a;
                TextView msg = (TextView) findViewById(R.id.message);
                msg.setText("Player2 hit " + a + " runs.");
                if(sum2>sum1)
                {

                    msg.setText("Player 2 Won!");
                    end=1;
                }
                score2.setText("" + sum2);
            } else {
                w++;
                if (w == 3) {
                    TextView msg = (TextView) findViewById(R.id.message);
                    msg.setText("Player1 Won!");
                    end=1;
                    TextView wickets2 = (TextView) findViewById(R.id.play2wickets);
                    wickets2.setText("" + w);
                    f = 0;
                    w = 0;

                } else {
                    TextView wickets2 = (TextView) findViewById(R.id.play2wickets);
                    wickets2.setText("" + w);
                }
            }
        }
    }

    public int check_wickets2(View view) {
        TextView wickets2 = (TextView) findViewById(R.id.play2wickets);
        String a = wickets2.getText().toString();
        int cw = Integer.parseInt(a);
        if (cw != 3)
            return 1;
        else
            return 0;

    }

}
