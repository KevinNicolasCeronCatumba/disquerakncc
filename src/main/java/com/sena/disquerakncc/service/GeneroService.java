package com.sena.disquerakncc.service;

import java.util.List;

import com.sena.disquerakncc.model.Genero;

public interface GeneroService {
    public List<Genero> findAll();
    public void save(Genero genero);
    public Genero findOne(Integer idgenero);
    public void delete(Integer idgenero);
}
