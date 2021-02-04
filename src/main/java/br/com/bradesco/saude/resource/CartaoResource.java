package br.com.bradesco.saude.resource;

import br.com.bradesco.saude.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
public class CartaoResource {

    private final CartaoService cartaoService;

    @Autowired
    public CartaoResource(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @GetMapping(value = "/upload")
    public ResponseEntity<?> upload() {
        return ResponseEntity.status(HttpStatus.OK).
                body(cartaoService.gerarImagem());
    }
}
