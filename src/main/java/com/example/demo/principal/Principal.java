package com.example.demo.principal;

import com.example.demo.model.DadosEpisodio;
import com.example.demo.model.DadosSerie;
import com.example.demo.model.DadosTemporada;
import com.example.demo.service.ConsumoApi;
import com.example.demo.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY ="&apikey=8b2db37c";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    public void exibeMenu(){
        System.out.println("Digite o nome de um titulo: ");
        String serie = leitura.nextLine();
        String json = consumo.obterDados(ENDERECO +serie.replace(" ","+")+API_KEY);
        DadosSerie dadosSerie = converteDados.obterDados(json,DadosSerie.class);

        List<DadosTemporada> listaTemporadas = new ArrayList<>();

		for (int i = 1; i <=dadosSerie.totalTemporadas() ; i++) {
            json = consumo.obterDados(ENDERECO +serie.replace(" ","+")+"&season="+i+API_KEY);
			DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
			listaTemporadas.add(dadosTemporada);
		}

//        listaTemporadas.forEach(t->t.episodios().forEach(e-> System.out.println(e.titulo())));

    }
}
