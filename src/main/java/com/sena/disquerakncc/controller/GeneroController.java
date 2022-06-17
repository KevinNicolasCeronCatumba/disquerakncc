package com.sena.disquerakncc.controller;

import javax.validation.Valid;

import com.sena.disquerakncc.model.Genero;
import com.sena.disquerakncc.model.IGenero;

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

@RequestMapping("/genero")
@Controller
@SessionAttributes("cliente")
public class GeneroController {
    @Autowired
    private IGenero generod;

    @GetMapping(path = {"/listgenero","","/"})
    public String listGenero(Model m){
        m.addAttribute("generos",generod.findAll());
        return "/views/Genero/listGenero";
    }
    @GetMapping("/ver")
    public String verc(Model m){
        Genero gen=new Genero();
        gen.setIdGenero(1);
        gen.setNombreGenero("KEVIN NICOLAS");
        gen.setEstadoGenero(false); 
        m.addAttribute("genero", gen);
        return "/views/Genero/ver";
    }
    @GetMapping("/form")
    public String form(Model m){
        Genero genero=new Genero();
        m.addAttribute("genero", genero);
        m.addAttribute("accion","Agregar Genero");
        return "/views/Genero/addGenero";
    }
    
    @PostMapping("/add")
        public String add(@Valid Genero genero,BindingResult res, Model m,SessionStatus status){
        if (res.hasErrors()) {
            return "/views/Genero/addGenero";
        }
        generod.save(genero);
        status.setComplete();
        /*m.addAttribute("genero", genero);*/
        return "redirect:listgenero";
    }
    @GetMapping("/delete/{IdGenero}")
    public String delete(@PathVariable Integer IdGenero) {
		
		if(IdGenero > 0) {
			generod.delete(IdGenero);
		}
		return "redirect:../listgenero";
	}

    @GetMapping("/ver/{IdGenero}")
    public String ver(@PathVariable Integer IdGenero,Model m){
        Genero genero=null;
        if(IdGenero>0){
            genero=generod.findOne(IdGenero);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("genero",genero);
        m.addAttribute("accion", "Actualizar Genero");
        return "/views/Genero/addGenero";
    }
       
}
