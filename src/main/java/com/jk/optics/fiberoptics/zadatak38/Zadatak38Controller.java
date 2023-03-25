package com.jk.optics.fiberoptics.zadatak38;

import com.jk.optics.fiberoptics.config.StaticResourcesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/zadatak/38")
@AllArgsConstructor
public class Zadatak38Controller {

    private final Zadatak38Service zadatak38Service;
    private final StaticResourcesService staticResourcesService;

    @PostMapping(path = "/calculate")
    public ResponseEntity<Zadatak38Response> izracunajZadatak38(@RequestBody Zadatak38Request Zadatak38Request) {
        Zadatak38Response response = zadatak38Service.solve(Zadatak38Request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<String> getPageForZadatak38() throws IOException {
            String html = staticResourcesService.readHtmlFile("zadatak38.html");
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_HTML)
                    .body(html);
        }




}
