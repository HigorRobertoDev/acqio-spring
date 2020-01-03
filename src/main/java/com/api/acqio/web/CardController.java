package com.api.acqio.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class CardController {

    @PostMapping
    public Ent

    @GetMapping
    public String teste() {
        return "ok";
    }

}
