package com.api.acqio.web;

import com.api.acqio.dto.CardDTO;
import com.api.acqio.representation.CardRepresentation;
import com.api.acqio.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaction")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping
    public ResponseEntity<CardRepresentation> saveCard(@Valid @RequestBody CardDTO input) {
        return new ResponseEntity<>(
            cardService.from(cardService.save(input)),
                HttpStatus.OK
        );
    }

    @GetMapping
    public String teste() {
        return "ok";
    }

}
