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

//gradle(Project) ve gradle(app) 'da eklentiler mevcuttur.
public class MainActivity extends AppCompatActivity {

    RingProgressBar ringProgressBar;
    EditText  editText;
    Button button;



    int progress = 0;


    //Handler view'e ulaşarak ringprogressbar'ın değerini değiştirir.
    Handler myHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0){

                ringProgressBar.setProgress(progress);

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
        //butona tıklandığında yapılacak işlemler.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress = Integer.parseInt(editText.getText().toString());
                ringProcess();

            }
        });

    }



    public void ringProcess(){
        //ringProgressBar %100 olduğunda tost mesajı gelir.
        ringProgressBar.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {

                Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();

            }
        });


        //Handler'ı thread yoluyla çağrılarak sendEmptyMessage ile yapılmak istenen değişiklikler yapılır.
        new Thread( new Runnable() {
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