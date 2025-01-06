package com.avatye.pointhome.pointhome.sample

import com.avatye.pointhome.builder.PointHomeService
import com.avatye.pointhome.builder.UserProfileCallback
import com.avatye.pointhome.core.utils.error.PointHomeError
import org.json.JSONObject

object Additional {

    //사용자 정보 조회를 위한 인터페이스
    fun requestUserInfo() {
        // UserProfileCallback 인터페이스 구현
        val userCallback = object : UserProfileCallback {
            override fun success(result: JSONObject) {
                // 성공적으로 데이터를 받았을 때의 로직
                println("Profile data successfully retrieved: $result")
            }

            override fun fail(reason: PointHomeError) {
                // 데이터를 받는 데 실패했을 때의 로직
                println("Failed to retrieve profile data: ${reason.message}")
            }
        }

        // 리소스 열거형 인스턴스 지정
        val requiredResources = arrayOf(PointHomeService.Resource.PROFILE, PointHomeService.Resource.CASH, PointHomeService.Resource.BUTTON, PointHomeService.Resource.TICKET)

        // getUserProfile 함수 호출
        PointHomeService.getUserProfile(null, *requiredResources, profileCallback = userCallback)
    }
}