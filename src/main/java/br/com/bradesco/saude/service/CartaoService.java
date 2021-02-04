package br.com.bradesco.saude.service;


import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartaoService {

    public byte[] gerarImagem() {
        byte[] retorno = null;

        String diretorio = "G:\\projetos\\bradesco-saude\\src\\main\\resources";

        String relatorio = diretorio + "/report/cartao_27.jasper";
        String imagem = diretorio + "/img/27.png";
        try {

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


            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/temp/cartao.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

}
