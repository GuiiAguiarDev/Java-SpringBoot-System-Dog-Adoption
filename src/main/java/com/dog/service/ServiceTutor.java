package com.dog.service;

import org.springframework.stereotype.Service;

import com.dog.entity.Tutor;
import com.dog.repository.RepositoryTutor;



@Service
public class ServiceTutor {

	private final RepositoryTutor repositoryTuto;
	
	
	public ServiceTutor(RepositoryTutor repositoryTuto) {

		this.repositoryTuto = repositoryTuto;
	}



	public Tutor save(Tutor tutor) {
		return repositoryTuto.save(tutor);
	}


	
}
