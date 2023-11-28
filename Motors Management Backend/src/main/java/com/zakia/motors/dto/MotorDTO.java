package com.zakia.motors.dto;
import java.util.Date;
import java.util.List;


import com.zakia.motors.entities.Image;
import com.zakia.motors.entities.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotorDTO {


        private Long idMotors;
        private String nomMotors;
        private Double prixMotors;
        private Date dateCreation;

        private Type type;
        private List<Image> images;
        private String nameTyp;
    }

