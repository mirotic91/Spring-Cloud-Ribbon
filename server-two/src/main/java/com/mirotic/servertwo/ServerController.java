package com.mirotic.servertwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ServerController {

    @Autowired
    private Environment env;

    @GetMapping("/where")
    public String where() {
        String nowAt = LocalDateTime.now().toString();
        String port = env.getProperty("server.port");
        return String.format("[%s] This server is localhost:%s", nowAt, port);
    }

}
