package com.sena.disquerakncc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sena.disquerakncc.model.Album;
import com.sena.disquerakncc.service.AlbumService;
import com.sena.disquerakncc.service.ArtistaService;
import com.sena.disquerakncc.service.GeneroService;

@Controller
@SessionAttributes("album")
@RequestMapping("/album")

public class AlbumController {
    @Autowired
    private AlbumService  albumd;
    @Autowired 
    private ArtistaService artista;
    @Autowired
    private GeneroService genero;
    
    @GetMapping(path={"/listalbum","","/","listar"})
    public String listar(Model m){
        m.addAttribute("albunes", albumd.findAll());
        m.addAttribute("artistas", artista.findAll());
        m.addAttribute("generos", genero.findAll());
        return "/views/Album/listAlbum";    
    }
    @GetMapping("/form")     
    public String form(Model m){
        Album album=new Album();
        m.addAttribute("album", album);
        m.addAttribute("artistas", artista.findAll());
        m.addAttribute("generos", genero.findAll());
        m.addAttribute("accion", "Agregar Album");
        return "/views/Album/addAlbum"; 
    }
    @PostMapping("/add")
    public String add(@Valid Album album,BindingResult res, Model m,SessionStatus status){
        if(res.hasErrors()){
            return "/views/Album/addAlbum";
        }
        albumd.save(album);
        status.setComplete();
        return "redirect:listalbum";
    }
    @GetMapping("/delete/{IdAlbum}")
    public String delete(@PathVariable Integer IdAlbum) {
		
		if(IdAlbum > 0) {
			albumd.delete(IdAlbum);
		}
		return "redirect:../listalbum";
	}
    @GetMapping("/ver/{IdAlbum}")
    public String ver(@PathVariable Integer IdAlbum,Model m){
        Album album=null;
        if(IdAlbum>0){
            album=albumd.findOne(IdAlbum);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("album",album);
        m.addAttribute("artistas", artista.findAll());
        m.addAttribute("generos", genero.findAll());
        m.addAttribute("accion", "Actualizar Album");
        return "/views/Album/addAlbum";
    }
}
