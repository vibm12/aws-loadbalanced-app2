package com.example.demo.infoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
public class InfoController {

    @GetMapping("/")
    public Map<String, String> getInfo() throws Exception {
        Map<String, String> response = new HashMap<>();

        response.put("region", "ap-south-1");
        response.put("availabilityZone", "ap-south-1a");

        return response;
    }
}
