package com.sena.disquerakncc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disquerakncc.model.Artista;
import com.sena.disquerakncc.model.IArtista;

@Service
public class ArtistaServiceImpl implements ArtistaService{
    @Autowired
    private IArtista artistad;
    @Override
    public List<Artista> findAll(){
        return(List<Artista>) artistad.findAll();
    }
    @Override
    public void save(Artista artista){
        artistad.save(artista);
    }
    
    @Override
    public void delete(Integer idartista){
        artistad.deleteById(idartista);
    }
    @Override
    public Artista findOne(Integer idartista) {
        return artistad.findById(idartista).orElse(null);
    }
}
