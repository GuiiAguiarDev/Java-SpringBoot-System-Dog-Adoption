package com.dog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.entity.Dog;

@Repository
public interface RepositoryDog extends JpaRepository<Dog, Long> {

	// Metodo buscar pelo nome
	// Estamos bucando cachorro pelo nome, assim consigo fazer uma busca, quando
	// coloco nome
	// ele retorna o nome que inserimos, servindo como busca.
	// E podemos utilizar para buscar pelo nome e apagar por exemplo tambem
	// nesse caso como é um sistema de dog, caso exista o nome eu posso deletar
	// assim
	// fazendo como se fosse adotado, ai removo ele do banco, por exdemplo, eae
	// ficar
	// como exemplo para varios modelos
	Optional<Dog> findByName(String name);

}
