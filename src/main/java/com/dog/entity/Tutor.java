package com.dog.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TUTOR")
public class Tutor {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Column(name = "TB_NAME")
	private String name;
	@Column(name = "TB_ADRESS")
	private String address;
	@Column(name = "TB_PROFESSION")
	private String profession;
	@Column(name = "TB_SALARY")
	private Double salary;

	@OneToMany(mappedBy = "tutor")
	private List<Dog> dogs = new ArrayList<>();

	public Tutor() {

	}

	public Tutor(Long id, String name, String address, String profession, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.profession = profession;
		this.salary = salary;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void addDogs(Dog dog) {
		this.dogs.add(dog);
	}

	@Override
	public String toString() {
		return "Tutor [id=" + id + ", name=" + name + ", address=" + address + ", profession=" + profession
				+ ", salary=" + salary + "]";
	}

}
