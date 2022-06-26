package com.sena.disquerakncc.service;

import java.util.List;

import com.sena.disquerakncc.model.Disquera;

public interface DisqueraService {
    public List<Disquera> findAll();
    public void save(Disquera disquera);
    public Disquera findOne(Integer iddisquera);
    public void delete(Integer iddisquera);
}
