package br.com.eduardaperboire.todolist; // pacote onde a classe tá inserida

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // decorator/anotation (função) responsável pela execução da aplicação - define que essa classe é a inicial do projeto
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
