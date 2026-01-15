package com.example.pr_webhook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/webhook")
public class GitHubWebhookController {
    @PostMapping("/github")
    public String handleWebhook(
            @RequestHeader("X-GitHub-Event") String eventType,
            @RequestBody String payload
    ) {
        log.info("=== GitHub Event: {} ===", eventType);
        log.info("Payload: {}", payload);

        return "OK";
    }
}

