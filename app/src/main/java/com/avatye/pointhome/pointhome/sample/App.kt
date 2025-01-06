package com.avatye.pointhome.pointhome.sample

import android.app.Application
import android.util.Log
import com.avatye.pointhome.PointHomeSDK
import com.avatye.pointhome.PointHomeSDK.setCashExchangeListener
import com.avatye.pointhome.PointHomeSDK.setDevelopMode
import com.avatye.pointhome.PointHomeSDK.setIFrameEventListener
import com.avatye.pointhome.PointHomeSDK.setLogTrace
import com.avatye.pointhome.PointHomeSDK.setSystemEventListener

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // 포인트홈 초기화를 시작합니다.
        PointHomeSDK.initializer(
            application = this,
            appID = "5c57c5073a5346e89d59770c23d3c846",
            appSecret = "b9873d6f30b24e5c"
        ).apply {
            //로그 설정
            setLogTrace(use = true)

            //개발환경 세팅값 설정
            setDevelopMode(value = true)

            //아래 리스너는 필요한 경우에만 구현합니다.
            //해당 리스너에 대한 설명은 가이드의 각 페이지를 확인해주세요.

            //포인트전환 리스너 설정.
            setCashExchangeListener(object : PointHomeSDK.ICashExchangeListener{
                override fun onRequestExchange(transactionID: String, onCompleted: (code: String) -> Unit) {
                    Log.d("onRequestExchange Log", transactionID)
                }
            })

            //시스템 이벤트 리스너 설정하기
            setSystemEventListener(object : PointHomeSDK.ISystemEventListener {
                override fun onSystemEvent(event: String) {
                    Log.d("SystemEvent Log", event)
                }
            })

            //IFrameEvent 리스너 설정하기
            setIFrameEventListener(object : PointHomeSDK.IFrameEventListener {
                override fun onIFrameEvent(event: String) {
                    Log.d("IFrameEvent Log", event)
                }
            })
        }
    }
}