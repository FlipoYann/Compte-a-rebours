package com.yann.compte_a_rebours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView time;
    private Button btn;
    private TextView txt;
    private LoadingTask loadingTask = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt_fin);
        btn = (Button) findViewById(R.id.btn_launch);
        time = (TextView) findViewById(R.id.tps);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if (loadingTask == null) {
            loadingTask = new LoadingTask(this, time, btn, txt);
            loadingTask.execute(time);
        }else{
            loadingTask.cancel(true);
            loadingTask = null;
        }
    }
}
