package com.example.pr_webhook.controller;

import com.example.pr_webhook.dto.request.ReportCreateRequest;
import com.example.pr_webhook.dto.response.ReportResponse;
import com.example.pr_webhook.dto.response.ReportSummary;
import com.example.pr_webhook.service.AnalyticsService;
import com.example.pr_webhook.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final AnalyticsService analyticsService;

    @PostMapping
    public ResponseEntity<Long> createReport(@RequestBody ReportCreateRequest request) {
        Long id = reportService.createReport(request);
        analyticsService.processReport(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<ReportResponse>> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportResponse> getReport(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.getReport(id));
    }

    @GetMapping("/summary")
    public ResponseEntity<ReportSummary> getSummary() {
        return ResponseEntity.ok(reportService.getSummary());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
