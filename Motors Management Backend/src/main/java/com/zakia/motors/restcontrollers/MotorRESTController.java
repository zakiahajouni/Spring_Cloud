package com.zakia.motors.restcontrollers;

import java.util.List;

import com.zakia.motors.dto.MotorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zakia.motors.entities.Motor;
import com.zakia.motors.service.MotorService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MotorRESTController {
	
	@Autowired

MotorService motorService ;
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<MotorDTO> getAllMotors()
	{
		
		return motorService.getAllMotors();
	}

	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public MotorDTO getMotorById(@PathVariable("id") Long id)
	{
	return motorService.getMotor(id);
	
	}
	@RequestMapping(path="/addmotor",method = RequestMethod.POST)
	public MotorDTO createMotor(@RequestBody MotorDTO motorDTO) {
	return motorService.saveMotor(motorDTO);
	}

	@RequestMapping(path="/updatemotor",method = RequestMethod.PUT)
	public MotorDTO updateMotor(@RequestBody MotorDTO motorDTO) {
	return motorService.updateMotor(motorDTO);
	}



	@RequestMapping(value="/delmotor/{id}",method = RequestMethod.DELETE)
	public void deleteMotor(@PathVariable("id") Long id)
	{
	motorService.deleteMotorById(id);
	}
	@RequestMapping(value="/motostyp/{idTyp}",method = RequestMethod.GET)
	public List<Motor> getMotorsByTypId(@PathVariable("idTyp") Long idTyp) {
	return motorService.findByTypeIdTyp(idTyp);
	}


}
