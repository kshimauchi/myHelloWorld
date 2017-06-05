package com.example.android.myhelloworld;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Create a button
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Add and Action Listener for the button*/
        addListenerOnButton();
        blink();

    }
    /*Add Action Listener method for the Button */
    private void addListenerOnButton() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kshimauchi.com"));
                startActivity(browserIntent);

            }//onClick
        });//setOnClickListener
    }//addListenerOnButton

    /*Blink */
    private void blink(){
        /* When you create a new Handler, it is bound to the thread /
        message queue of the thread that is creating it - */
        //https://stackoverflow.com/questions/9294112/how-to-make-the-textview-blinking
        //This can also be accomplished by using an animation.
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 1000;    //in milliseconds

                try{Thread.sleep(timeToBlink);}catch (Exception e) {}

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView txt = (TextView) findViewById(R.id.textView);
                        if(txt.getVisibility() == View.VISIBLE){
                            txt.setVisibility(View.INVISIBLE);
                        }else{
                            txt.setVisibility(View.VISIBLE);
                        }
                        blink();
                    }
                });
            }
        }).start();
    }
}



