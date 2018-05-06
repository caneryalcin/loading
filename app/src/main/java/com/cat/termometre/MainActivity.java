package com.cat.termometre;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnKeyListener;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;


public class MainActivity extends AppCompatActivity {

    RingProgressBar ringProgressBar;
    EditText  editText;
    Button button;

    int progress = 0;


    Handler myHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0){

                if(progress<100){

                    ringProgressBar.setProgress(progress);


                }

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ringProgressBar = findViewById(R.id.progress_bar);

        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress = Integer.parseInt(editText.getText().toString());


            }
        });
        ringProgressBar.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {

                Toast.makeText(MainActivity.this, "Comlpleted", Toast.LENGTH_SHORT).show();

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i<100;i++){

                    try{
                    Thread.sleep(100);
                    myHandler.sendEmptyMessage(0);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }


            }
        }).start();




    }
}
