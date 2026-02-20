package com.dog;

import com.dog.entity.Dog;
import com.dog.entity.Tutor;
import com.dog.repository.RepositoryTutor;
import com.dog.service.ServiceDog;
import com.dog.service.ServiceTutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DogApplication implements CommandLineRunner {

	private final RepositoryTutor repositoryTutor;

	private final ServiceTutor serviceTutor;
	private final ServiceDog serviceDog;

	public DogApplication(ServiceTutor serviceTutor, ServiceDog serviceDog, RepositoryTutor repositoryTutor) {

		this.serviceTutor = serviceTutor;
		this.serviceDog = serviceDog;
		this.repositoryTutor = repositoryTutor;

	}

	public static void main(String[] args) {
		SpringApplication.run(DogApplication.class, args);

	}

	public void run(String... args) throws Exception {

		// Objects
		Tutor t = new Tutor();
		//Como to usando while, declaro fora e instancio no while igual abaixo
		Dog dog = new Dog();

		Scanner sc = new Scanner(System.in);

		// Constant and variables
		String welcome = "bem vindo ao sistema:";
		char respDog = 's';
		int respAcaoTutor = 0;

		// System Employee
		System.out.println("Welcome Employee, let register Dogs in System");
		while (respDog != 'n') {
			dog = new Dog();
			System.out.println("Whats is name Dog?");
			String nameDog = sc.next();
			System.out.println("What the dog age?");
			int ageDog = sc.nextInt();
			System.out.println("What is the color?");
			String color = sc.next();
			System.out.println("What is the breed?");
			String bleed = sc.next();

			dog.setName(nameDog);
			dog.setAge(ageDog);
			dog.setColor(color);
			dog.setBreed(bleed);
			serviceDog.save(dog);
			System.out.println("---------------------------");
			System.out.println("---------------------------");
			System.out.println("Deseja cadastrar mais algum pet?");
			respDog = sc.next().charAt(0);
		}

		// System Client
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println("Adote!");
		System.out.println("Seja bem vindo, cadastra-se para adotar!");
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println();

		System.out.println("what is your name?");
		String name = sc.next();
		System.out.println("What is your address, enoth number?");
		String add = sc.next();
		System.out.println("What is your profession?");
		String profession = sc.next();
		System.out.println("Qua is your salary?");

		Double salary = sc.nextDouble();
		t.setName(name);
		t.setAddress(add);
		t.setProfession(profession);
		t.setSalary(salary);
		t.addDogs(dog);
		serviceTutor.save(t);

		System.out.println(welcome.toString().toUpperCase() + name);

		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");

		System.out.println("Lista de Dogs disponiveis");
		System.out.println(serviceDog.list(dog));
		System.out.println("Deseja Adotar - 1/sim - 2/não");
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");
		respAcaoTutor = sc.nextInt();
		int respListDog = 1;

		while (respListDog == 1) {

			System.out.println("Qual nome do pet?");
			String searchName = sc.next();
			System.out.println("Informations Dog:" + "\n " + serviceDog.findByname(searchName));
			System.out.println("Deseja adota-lo - 1/Sim - 2/Não");
			int adoptResp = sc.nextInt();
			if (adoptResp == 1) {
				/*
				 * serviceDog.adotar(searchName);
				 */
				serviceDog.adotarDog(searchName);
				System.out.println("Adotado");
				respListDog = 0;
				System.out.println("Volte sempre");
			} else {
				System.out.println("Gostaria de ver novamente a lista de dogs disponiveis?" + "\n" + "1/sim - 2/não");
				respListDog = sc.nextInt();
			}

		}
	}

}
