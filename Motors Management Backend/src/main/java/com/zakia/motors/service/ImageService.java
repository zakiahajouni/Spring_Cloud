package com.zakia.motors.service;

import java.io.IOException;
import java.util.List;

import com.zakia.motors.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
public interface ImageService {
    Image uplaodImage(MultipartFile file) throws IOException;
    Image getImageDetails(Long id) throws IOException;
    ResponseEntity<byte[]> getImage(Long id) throws IOException;
    void deleteImage(Long id) ;
    Image uplaodImageMotor(MultipartFile file,Long idProd) throws IOException;
    List<Image> getImagesParMotor(Long prodId);


}

