package com.zakia.motors.service;

import java.util.List;

import com.zakia.motors.dto.MotorDTO;
import com.zakia.motors.entities.Motor;
import com.zakia.motors.entities.Type;

public interface MotorService {
	MotorDTO saveMotor(MotorDTO m);
	MotorDTO updateMotor(MotorDTO m);
	void deleteMotor(Motor m);
	void deleteMotorById(Long id);
	MotorDTO getMotor(Long id);
	List <MotorDTO> getAllMotors();
	List<Motor> findByNomMotor(String nom);
	List<Motor> findByNomMotorContains(String nom);
	List<Motor> findByNomPrix (String nom, Double prix);
	List<Motor> findByType (Type type);
	List<Motor> findByTypeIdTyp(Long id);
	List<Motor> findByOrderByNomMotorAsc();
	List<Motor> trierMotorsNomsPrix();
	MotorDTO convertEntityToDto (Motor motor);
	Motor convertDtoToEntity(MotorDTO motorDTO);


}
