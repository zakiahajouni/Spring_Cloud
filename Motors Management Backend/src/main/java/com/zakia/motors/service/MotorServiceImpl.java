package com.zakia.motors.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.zakia.motors.dto.MotorDTO;
import com.zakia.motors.repos.ImageRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zakia.motors.entities.Motor;
import com.zakia.motors.entities.Type;
import com.zakia.motors.repos.MotorRepository;
@Service
public class MotorServiceImpl implements MotorService{

	@Autowired
	MotorRepository motorRepository ;
	@Autowired
	ImageRepository imageRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public MotorDTO saveMotor(MotorDTO m) {
		return convertEntityToDto (motorRepository.save(convertDtoToEntity(m)));
	}

	@Override
	public MotorDTO updateMotor(MotorDTO p) {
	//	Long oldProdImageId =
			//	this.getMotor(p.getIdMotors()).getImage().getIdImage();
		//Long newProdImageId = p.getImage().getIdImage();
		//if (oldProdImageId != newProdImageId) //si l'image a été modifiée
			//imageRepository.deleteById(oldProdImageId);
		return convertEntityToDto(motorRepository.save(convertDtoToEntity(p)));

	}

	@Override
	public void deleteMotor(Motor m) {
		motorRepository.delete(m);
		}

	@Override
	public void deleteMotorById(Long id) {
		/*Motor p = getMotor(id);**$0
		//suuprimer l'image avant de supprimer le produit
		try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		motorRepository.deleteById(id);
		
	}

	@Override
	public MotorDTO getMotor(Long id) {
		return convertEntityToDto(motorRepository.findById(id).get());
	}

	@Override
	public List<MotorDTO> getAllMotors() {
		return motorRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());	}

	@Override
	public List<Motor> findByNomMotor(String nom) {
		
		return motorRepository.findByNomMotors(nom);
	}

	@Override
	public List<Motor> findByNomMotorContains(String nom) {
		
		return motorRepository.findByNomMotorsContains(nom);
	}

	@Override
	public List<Motor> findByNomPrix(String nom, Double prix) {

		return motorRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Motor> findByType(Type type) {
		
		return motorRepository.findByType(type);
	}

	@Override
	public List<Motor> findByTypeIdTyp(Long id) {
		
		return motorRepository.findByTypeIdTyp(id);
	}

	@Override
	public List<Motor> findByOrderByNomMotorAsc() {
		
		return motorRepository.findByOrderByNomMotorsAsc();
	}

	@Override
	public List<Motor> trierMotorsNomsPrix() {
		
		return motorRepository.trierMotorsNomsPrix();
	}



	@Override
	public MotorDTO convertEntityToDto(Motor motor) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		MotorDTO motorDTO = modelMapper.map(motor, MotorDTO.class);

		return motorDTO;


		/*MotorDTO motorDTO = new MotorDTO();
		motorDTO.setIdMotors(motor.getIdMotors());
		motorDTO.setNomMotors(motor.getNomMotors());
		motorDTO.setPrixMotors(motor.getPrixMotors());
		motorDTO.setDateCreation(motor.getDateCreation());
		motorDTO.setType(motor.getType());
		return motorDTO;*/

 /*return MotorDTO.builder()
.idMotors(motor.getIdMotors())
.nomMotors(motor.getNomMotors())
//.prixMotors(motor.getPrixMotors())
.dateCreation(motor.getDateCreation())
//.type(motor.getType())
		 .nameTyp(motor.getType().getNameTyp())
.build();*/

	}


		@Override
		public Motor convertDtoToEntity(MotorDTO motorDTO) {
			/*Motor motor = new Motor();
		motor.setIdMotors(motorDTO.getIdMotors());
		motor.setNomMotors(motorDTO.getNomMotors());
		motor.setPrixMotors(motorDTO.getPrixMotors());
		motor.setDateCreation(motorDTO.getDateCreation());
		motor.setType(motorDTO.getType());
		;*/
			Motor motor = new Motor();
			motor = modelMapper.map(motorDTO, Motor.class);
			return motor;}


}
