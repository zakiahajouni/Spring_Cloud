package com.zakia.motors.entities;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idTyp;
private String nameTyp;
private String descriptionTyp;

@JsonIgnore

@OneToMany(mappedBy = "type")
private List<Motor> motors;
public Long getIdTyp() {
	return idTyp;
}
public void setIdTyp(Long idTyp) {
	this.idTyp = idTyp;
}
public String getNameTyp() {
	return nameTyp;
}
public void setNameTyp(String nameTyp) {
	this.nameTyp = nameTyp;
}
public String getDescriptionTyp() {
	return descriptionTyp;
}
public void setDescriptionTyp(String descriptionTyp) {
	this.descriptionTyp = descriptionTyp;
}
public List<Motor> getMotors() {
	return motors;
}
public void setMotors(List<Motor> motors) {
	this.motors = motors;
}





}
