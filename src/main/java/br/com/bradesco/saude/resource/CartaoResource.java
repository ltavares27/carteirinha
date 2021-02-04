package br.com.bradesco.saude.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
public class CartaoResource {

    @PostMapping(value = "/upload")
    public ResponseEntity<?> upload() {



        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Ocorreu um erro ao gerar o cartao!");
    }
}
