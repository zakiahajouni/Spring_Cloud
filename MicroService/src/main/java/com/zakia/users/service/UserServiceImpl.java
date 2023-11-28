package com.zakia.users.service;
import com.zakia.users.entities.Role;
import com.zakia.users.entities.User;
import com.zakia.users.repos.RoleRepository;
import com.zakia.users.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Transactional
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRep;
    @Autowired
    RoleRepository roleRep;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public User saveUser(User user) {
        Random rand = new Random();
        String code = String.format("%04d", rand.nextInt(10000));



        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(user.getEmail());
        msg.setSubject("your code of the authentication is :");
        String activationURL = "http://localhost:8081/users/activateUser/" + user.getUsername() + "/" + code;

        msg.setText(     "Dear " + user.getUsername() + "," +
                "\n\n" +
                "Welcome to our world of motors . To activate your account, please click on the following link: " +
                "\n\n" + activationURL +
                "\n\n");
        //msg.setText(code);
        mailSender.send(msg);
        List<Role> listOfrole=new ArrayList<>();
        listOfrole.add(roleRep.findRoleById(2L));
        user.setRoles(listOfrole);

        user.setEmail(user.getEmail());
        user.setCode(code);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);
    }
    @Override
    public User addRoleToUser(long id, Role r) {
        User usr = userRep.findUserById(id);

        List<Role> roles = usr.getRoles();
        roles.add(r);

        usr.setRoles(roles);

        return userRep.save(usr);
    }


    @Override
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
    public Role addRole(Role role) {
        return roleRep.save(role);
    }
    @Override
    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }


    @Override
    public User findUserById(Long id) {
        return userRep.findById(id).get();
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRep.findAll();
    }
    @Override
    public Role findRoleById(Long id) {
        return roleRep.findRoleById(id);
    }

    @Override
    public void deleteUser(long id) {
        userRep.deleteByUserId(id);
    }
    @Override
    public User removeRoleFromUser(long id,Role r)
    {
        User user=userRep.findUserById(id);
        List<Role> listOfrole=user.getRoles();

        listOfrole.remove(r);
        userRep.save(user);
        return user;




    }

    @Override
    public String activateUser(String username , String code)
    {
        User user=userRep.findByUsername(username);
        if(user!=null)
        {
            if(user.getEnabled()==null || user.getEnabled()==false)
            {
                if(user.getCode().equals(code)==true)
                {
                    user.setEnabled(true);
                    userRep.save(user);
                    return ("User Activated successfully , Please return to login page ");


                }
                else
                {
                    System.out.println(user.getCode());
                    return ("Something went wrong ");
                }
            }
            else
            {
                return ("Something went wrong ");
            }
        }
        else
        {
            return ("Something went wrong ");
        }
    }


}
