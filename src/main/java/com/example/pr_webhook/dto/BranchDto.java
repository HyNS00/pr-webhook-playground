package com.example.pr_webhook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BranchDto {
    private String ref;
    private String sha;
}
