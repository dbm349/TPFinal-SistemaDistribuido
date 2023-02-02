package ar.com.file.system.servidorarchivo.demo.controller;

import ar.com.file.system.servidorarchivo.demo.cruds.Directory;
import ar.com.file.system.servidorarchivo.demo.repositories.DirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ServerDirectoryController {

    @Autowired
    private DirectoryRepository directoryRepository;
    private Directory directory;

    @PostMapping("/RutaCreate")
    public Directory CreateDirectory (@RequestBody String nombreRuta){
        var newDirectorio = new Directory();
        newDirectorio.setNombreRuta(nombreRuta);
        newDirectorio.setActivo(false);
        return directoryRepository.save(newDirectorio);
    }


    @PostMapping("/RutaDelete")
    public String DeleteFile (@RequestBody Directory archivo){
        archivo.setActivo(false);
        return "Archivo eliminado";
    }


    @GetMapping("/Rutas")
    public Iterable <Directory> listFiles (){
        return directoryRepository.findAll();
    }

}
