package com.sena.disquerakncc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disquerakncc.model.Disquera;
import com.sena.disquerakncc.model.IDisquera;

@Service
public class DisqueraServiceImpl implements DisqueraService{
    @Autowired
    private IDisquera disquerad;

    @Override
    public List<Disquera> findAll() {
        return(List<Disquera>) disquerad.findAll();
    }
    @Override
    public void save(Disquera disquera) {
        disquerad.save(disquera);
        
    }

    @Override
    public Disquera findOne(Integer iddisquera) {
        return disquerad.findById(iddisquera).orElse(null);
    }

    @Override
    public void delete(Integer iddisquera) {
        disquerad.deleteById(iddisquera);
    }
}
