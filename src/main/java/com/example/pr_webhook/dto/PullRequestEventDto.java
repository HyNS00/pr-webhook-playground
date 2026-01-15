package com.example.pr_webhook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PullRequestEventDto {
    private String action;
    private Integer number;

    @JsonProperty("pull_request")
    private PullRequestDto pullRequest;

    private RepositoryDto repository;
    private UserDto sender;
}
