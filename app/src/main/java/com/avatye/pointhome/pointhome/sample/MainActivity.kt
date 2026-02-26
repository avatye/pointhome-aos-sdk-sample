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
import com.avatye.pointhome.builder.PointHomeActivityBuilder
import com.avatye.pointhome.builder.PointHomeService
import com.avatye.pointhome.builder.PointHomeSlider
import com.avatye.pointhome.core.utils.error.PointHomeError
import com.avatye.pointhome.pointhome.sample.Additional.requestUserInfo

class MainActivity : AppCompatActivity(), DashboardStateListener {
    // 1. 포인트홈 객체 선언
    var pointHomeBuilder: PointHomeActivityBuilder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.start).setOnClickListener {
            pointHomeBuilder = PointHomeActivityBuilder.with(this@MainActivity)
                .listener(this@MainActivity)

            pointHomeBuilder?.start()

            // 또는 플로팅 버튼 생성
            /*pointHomeBuilder?.showAsFloatingButton {

            }*/
        }

        findViewById<Button>(R.id.request).setOnClickListener {
            requestUserInfo()
        }

    }

    override fun dashboardClose(caller: PointHomeSDK.CallResource) {

    }

    override fun dashboardOpen(caller: PointHomeSDK.CallResource) {

    }

    override fun openFail(reason: PointHomeError) {

    }
}