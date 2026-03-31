package com.example.pr_webhook.dto.response;

import com.example.pr_webhook.domain.report.Report;
import com.example.pr_webhook.domain.report.ReportStatus;
import com.example.pr_webhook.domain.report.ReportType;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ReportResponse {
    private Long id;
    private String title;
    private ReportType type;
    private ReportStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
    private String content;

    public ReportResponse(Report report) {
        this.id = report.getId();
        this.title = report.getTitle();
        this.type = report.getType();
        this.status = report.getStatus();
        this.createdAt = report.getCreatedAt();
        this.completedAt = report.getCompletedAt();
        this.content = report.getContent();
    }
}
