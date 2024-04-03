package com.example.demo;

import com.example.demo.model.DadosSerie;
import com.example.demo.service.ConsumoApi;
import com.example.demo.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class,args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();

		//Scanner leitura = new Scanner(System.in);
		//System.out.println("Digite o nome de uma titulo");
		//String filme = leitura.nextLine();

		String url = "httpS://www.omdbapi.com/?t=gilmore+Girls&apikey=8b2db37c";

		String json = consumoApi.obterDados(url);

		ConverteDados conversor = new ConverteDados();

		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
