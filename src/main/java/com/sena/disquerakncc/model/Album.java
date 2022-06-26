package com.sena.disquerakncc.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="albunes")
public class Album {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Integer IdAlbum;
    @NotEmpty
    @Size(min = 2,max = 100)
    @Column(length = 100,nullable = false)
    private String NombreAlbum;
    @Column(nullable = false)
    private Date AnPuAlbum;
    private Boolean EstadoAlbum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genero genero;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cancion> canciones;

    //Constructor
    public Album() {
        canciones=new ArrayList<Cancion>();
    }
    //Constructor
    public Album(Integer IdAlbum, String NombreAlbum, Date AnPuAlbum,
            Boolean EstadoAlbum,Genero genero,Artista artista) {
        this.IdAlbum = IdAlbum;
        this.NombreAlbum = NombreAlbum;
        this.AnPuAlbum = AnPuAlbum;
        this.EstadoAlbum = EstadoAlbum;
        this.artista = artista;
        this.genero = genero;
    }
    //get´rs and set´rs
    //IdAlbum
        public Integer getIdAlbum() {
            return IdAlbum;
        }
        public void setIdAlbum(Integer IdAlbum) {
            this.IdAlbum = IdAlbum;
        }
    //NombreAlbum
        public String getNombreAlbum() {
            return NombreAlbum;
        }
        public void setNombreAlbum(String NombreAlbum) {
            this.NombreAlbum = NombreAlbum;
        }
    //AnPuAlbum
        public Date getAnPuAlbum() {
            return AnPuAlbum;
        }
        public void setAnPuAlbum(Date AnPuAlbum) {
            this.AnPuAlbum = AnPuAlbum;
        }
    //EstadoAlbum
        public Boolean getEstadoAlbum() {
            return EstadoAlbum;
        }
        public void setEstadoAlbum(Boolean EstadoAlbum) {
            this.EstadoAlbum = EstadoAlbum;
        } 
    //Genero
    public Genero getGenero(){
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    //Artista
    public Artista getArtista(){
        return artista;
    }
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
