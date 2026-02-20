package com.dog.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_DOG_ADOPTION")
public class DogAdoption {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Column(name = "TB_NUMBER")
	private Integer number;
	@Column(name = "TB_DATE")
	private Date date;

	@JoinColumn(name = "TB_FK_TUTOR")
	@OneToOne
	private Tutor tutor;
	@OneToOne
	@JoinColumn(name = "TB_FK_DOG")
	private Dog dog;

	public DogAdoption() {

	}

	public DogAdoption(Long id, Integer number, Date date, Tutor tutor, Dog dog) {

		this.id = id;
		this.number = number;
		this.date = date;
		this.tutor = tutor;
		this.dog = dog;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

}
