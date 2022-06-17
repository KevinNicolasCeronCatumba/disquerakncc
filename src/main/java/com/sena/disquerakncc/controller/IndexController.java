package com.sena.disquerakncc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(path = {"/index","","/","/home"})//GENER LA URL Y CARGA EL INDEX
    public ModelAndView index(ModelAndView mv){
        mv.addObject("msn","ESTE MENSAJE VIENE DEL CONTROLADOR");
        mv.setViewName("index");
        return mv;
    }
}

