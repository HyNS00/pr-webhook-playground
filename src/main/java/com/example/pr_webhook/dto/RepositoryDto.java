package com.example.pr_webhook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RepositoryDto {
    private Long id;
    private String name;

    @JsonProperty("full_name")
    private String fullName;
}
