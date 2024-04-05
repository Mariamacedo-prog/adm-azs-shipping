package com.avaliacao.azship.aplicacao.adaptadores.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/frete")
public class FreteController {

	@GetMapping
    String getProdutos() {
        return "Hello world";
    }
}
