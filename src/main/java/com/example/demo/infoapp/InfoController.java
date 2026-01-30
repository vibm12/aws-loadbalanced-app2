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

        String az = readMetadata("placement/availability-zone");
        String region = az.substring(0, az.length() - 1);

        response.put("region", region);
        response.put("availabilityZone", az);

        return response;
    }

    private String readMetadata(String path) throws Exception {
        URL url = new URL("http://169.254.169.254/latest/meta-data/" + path);
        return new BufferedReader(new InputStreamReader(url.openStream()))
                .readLine();
    }
}
