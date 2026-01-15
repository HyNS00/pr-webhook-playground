package com.example.pr_webhook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/webhook")
public class GitHubWebhookController {
    @PostMapping("/github")
    public String handleWebhook(
            @RequestHeader(value = "X-GitHub-Event", required = false) String eventType,
            @RequestHeader(value = "X-GitHub-Action", required = false) String action,
            @RequestHeader(value = "X-PR-Number", required = false) String prNumber,
            @RequestBody String payload
    ) {
        log.info("========================================");
        log.info("Event: {} | Action: {} | PR: {}", eventType, action, prNumber);
        log.info("========================================");
        log.info("Payload: {}", payload);

        return "OK";
    }
}

