package com.zakia.motors.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomMoto", types = { Motor.class })
public interface MotorProjection {
	public String getNomMotors();
}
