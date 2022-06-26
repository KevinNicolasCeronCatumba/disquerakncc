package com.sena.disquerakncc.service;

import java.util.List;

import com.sena.disquerakncc.model.Album;

public interface AlbumService {
    public List<Album> findAll();
    public void save (Album album);
    public Album findOne(Integer idalbum);
    public void delete(Integer idalbum);
}


