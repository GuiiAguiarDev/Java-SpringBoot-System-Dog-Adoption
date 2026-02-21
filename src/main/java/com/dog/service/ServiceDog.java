package com.dog.service;

import java.util.List;
import com.dog.repository.RepositoryTutor;
import org.springframework.stereotype.Service;

import com.dog.entity.Dog;
import com.dog.entity.Tutor;
import com.dog.repository.RepositoryDog;

@Service
public class ServiceDog {

	private final RepositoryTutor repositoryTutor;

	private final RepositoryDog repositoryDog;

	public ServiceDog(RepositoryDog repositoryDog, RepositoryTutor repositoryTutor) {

		this.repositoryDog = repositoryDog;

		this.repositoryTutor = repositoryTutor;
	}

	public Dog save(Dog dog) {
		return repositoryDog.save(dog);
	}

	public List<Dog> list(Dog dog) {
		return repositoryDog.findAll();
	}

	// Metodo buscar pelo nome
	// Estamos bucando cachorro pelo nome
	// eae ele retorna a informção, é um buscar.
	public Dog findByname(String name) {
		return repositoryDog.findByName(name).orElseThrow(() -> new RuntimeException("Dog not found"));
	}

	// Metodo comentado - inicio

	/*
	 * Metodo que ele busca pelo nome se existir o nome ele simplesmente remove do
	 * banco Assim fazendo o adotar fica como exemplo para outros caso tambem, como
	 * buscar um produto e comprar eae retirar do estoque diminuindo a quantidadeno
	 * banco Porem vamos comentar esse codigo abaixo, porque nao podemos nesse caso
	 * aqui remover do banco o cachorro pois assim vamos perder o registro dele
	 * então vamos apenas colocar nos status dele como adotado caso adote vou
	 * comentar esse codigo e fazer outro, mas fica como exemplo esse codigo abaixo
	 * de como pesquisar pelo nome e excluir, ainda posso usar para diminuir estoque
	 * public Dog adotar(String name) { Dog dog =
	 * repositoryDog.findByName(name).orElseThrow(() -> new
	 * RuntimeException("Dog not found"));
	 * 
	 * repositoryDog.deleteById(dog.getId());
	 * 
	 * return dog;
	 * 
	 * }
	 */

	// Metodo comentado - Fim

	// Metodo para quando adotar o dog, inserir true no atributo adotado (para deixar ele indisponivel)
	//e associar o relacionamento entre tutor e dog.
	public Dog adotarDog(String name, Long tutorId) {
		Dog dog = repositoryDog.findByName(name).orElseThrow(() -> new RuntimeException("Dog not found"));

		if (dog.getAdopted() == null) {
			// Fazer a associação do relacionamento correto entre tutor e dog, ou seja
			// mostrar corretamente
			// Qual tutor tem o dog e a qual tutor o dog pertence
			// e nao um dog ter o mesmo tutor, igual estava antes, o mesmo para todos
			// Então qualquer tipo de sistema que for ter relacionamento fazer igual desse
			// jeito abaixo
			// procurar igual abaixo e seta o valor
			Tutor tutor = repositoryTutor.findById(tutorId).orElseThrow(() -> new RuntimeException("Not found"));
			// Setando o valor
			dog.setTutor(tutor);
			dog.setAdopted(true);
			repositoryDog.save(dog);

		} else {
			System.out.println("Dog unavailable, please, adopte other dog!");
			
		}

		return dog;

	}

}
