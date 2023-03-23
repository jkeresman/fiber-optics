package com.jk.optics.fiberoptics.config;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StaticResourcesService {

    private static final String CLASSPATH = "classpath:/templates/%s";
    private final ResourceLoader resourceLoader;

    public String readHtmlFile(String filename) throws IOException {
        var resource = resourceLoader.getResource(String.format(CLASSPATH, filename));
        try (var reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
}
