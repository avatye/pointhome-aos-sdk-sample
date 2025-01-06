package com.avatye.pointhome.pointhome.sample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.avatye.pointhome.PointHomeSDK
import com.avatye.pointhome.builder.DashboardStateListener
import com.avatye.pointhome.builder.IBuilderCallback
import com.avatye.pointhome.builder.PointHomeService
import com.avatye.pointhome.builder.PointHomeSlider
import com.avatye.pointhome.core.utils.error.PointHomeError
import com.avatye.pointhome.pointhome.sample.Additional.requestUserInfo

class MainActivity : AppCompatActivity() {
    // 1. 포인트홈 객체 선언
    var pointHomeSlider: PointHomeSlider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. 포인트홈 초기화 진행
        PointHomeService.pointHomeBuilder(
            this@MainActivity, // 포인트홈을 사용하는 Activity
            userKey = null, // userKey를 설정. 채널링이 아닌 경우 null.
            slideHeight = PointHomeSlider.SlideHeight.DEFAULT, // 슬라이드 비율 설정
            iBuilderCallback = object : IBuilderCallback {
                override fun onBuildCompleted(builder: PointHomeSlider) {
                    // 포인트홈 초기화 성공! 포인트홈 객체 반환.
                    pointHomeSlider = builder
                }

                override fun onBuildFailed(reason: PointHomeError) {
                    // 포인트홈 초기화 실패! 오류 반환. 연동 오류 페이지 참조.
                }
            }
        )
        // 레이아웃 설정 종료

        // 포인트홈 리스너 설정
        pointHomeSlider?.dashboardStateListener = object : DashboardStateListener {
            override fun openFail(reason: PointHomeError) {
                // 포인트홈 실행 실패 에러 로그 출력
                Log.d("Error Log Example",
                    """
            Error Message: ${reason.message}
            Error Type: ${reason.errorType}
            Error Code: ${reason.errorCode}
            """.trimIndent())
            }

            override fun dashboardOpen(caller: PointHomeSDK.CallResource) {
                // 포인트홈이 열린 경우, 발생 원인 로그 출력
                Log.d("Open Log Example", "Opened by: " + caller.name)
            }

            override fun dashboardClose(caller: PointHomeSDK.CallResource) {
                // 포인트홈이 닫힌 경우, 발생 원인 로그 출력
                Log.d("Close Log Example", "Closed by: " + caller.name)
            }
        }

        findViewById<Button>(R.id.start).setOnClickListener {
            pointHomeSlider?.dashboardOpen()
        }

        findViewById<Button>(R.id.request).setOnClickListener {
            requestUserInfo()
        }

    }
}