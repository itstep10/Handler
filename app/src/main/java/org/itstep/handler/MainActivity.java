package org.itstep.handler;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    Handler h;
    TextView tvInfo;
    Button btnStart;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1
        setContentView(R.layout.main);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        //2
//        setContentView(R.layout.main);
//        tvInfo = (TextView) findViewById(R.id.tvInfo);
//        btnStart = (Button) findViewById(R.id.btnStart);
//        h = new Handler() {
//            public void handleMessage(android.os.Message msg) {
//                // обновляем TextView
//                tvInfo.setText("Закачано файлов: " + msg.what);
//                if (msg.what == 10) btnStart.setEnabled(true);
//            };
//        };
    }

    public void onclick(View v) {
        //1
        switch (v.getId()) {
            case R.id.btnStart:
                for (int i = 1; i <= 10; i++) {
                    // долгий процесс
                    downloadFile();
                    // обновляем TextView
                    tvInfo.setText("Закачано файлов: " + i);
                    // пишем лог
                    Log.d(LOG_TAG, "Закачано файлов: " + i);
                }
                break;
            case R.id.btnTest:
                Log.d(LOG_TAG, "test");
                break;
            default:
                break;
        }

        //2
        // btnStart.setEnabled(false);

        //3
//        switch (v.getId()) {
//            case R.id.btnStart:
//                Thread t = new Thread(new Runnable() {
//                    public void run() {
//                        for (int i = 1; i <= 10; i++) {
//                            // долгий процесс
//                            downloadFile();
//                            // обновляем TextView
//                            tvInfo.setText("Закачано файлов: " + i);
//                            // пишем лог
//                            Log.d(LOG_TAG, "i = " + i);
//                        }
//                    }
//                });
//                t.start();
//                break;
//            case R.id.btnTest:
//                Log.d(LOG_TAG, "test");
//                break;
//            default:
//                break;
//        }
    }

    void downloadFile() {
        // пауза - 1 секунда
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}