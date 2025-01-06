package com.avatye.pointhome.pointhome.sample;

import static com.avatye.pointhome.pointhome.sample.Additional.requestUserInfo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.avatye.pointhome.PointHomeSDK;
import com.avatye.pointhome.builder.DashboardStateListener;
import com.avatye.pointhome.builder.IBuilderCallback;
import com.avatye.pointhome.builder.PointHomeService;
import com.avatye.pointhome.builder.PointHomeSlider;
import com.avatye.pointhome.core.utils.error.PointHomeError;

public class MainActivity extends AppCompatActivity {

    // 1. 포인트홈 객체 선언
    private PointHomeSlider pointHomeSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 2. 포인트홈 초기화 진행
        PointHomeService.pointHomeBuilder(
                this, // 포인트홈을 사용하는 Activity
                null, // userKey를 설정. 채널링이 아닌 경우 null로 설정.
                PointHomeSlider.SlideHeight.DEFAULT, // 슬라이드 비율 설정
                new IBuilderCallback() {
                    @Override
                    public void onBuildCompleted(PointHomeSlider builder) {
                        // 포인트홈 초기화 성공! 포인트홈 객체가 반환됩니다.
                        pointHomeSlider = builder;
                    }

                    @Override
                    public void onBuildFailed(PointHomeError reason) {
                        // 포인트홈 초기화 실패! 오류가 반환됩니다 연동 오류 페이지를 참조해주세요.
                    }
                }
        );
        // 레이아웃 설정 종료 다음 페이지를 참조하여 추가 설정을 진행해주세요.

        // 오류 확인을 위한 리스너 등록
        if (pointHomeSlider != null) {
            pointHomeSlider.setDashboardStateListener(new DashboardStateListener() {
                @Override
                public void openFail(@NonNull PointHomeError reason) {
                    // 로그를 통해 포인트홈 에러 로그를 출력합니다.
                    Log.d("DashBoardState", "Error Log Example" +
                            reason.getMessage() + "\\n" +
                            reason.getErrorType() + "\\n" +
                            reason.getErrorCode());
                }

                @Override
                public void dashboardOpen(@NonNull PointHomeSDK.CallResource caller) {
                    // 포인트홈 open 이벤트에 대한 로그를 출력합니다.
                    Log.d("DashBoardState", "Open Log Example : " + caller.name());
                }

                @Override
                public void dashboardClose(@NonNull PointHomeSDK.CallResource caller) {
                    // 포인트홈 close 이벤트에 대한 로그를 출력합니다.
                    Log.d("DashBoardState", "Close Log Example : " + caller.name());
                }
            });
        }

        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointHomeSlider != null) {
                    pointHomeSlider.dashboardOpen();
                }
            }
        });

        Button requestButton = findViewById(R.id.request);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestUserInfo();
            }
        });
    }
}