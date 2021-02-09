package br.com.bradesco.saude.service;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Service
public class CartaoService {

    public String montarParametrosCrtao() {

        JasperPrint jasperPrint = new JasperPrint();

        String diretorio = "G:/projetos/bradesco-saude/src/main/resources";

        String relatorio = diretorio + "/report/27.jrxml";
        String imagem = diretorio + "/img/27.png";
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(relatorio);

            HashMap<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("imagemCartao", imagem);
            parametros.put("ramo", "EMPRESA");
            parametros.put("plano", "SAÚDE TOP");
            parametros.put("acomodacao", "QUARTO");
            parametros.put("seguroViagem", "SEGURO VIAGEM");
            parametros.put("redeDental", "TOP C/ ORTO");
            parametros.put("redeSaude", "NACIONAL PLUS");
            parametros.put("possuiDental", "DENTAL");
            parametros.put("dataValidade", "04/23");
            parametros.put("nomeEmpresa", "WARTSILA BRASIL LTDA");
            parametros.put("nomeTitular", "NOME ABREVIADO TITULAR");
            parametros.put("nomeDependente", "LUIS P S TAVARES");
            parametros.put("codTitular", "00");
            parametros.put("codDependente", "01");
            parametros.put("numeroCartao", "000 0000 0000 0000");

            jasperPrint = JasperFillManager.fillReport(jasperReport, parametros);

            gerarImagem(jasperPrint);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Carteirinha gerada com sucesso";
    }

    public void gerarImagem(JasperPrint jasperPrint) throws JRException, IOException {

        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

        JRGraphics2DExporter exporter = new JRGraphics2DExporter();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, (Graphics2D)image.getGraphics());
        exporter.setParameter(JRGraphics2DExporterParameter.ZOOM_RATIO, Float.valueOf(1));

        exporter.exportReport();

        ImageIO.write(image, "png", new File("G:/temp/image.png"));
    }

}
