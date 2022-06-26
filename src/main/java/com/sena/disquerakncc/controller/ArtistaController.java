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

import com.sena.disquerakncc.model.Artista;
import com.sena.disquerakncc.service.ArtistaService;
import com.sena.disquerakncc.service.DisqueraService;

@Controller
@SessionAttributes("artista")
@RequestMapping("/artista")

public class ArtistaController {
    @Autowired
    private ArtistaService  artistad;
    @Autowired
    private DisqueraService disquera;

    @GetMapping(path={"/listartista","","/","/listar"})
    public String listar(Model m){
        m.addAttribute("artistas", artistad.findAll());
        m.addAttribute("disqueras", disquera.findAll());
        return "/views/Artista/listArtista";
    }
    @GetMapping("/form")     
    public String form(Model m){
        Artista artista=new Artista();
        m.addAttribute("artista", artista);
        m.addAttribute("disqueras", disquera.findAll());
        m.addAttribute("accion", "Agregar Artista");
        return "/views/Artista/addArtista"; 
    }
    @PostMapping("/add")
    public String add(@Valid Artista artista,BindingResult res, Model m,SessionStatus status){
        if(res.hasErrors()){
            return "/views/Artista/addArtista";
        }
        artistad.save(artista);
        status.setComplete();
        return "redirect:listartista";
    }
    @GetMapping("/delete/{IdArtista}")
    public String delete(@PathVariable Integer IdArtista) {
		
		if(IdArtista > 0) {
			artistad.delete(IdArtista);
		}
		return "redirect:../listartista";
	}
    @GetMapping("/ver/{IdArtista}")
    public String ver(@PathVariable Integer IdArtista,Model m) {
        Artista artista=null;
        if(IdArtista>0){
            artista=artistad.findOne(IdArtista);
        }else{
            return"redirect:listar";
        }
        m.addAttribute("artista", artista);
        m.addAttribute("disqueras", disquera.findAll());
        m.addAttribute("accion", "Actualizar Artista");
        return"/views/Artista/addArtista";
    }
}
