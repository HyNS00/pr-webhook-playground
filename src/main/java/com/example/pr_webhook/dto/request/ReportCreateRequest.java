package com.example.pr_webhook.dto.request;

import com.example.pr_webhook.domain.report.ReportType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReportCreateRequest {
    private String title;
    private ReportType type;
}
