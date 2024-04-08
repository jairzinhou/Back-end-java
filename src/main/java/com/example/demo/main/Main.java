package com.example.demo.main;
import com.example.demo.model.DadosModelos;
import com.example.demo.model.DadosTipos;
import com.example.demo.service.ConsumoApi;
import com.example.demo.service.ConverteDados;

import java.util.Scanner;

public class Main {
    public void executarCodigo(){
        Scanner leitura = new Scanner(System.in);
        ConsumoApi dadosJson = new ConsumoApi();
        ConverteDados converteDados = new ConverteDados();

        System.out.println("Digite a opção de veiculo: (1) Carro, (2) Moto ou (3) caminhão");
        String opcaoVeiculo = leitura.nextLine();
        String tipo = null;

        if (opcaoVeiculo.equals("1")){
            tipo = "carros";

        } else if (opcaoVeiculo.equals("2")) {
            tipo="motos";
        }else {
            tipo="caminhoes";
        }
        String json = dadosJson.ConsumirApi("https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas");

        var marcas = converteDados.obterLista(json,DadosTipos.class);
        marcas.forEach(System.out::println);

        System.out.println("Digite o codigo do modelo: ");
        String opcaoModelo = leitura.nextLine();
        String jsonModelo = dadosJson.ConsumirApi("https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas/"+opcaoModelo+ "/modelos");
        var modelos = converteDados.obterDados(jsonModelo, DadosModelos.class);

        modelos.modelos()
    }
}
