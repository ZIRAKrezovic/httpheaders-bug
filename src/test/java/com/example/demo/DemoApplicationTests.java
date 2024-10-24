package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    private WebTestClient webClient;

    @Test
    void contextLoads() {
        webClient.mutate().responseTimeout(Duration.ofHours(1)).build().get().uri("/").exchange().expectStatus().isNotFound();
    }

}
