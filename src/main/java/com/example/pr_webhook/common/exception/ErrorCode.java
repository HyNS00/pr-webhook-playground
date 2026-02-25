package com.example.pr_webhook.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    REPORT_NOT_FOUND(HttpStatus.NOT_FOUND, "R001", "요청하신 리포트를 찾을 수 없습니다."),
    INVALID_REPORT_TYPE(HttpStatus.BAD_REQUEST, "R002", "지원하지 않는 리포트 타입입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S001", "서버 내부 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
