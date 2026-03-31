package com.example.pr_webhook.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReportSummary {
    private long totalReports;
    private long completedReports;
    private long pendingReports;
    private long failedReports;
}
