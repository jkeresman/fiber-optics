package com.jk.optics.fiberoptics.converter;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/zadatak/convert")
@AllArgsConstructor
public class ConverterController {

    private final ConverterService converterService;

    @PostMapping()
    public ResponseEntity<BigDecimal> convertToDBW(@RequestBody ConverterRequest converterRequest) {
        System.out.println(converterRequest.toString());
        BigDecimal response = converterService.convertToDbW(converterRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
