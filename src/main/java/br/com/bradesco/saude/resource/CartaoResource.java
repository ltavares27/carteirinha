package br.com.bradesco.saude.resource;

import br.com.bradesco.saude.service.CartaoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/cartoes")
public class CartaoResource {

    private final CartaoService cartaoService;

    @Autowired
    public CartaoResource(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }


    @GetMapping(value = "/upload")
    public ResponseEntity<?> gerarJasper() {
        return ResponseEntity.ok(this.cartaoService.montarParametrosCrtao());
    }

/*    @GetMapping(value = "/gerar/jasper")
    public ResponseEntity<?> gerarJasper() {

        byte[] dados = this.cartaoService.gerarJasper();
        if (dados != null) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=cartao_bradesco.pdf".replace(" ", "_"))
                    .contentLength(dados.length).body(dados);
        }
        return ResponseEntity.badRequest().build();
    }*/
}
