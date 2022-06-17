package com.sena.disquerakncc.model;

import java.util.List;

public interface IGenero {
    public List<Genero> findAll();
    public void save (Genero genero);
    public Genero findOne(Integer idgenero);
    public void delete(Integer idgenero);
}
