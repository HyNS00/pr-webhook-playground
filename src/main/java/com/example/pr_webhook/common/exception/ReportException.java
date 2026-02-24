package com.example.pr_webhook.common.exception;

import lombok.Getter;

@Getter
public class ReportException extends RuntimeException {
    private final ErrorCode errorCode;

    public ReportException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
