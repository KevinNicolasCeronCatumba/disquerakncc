package com.sena.disquerakncc.service;

import java.util.List;

import com.sena.disquerakncc.model.Artista;

public interface ArtistaService {
    public List<Artista> findAll();
    public void save(Artista artista);
    public Artista findOne(Integer idartista);
    public void delete(Integer idartista);
}
