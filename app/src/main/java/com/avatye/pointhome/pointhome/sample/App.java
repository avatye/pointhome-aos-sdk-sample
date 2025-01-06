package com.avatye.pointhome.pointhome.sample;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.avatye.pointhome.PointHomeSDK;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // initialize
        PointHomeSDK.initializer(
                this,
                "5c57c5073a5346e89d59770c23d3c846",  // appID
                "b9873d6f30b24e5c"  // appSecret
        );

        PointHomeSDK.setLogTrace(true);
        PointHomeSDK.setDevelopMode(true);

        //아래 리스너는 필요한 경우에만 구현합니다.
        //해당 리스너에 대한 설명은 각 페이지를 확인해주세요

        //포인트전환 리스너 설정.
        PointHomeSDK.setCashExchangeListener(new PointHomeSDK.ICashExchangeListener() {
            @Override
            public void onRequestExchange(@NonNull String s, @NonNull Function1<? super String, Unit> function1) {
                //포인트 전환 콜백 호출은 다음과 같이 가능합니다.
                //자세한 사항은 위 "포인트 전환 리스너 설정하기" 항목을 참고해주세요
                Log.d("onRequestExchange Log", s);
                function1.invoke("0000");
            }
        });
        //시스템 이벤트 리스너 설정하기
        PointHomeSDK.setSystemEventListener(new PointHomeSDK.ISystemEventListener() {
            @Override
            public void onSystemEvent(@NonNull String event) {
                Log.d("SystemEvent Log", event);
            }
        });

        //IFrameEvent 리스너 설정하기
        PointHomeSDK.setIFrameEventListener(new PointHomeSDK.IFrameEventListener() {
            @Override
            public void onIFrameEvent(@NonNull String event) {
                Log.d("IFrameEvent Log", event);
            }
        });
    }
}