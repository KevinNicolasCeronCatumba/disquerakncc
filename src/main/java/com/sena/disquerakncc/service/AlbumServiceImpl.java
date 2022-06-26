package com.sena.disquerakncc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disquerakncc.model.Album;
import com.sena.disquerakncc.model.IAlbum;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private IAlbum albumd;
    @Override
    public List<Album> findAll(){
        return(List<Album>) albumd.findAll();
    }
    @Override
    public void save(Album album){
        albumd.save(album);
    }
    @Override
    public Album findOne(Integer idalbum){
        return albumd.findById(idalbum).orElse(null);
    }
    @Override
    public void delete(Integer idalbum){
        albumd.deleteById(idalbum);
    }   
}
