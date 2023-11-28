package com.zakia.motors.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zakia.motors.entities.Motor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage ;
    private String name ;
    private String type ;
    @Column( name = "IMAGE" , length = 4048576 )
    @Lob
    private byte[] image;
    @ManyToOne()
    @JoinColumn (name="MOTOR_ID")
    @JsonIgnore
    private Motor motor;


}