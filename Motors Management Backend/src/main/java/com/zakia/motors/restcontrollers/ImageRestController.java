package com.zakia.motors.restcontrollers;

import com.zakia.motors.entities.Image;
import com.zakia.motors.entities.Motor;
import com.zakia.motors.service.ImageService;
import com.zakia.motors.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
    @Autowired
    ImageService imageService ;
    @Autowired
    MotorService motorService ;

    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
    @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id) ;
    }
    @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
    {
        return imageService.getImage(id);
    }


    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id){
        imageService.deleteImage(id);
    }
    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
    @PostMapping(value = "/uplaodImageMotor/{idMotor}" )
    public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
                                   @PathVariable("idMotor") Long idMotor)
            throws IOException {
        return imageService.uplaodImageMotor(file,idMotor);
    }
    @RequestMapping(value = "/getImagesMotor/{idMotor}" ,
            method = RequestMethod.GET)
    public List<Image> getImagesProd(@PathVariable("idMotor") Long idMotor)
            throws IOException {
        return imageService.getImagesParMotor(idMotor);
    }

   /* @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
    public void uploadImageFS(@RequestParam("image") MultipartFile
                                      file,@PathVariable("id") Long id) throws IOException {
        Motor p = motorService.getMotor(id);
        p.setImagePath(id+".jpg");

        Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
                , file.getBytes());
        motorService.saveMotor(p);

    }*/
    /*@RequestMapping(value = "/loadfromFS/{id}" ,
            method = RequestMethod.GET,
            produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

        Motor p = motorService.getMotor(id);
        return
                Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
    }*/





}

