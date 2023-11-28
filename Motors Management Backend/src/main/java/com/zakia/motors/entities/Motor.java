package com.zakia.motors.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Motor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMotors;
	private String nomMotors;
	private Double prixMotors;
	private Date dateCreation;
	@ManyToOne
	private Type type;
	@OneToMany (mappedBy = "motor")
	private List<Image> images;
	
	
	public Motor() {
		super();
	}
	
	
	public Motor(String nomMotors, Double prixMotors, Date dateCreation) {
		super();
		this.nomMotors = nomMotors;
		this.prixMotors = prixMotors;
		this.dateCreation = dateCreation;
	}


	public Long getIdMotors() {
		return idMotors;
	}
	public void setIdMotors(Long idMotors) {
		this.idMotors = idMotors;
	}
	public String getNomMotors() {
		return nomMotors;
	}
	public void setNomMotors(String nomMotors) {
		this.nomMotors = nomMotors;
	}
	public Double getPrixMotors() {
		return prixMotors;
	}
	public void setPrixMotors(Double prixMotors) {
		this.prixMotors = prixMotors;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Motor [idMotors=" + idMotors + ", nomMotors=" + nomMotors + ", prixMotors=" + prixMotors
				+ ", dateCreation=" + dateCreation + "]";
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	private String imagePath;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
