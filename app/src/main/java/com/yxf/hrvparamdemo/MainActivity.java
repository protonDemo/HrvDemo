package com.yxf.hrvparamdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.proton.ecg.hrvparams.HrvParamsHelper;
import com.proton.ecg.hrvparams.bean.HRVTimeModeOutput;
import com.proton.ecg.hrvparams.callback.HrvParamsResultListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());
        findViewById(android.R.id.content).setOnClickListener(v -> {
            invokeHrvParamsResult();
        });
    }

    private void invokeHrvParamsResult() {
        byte[] sourceData = new byte[1];//心电数据
        HrvParamsHelper.fetchHrvParamsOutput(sourceData, 256, new HrvParamsResultListener() {
            @Override
            public void onHrvTimeOutput(HRVTimeModeOutput hrvTimeModeOutput) {
                Logger.w("hrvTime:%s", hrvTimeModeOutput.toString());
            }
        });
    }

}