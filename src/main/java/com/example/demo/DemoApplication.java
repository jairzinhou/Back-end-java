package com.example.demo;

import com.example.demo.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class,args);
	}

	@Override
	public void run(String... args){
		Main main = new Main();
		main.executarCodigo();
	}
}
