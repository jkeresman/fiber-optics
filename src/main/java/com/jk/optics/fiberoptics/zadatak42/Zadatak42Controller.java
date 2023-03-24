package com.jk.optics.fiberoptics.zadatak42;

import com.jk.optics.fiberoptics.config.StaticResourcesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/zadatak/42")
@AllArgsConstructor
public class Zadatak42Controller {

    private final StaticResourcesService staticResourcesService;
    private final Zadatak42Service zadatak42Service;

    @PostMapping
    public ResponseEntity<BigDecimal> izracunajZadatak42(@RequestBody Zadatak42Request zadatak42) {
        BigDecimal response = zadatak42Service.solve(zadatak42);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<String> getPage() throws IOException {
        String html = staticResourcesService.readHtmlFile("zadatak42.html");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }

}
