package com.example.pr_webhook.service;

import com.example.pr_webhook.domain.report.Report;
import com.example.pr_webhook.domain.report.ReportRepository;
import com.example.pr_webhook.domain.report.ReportStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final ReportRepository reportRepository;

    @Async
    @Transactional
    public void processReport(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));

        report.updateStatus(ReportStatus.PROCESSING);
        
        try {
            // Simulate processing time
            Thread.sleep(2000);
            
            String content = generateMockContent(report);
            report.updateContent(content);
            report.updateStatus(ReportStatus.COMPLETED);
            
        } catch (Exception e) {
            report.updateStatus(ReportStatus.FAILED);
        }
    }

    private String generateMockContent(Report report) {
        return switch (report.getType()) {
            case PULL_REQUEST_STATS -> "{\"totalPRs\": 50, \"merged\": 45, \"open\": 5}";
            case REVIEWER_ACTIVITY -> "{\"topReviewer\": \"user1\", \"reviews\": 120}";
            case MERGE_LATENCY -> "{\"averageHours\": 4.5}";
            case TEAM_PERFORMANCE -> "{\"velocity\": 85.5}";
        };
    }
}
