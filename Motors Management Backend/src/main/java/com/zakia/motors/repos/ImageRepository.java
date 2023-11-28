package com.zakia.motors.repos;

import com.zakia.motors.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ImageRepository extends JpaRepository<Image, Long> {
}