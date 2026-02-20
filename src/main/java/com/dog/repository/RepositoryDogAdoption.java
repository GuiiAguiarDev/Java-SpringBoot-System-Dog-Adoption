package com.dog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.entity.DogAdoption;

@Repository
public interface RepositoryDogAdoption extends JpaRepository<DogAdoption, Long> {

}
