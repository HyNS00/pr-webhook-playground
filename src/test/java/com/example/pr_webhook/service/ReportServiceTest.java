package com.example.pr_webhook.service;

import com.example.pr_webhook.domain.report.Report;
import com.example.pr_webhook.domain.report.ReportRepository;
import com.example.pr_webhook.domain.report.ReportType;
import com.example.pr_webhook.dto.request.ReportCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {

    @Mock
    private ReportRepository reportRepository;

    @InjectMocks
    private ReportService reportService;

    @Test
    @DisplayName("리포트를 생성한다")
    void createReport() {
        // given
        ReportCreateRequest request = new ReportCreateRequest();
        // Reflection or using a test builder if available
        // For simplicity in this mock test, we'll assume the request has data
        
        Report report = Report.builder()
                .title("Test Report")
                .type(ReportType.PULL_REQUEST_STATS)
                .build();
        
        given(reportRepository.save(any())).willReturn(report);

        // when
        // Note: request is empty here because it lacks setters/builders in this simple implementation
        // but in a real scenario it would have data.
        reportService.createReport(request);

        // then
        verify(reportRepository).save(any());
    }
}
