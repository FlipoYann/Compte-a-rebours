package com.yann.compte_a_rebours;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 02/02/2018.
 */

public class LoadingTask extends AsyncTask<Object, Integer, Integer> {
    private final Context context;
    private final TextView time;
    private final Button btn;
    private final TextView txt;

    public LoadingTask(Context context, TextView time, Button btn, TextView txt) {
        this.btn = btn;
        this.time = time;
        this.context = context;
        this.txt = txt;
    }

    @Override
    protected String doInBackground(Object[] objects) {
        Integer progress = Integer.parseInt(objects[0].toString());

        for (int i = progress;i == 0; i--) {
            publishProgress(i);
        }
        return "Finished";
    }

    @Override
    protected void onPreExecute() {
        btn.setText("Cancel");

    }

    @Override
    protected void onPostExecute(String s) {
        btn.setText("Start");
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        txt.setText(values.toString());
    }

    @Override
    protected void onCancelled() {
        btn.setText("Start");
        Toast.makeText(context, "Canceled", Toast.LENGTH_SHORT).show();

    }
}
