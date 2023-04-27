package com.effourt.calenkit.client;

import com.effourt.calenkit.dto.AuthUserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakaoApi", url = "https://kapi.kakao.com")
public interface KakaoApiClient {

    @PostMapping("/v2/user/me")
    String getAuthUserInfo(
            @RequestHeader("Authorization") String accessToken,
            @RequestParam("property_keys") String propertyKeys
    );

    @PostMapping("/v1/user/logout")
    Long logout(
            @RequestHeader("Authorization") String accessToken
    );
}
