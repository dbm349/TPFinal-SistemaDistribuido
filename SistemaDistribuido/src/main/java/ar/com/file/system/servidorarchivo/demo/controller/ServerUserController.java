package ar.com.file.system.servidorarchivo.demo.controller;

import ar.com.file.system.servidorarchivo.demo.cruds.User;
import ar.com.file.system.servidorarchivo.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ServerUserController {

    @Autowired
    private UserRepository userRepository;
    private User user;

    @PostMapping ("/UserCreate")

    public User registerUser (@RequestBody String nombre){
        var newUser = new User();
        newUser.setNombre(nombre);
        newUser.setApellido("Morello");
        newUser.setEmail("delfi@hotmail.com");
        newUser.setDireccion("134");
        newUser.setActivo(false);
        return userRepository.save(newUser);
    }


    @PostMapping("/UserDelete")
    public String DeleteFile (@RequestBody User usuario){
        usuario.setActivo(false);
        return "Usuario eliminado";
    }

    @GetMapping ("/User")

    public Iterable <User> listUser (){
        return userRepository.findAll();
    }
}
