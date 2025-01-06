package com.avatye.pointhome.pointhome.sample;

import com.avatye.pointhome.builder.PointHomeService;
import com.avatye.pointhome.builder.UserProfileCallback;
import com.avatye.pointhome.core.utils.error.PointHomeError;

import org.json.JSONObject;

public class Additional {

    // 사용자 정보 조회를 위한 메서드
    public static void requestUserInfo() {
        // UserProfileCallback 인터페이스 구현
        UserProfileCallback userCallback = new UserProfileCallback() {
            @Override
            public void success(JSONObject result) {
                // 성공적으로 데이터를 받았을 때의 로직
                System.out.println("Profile data successfully retrieved: " + result);
            }

            @Override
            public void fail(PointHomeError reason) {
                // 데이터를 받는 데 실패했을 때의 로직
                System.out.println("Failed to retrieve profile data: " + reason.getMessage());
            }
        };

        // 리소스 열거형 인스턴스 지정
        PointHomeService.Resource[] requiredResources = {
                PointHomeService.Resource.PROFILE,
                PointHomeService.Resource.CASH,
                PointHomeService.Resource.BUTTON,
                PointHomeService.Resource.TICKET
        };

        // getUserProfile 함수 호출
        PointHomeService.getUserProfile(null, requiredResources, userCallback);
    }
}