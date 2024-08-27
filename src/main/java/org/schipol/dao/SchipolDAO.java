package org.schipol.dao;

import org.schipol.model.Data;
import org.schipol.model.Flight;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SchipolDAO {
    WebClient webClient;
    private String appId, appKey, resourceVersion;

    public ResponseEntity<Data> getResponseBody(String uri) throws IOException {
        Properties properties = new Properties();
        String configFilePath = "config//api.properties";
        File ConfigFile = new File(configFilePath);

        FileInputStream configFileReader = new FileInputStream(ConfigFile);
        properties.load(configFileReader);

        appId = properties.getProperty("app_id");
        appKey = properties.getProperty("app_key");
        resourceVersion = properties.getProperty("ResourceVersion");

        webClient = WebClient.create();

        ResponseEntity<Data> flightsMono = webClient.get()
                .uri(uri).accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> {
                    httpHeaders.set("app_key", appKey);
                    httpHeaders.set("app_id", appId);
                    httpHeaders.set("ResourceVersion", resourceVersion);
                })
                .retrieve()
                .toEntity(Data.class)
                .block();

        return flightsMono;
    }
}
