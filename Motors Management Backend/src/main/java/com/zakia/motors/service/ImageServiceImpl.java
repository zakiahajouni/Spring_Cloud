package com.zakia.motors.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zakia.motors.entities.Image;
import com.zakia.motors.entities.Motor;
import com.zakia.motors.repos.ImageRepository;
import com.zakia.motors.repos.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    MotorRepository motorRepository;

    @Autowired
    MotorService motorService;
    @Override

    public Image uplaodImageMotor(MultipartFile file,Long idProd)
            throws IOException {
        Motor p = new Motor();
        p.setIdMotors(idProd);
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .motor(p).build() );
    }


    @Override
    public List<Image> getImagesParMotor(Long prodId) {
        Motor p = motorRepository.findById(prodId).get();
        return p.getImages();
    }

    @Override
    public Image uplaodImage(MultipartFile file) throws IOException {
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes()).build() );
    }

    @Override
    public Image getImageDetails(Long id) throws IOException{
        final Optional<Image> dbImage = imageRepository. findById (id);
        return Image.builder()
                .idImage(dbImage.get().getIdImage())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(dbImage.get().getImage()).build() ;
    }
    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException{
        final Optional<Image> dbImage = imageRepository. findById (id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(dbImage.get().getImage());
    }
    @Override
    public void deleteImage(Long id) {




        imageRepository.deleteById(id);
    }
}
