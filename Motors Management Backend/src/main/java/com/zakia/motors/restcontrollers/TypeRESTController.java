package com.zakia.motors.restcontrollers;

import com.zakia.motors.entities.Type;
import com.zakia.motors.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/typ")
@CrossOrigin("*")
public class TypeRESTController {

    @Autowired
    TypeRepository typeRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Type getTypeById(@PathVariable("id") Long id) {
        return typeRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Type createType(@RequestBody Type type) {
        return typeRepository.save(type);
    }
}
