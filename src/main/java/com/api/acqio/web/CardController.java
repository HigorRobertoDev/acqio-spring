package com.api.acqio.web;

import com.api.acqio.dto.CardDTO;
import com.api.acqio.representation.CardRepresentation;
import com.api.acqio.service.CardService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    @Transactional
    public ResponseEntity<CardRepresentation> saveCard(@RequestBody CardDTO input) throws NotFoundException {
        return new ResponseEntity<>(
                cardService.save(input),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    @PreAuthorize("hasRole('admin')")
    @Transactional
    public ResponseEntity<CardRepresentation> updateCard(@RequestBody CardDTO input) throws NotFoundException {
        return new ResponseEntity<>(
                cardService.save(input),
                HttpStatus.OK
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<CardRepresentation>> allCard() {
        return new ResponseEntity<>(
                cardService.getAll(),
                HttpStatus.OK
        );
    }

}
