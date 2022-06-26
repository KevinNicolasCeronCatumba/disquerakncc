package com.sena.disquerakncc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disquerakncc.model.Genero;
import com.sena.disquerakncc.model.IGenero;

@Service
public class GeneroServiceImpl implements GeneroService{
    @Autowired
    private IGenero generod;
    @Override
    public List<Genero> findAll() {
        return(List<Genero>) generod.findAll();
    }
    @Override
    public void save(Genero genero) {
        generod.save(genero);
    }
    @Override
    public Genero findOne(Integer idgenero) {
        return generod.findById(idgenero).orElse(null);
    }
    @Override
    public void delete(Integer idgenero) {
        generod.deleteById(idgenero);
        
    }
    
}
