package com.mirotic.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.stream.IntStream;

@Component
public class ClientRunner implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) {

        IntStream.range(0, 30)
                .forEach(i -> {
                    try {
                        String response = restTemplate.getForObject("http://mirotic/where", String.class);
                        String result = String.format("%2d - %s", i + 1, response);
                        System.out.println(result);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                });
    }
}
