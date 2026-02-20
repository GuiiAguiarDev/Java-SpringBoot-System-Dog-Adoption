package com.dog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.entity.Tutor;

@Repository
public interface RepositoryTutor extends JpaRepository<Tutor, Long> {

}
