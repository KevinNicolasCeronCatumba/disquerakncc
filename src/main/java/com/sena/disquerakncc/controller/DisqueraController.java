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

import com.sena.disquerakncc.model.Disquera;
import com.sena.disquerakncc.service.DisqueraService;


@Controller
@RequestMapping("/disquera")
@SessionAttributes("disquera")
public class DisqueraController {
    @Autowired
    private DisqueraService disquerad;
    
    @GetMapping(path = {"/listdisquera","","/","listar"})
    public String listDisquera(Model m){
        m.addAttribute("disqueras",disquerad.findAll());
        return "/views/Disquera/listDisquera";
    }

    @GetMapping("/form")
    public String form(Model m){
        Disquera disquera=new Disquera();
        m.addAttribute("disquera", disquera);
        m.addAttribute("accion", "Agregar Disquera");
        System.out.println("agregar");
        return "/views/Disquera/addDisquera";
    }
    
    @PostMapping("/add")
        public String add(@Valid Disquera disquera,BindingResult res, Model m,SessionStatus status){
        if (res.hasErrors()) {
            return "/views/Disquera/addDisquera";
        }
        disquerad.save(disquera);
        status.setComplete();
        return "redirect:listdisquera";
    }

    @GetMapping("/delete/{IdDisquera}")
    public String delete(@PathVariable Integer IdDisquera) {
		
		if(IdDisquera > 0) {
			disquerad.delete(IdDisquera);
		}
		return "redirect:../listdisquera";
	}

    @GetMapping("/ver/{IdDisquera}")
    public String ver(@PathVariable Integer IdDisquera,Model m){
        Disquera disquera=null;
        if(IdDisquera>0){
            disquera=disquerad.findOne(IdDisquera);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("disquera",disquera);
        System.out.println(m);
        m.addAttribute("accion", "Actualizar Disquera");
        System.out.println("actualizacion");
        return "/views/Disquera/addDisquera";
    }

   

}
