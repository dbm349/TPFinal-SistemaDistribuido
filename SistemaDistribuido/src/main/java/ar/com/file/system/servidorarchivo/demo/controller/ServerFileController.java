package ar.com.file.system.servidorarchivo.demo.controller;

import ar.com.file.system.servidorarchivo.demo.cruds.File;
import ar.com.file.system.servidorarchivo.demo.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ServerFileController {
    @Autowired
    private FileRepository fileRepository;
    private File file;

    @PostMapping("/ArchivoCreate")
    public File CreateFile (@RequestBody String nombreArchivo){
        var newFile = new File();
        newFile.setNombreArchivo(nombreArchivo);
        newFile.setNombreRutaDirectorio(" ");
        newFile.setTamaño("10kb");
        newFile.setFormato("txt");
        newFile.setTipo("1");
        newFile.setActivo(false);
        return fileRepository.save(newFile);
    }


    @PostMapping("/ArchivoDelete")
    public String DeleteFile (@RequestBody File archivo){
        archivo.setActivo(false);
        return "Archivo eliminado";
    }


    @GetMapping("/Archivos")
    public Iterable <File> listFiles (){
        return fileRepository.findAll();
    }
}
