package com.jk.optics.fiberoptics.zadatak43;

import com.jk.optics.fiberoptics.config.StaticResourcesService;
import com.jk.optics.fiberoptics.zadatak38.Zadatak38Service;
import com.jk.optics.fiberoptics.zadatak42.Zadatak42Request;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/zadatak/43")
@AllArgsConstructor
public class Zadatak43Controller {

    private final Zadatak43Service zadatak43Service;

    private final StaticResourcesService staticResourcesService;



    @PostMapping(path = "/calculate")
    public ResponseEntity<Zadatak43Response> izracunajZadatak43(@RequestBody Zadatak43Request zadatak43) {
        Zadatak43Response response = zadatak43Service.solve(zadatak43);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<String> getPageForZadatak43() throws IOException {
        String html = staticResourcesService.readHtmlFile("zadatak43.html");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }
}
