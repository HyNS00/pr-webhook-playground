package com.example.pr_webhook.service;

import com.example.pr_webhook.domain.report.Report;
import com.example.pr_webhook.domain.report.ReportRepository;
import com.example.pr_webhook.domain.report.ReportStatus;
import com.example.pr_webhook.dto.request.ReportCreateRequest;
import com.example.pr_webhook.dto.response.ReportResponse;
import com.example.pr_webhook.dto.response.ReportSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final ReportRepository reportRepository;

    @Transactional
    public Long createReport(ReportCreateRequest request) {
        Report report = Report.builder()
                .title(request.getTitle())
                .type(request.getType())
                .build();
        return reportRepository.save(report).getId();
    }

    public List<ReportResponse> getAllReports() {
        return reportRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(ReportResponse::new)
                .collect(Collectors.toList());
    }

    public ReportResponse getReport(Long id) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Report not found: " + id));
        return new ReportResponse(report);
    }

    public ReportSummary getSummary() {
        List<Report> all = reportRepository.findAll();
        return ReportSummary.builder()
                .totalReports(all.size())
                .completedReports(all.stream().filter(r -> r.getStatus() == ReportStatus.COMPLETED).count())
                .pendingReports(all.stream().filter(r -> r.getStatus() == ReportStatus.PENDING).count())
                .failedReports(all.stream().filter(r -> r.getStatus() == ReportStatus.FAILED).count())
                .build();
    }

    @Transactional
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
