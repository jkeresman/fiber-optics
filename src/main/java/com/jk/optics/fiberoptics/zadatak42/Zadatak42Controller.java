package com.jk.optics.fiberoptics.zadatak42;

import com.jk.optics.fiberoptics.config.StaticResourcesService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/zadatak/42")
@AllArgsConstructor
public class Zadatak42Controller {

    private final StaticResourcesService staticResourcesService;
    private final Zadatak42Service zadatak42Service;

    @GetMapping()
    public ResponseEntity<String> showMultiplicationPage() throws IOException {
        String html = staticResourcesService.readHtmlFile("zadatak38.html");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }

}
