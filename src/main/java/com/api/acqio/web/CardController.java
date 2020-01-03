package com.api.acqio.web;

import com.api.acqio.domain.Card;
import com.api.acqio.dto.CardDTO;
import com.api.acqio.representation.CardRepresentation;
import com.api.acqio.service.CardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(
            value = "Faz uma nova transação",
            response = Card.class,
            notes = "Essa operação salva um novo registro com as informações da transação."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Retorna um Card com uma mensagem de sucesso",
                    response = Card.class
            ),
            @ApiResponse(
                    code = 500,
                    message = "Caso tenhamos algum erro vamos retornar um Card com a Exception",
                    response = Card.class
            )
    })
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
