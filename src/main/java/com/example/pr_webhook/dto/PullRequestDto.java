package com.example.pr_webhook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PullRequestDto {
    private String title;
    private String body;
    private String state;

    private Integer additions;
    private Integer deletions;

    @JsonProperty("changed_files")
    private Integer changedFiles;

    private BranchDto head;
    private BranchDto base;
    private UserDto user;
}
