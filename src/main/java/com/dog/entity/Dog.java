package com.dog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_DOG")
public class Dog {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(name = "TB_NAME")
	private String name;
	@Column(name = "TB_ADRESS")
	private Integer age;
	@Column(name = "TB_PROFESSION")
	private String color;
	@Column(name = "TB_SALARY")
	private String breed;
	private Boolean adopted;

	@JoinColumn(name = "tutor_id")
	@ManyToOne
	private Tutor tutor;

	public Dog() {
		super();
	}

	public Dog(Long id, String name, Integer age, String color, String breed, Boolean adopted, Tutor tutor) {

		this.id = id;
		this.name = name;
		this.age = age;
		this.color = color;
		this.breed = breed;
		this.adopted = adopted;
		this.tutor = tutor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Boolean getAdopted() {
		return adopted;
	}

	public void setAdopted(Boolean adopted) {
		this.adopted = adopted;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;

	}

	@Override
	public String toString() {
		return "\n" + "Nome:" + name + " - " + "Age:" + age + " - " + "Raça:" + breed;
	}

}