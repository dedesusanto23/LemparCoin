package com.example.lemparcoindede;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LemparCoin extends Activity implements View.OnClickListener {
    private Button buttonLempar;
    private Button buttonUlang;
    private Button buttonKeluar;
    private Random acak;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acak= new Random();
        setContentView(R.layout.activity_lemparcoin);
        buttonLempar=(Button)findViewById(R.id.buttonlempar);
        buttonUlang=(Button)findViewById(R.id.buttonulang);
        buttonKeluar=(Button)findViewById(R.id.buttonkeluar);
        buttonLempar.setOnClickListener(this);
        buttonUlang.setOnClickListener(this);
        buttonKeluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view==buttonLempar) {

            Log.d("CLICK_EVENT", "Lempar button diClick");
            TextView tw=(TextView)findViewById(R.id.textView);
            ImageView im=(ImageView)findViewById(R.id.imageView);

            if (acak.nextDouble() < 0.5) {
                tw.setText("Kepala");
                im.setImageResource(R.drawable.head);
            } else {
                tw.setText("Cross");
                im.setImageResource(R.drawable.tail);
            }

            buttonLempar.setVisibility(view.INVISIBLE);
            buttonUlang.setVisibility(view.VISIBLE);
            buttonKeluar.setVisibility(view.VISIBLE);

        } else if (view==buttonUlang) {

            TextView tw = (TextView) findViewById(R.id.textView);
            ImageView im = (ImageView) findViewById(R.id.imageView);

            buttonLempar.setVisibility(View.VISIBLE);
            buttonUlang.setVisibility(view.INVISIBLE);
            buttonKeluar.setVisibility(View.INVISIBLE);

        }else if (view==buttonKeluar){
            this.finish();
        }

    }
}
