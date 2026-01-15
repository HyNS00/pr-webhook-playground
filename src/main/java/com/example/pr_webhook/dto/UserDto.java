package com.example.pr_webhook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String login;

    @JsonProperty("avatar_url")
    private String avatarUrl;
}
