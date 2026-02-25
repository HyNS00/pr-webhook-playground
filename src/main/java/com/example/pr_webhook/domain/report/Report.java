package com.example.pr_webhook.domain.report;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportStatus status;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    @Builder
    public Report(String title, ReportType type) {
        this.title = title;
        this.type = type;
        this.status = ReportStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public void updateStatus(ReportStatus status) {
        this.status = status;
        if (status == ReportStatus.COMPLETED) {
            this.completedAt = LocalDateTime.now();
        }
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
