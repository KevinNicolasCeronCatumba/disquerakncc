package com.sena.disquerakncc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name="generos")

public class Genero {

    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdGenero;
    @NotEmpty
    @Column(name="NombreGenero", length=50, nullable=false)
    @NotEmpty
    private String NombreGenero;

    private Boolean EstadoGenero;

    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Album> albunes;

    //metodo constructor
    public Genero(){
        albunes=new ArrayList<Album>();
    }
    //metodo constructor
    public Genero(Integer idGenero, String NombreGenero, Boolean EstadoGenero){
        this.IdGenero=idGenero;
        this.NombreGenero=NombreGenero;
        this.EstadoGenero=EstadoGenero;
    }
    //metodos accesores -- get(envian variable de retorno) y set(valor de retorno es null) -- acceder a los atributos
    //idGenero
        public Integer getIdGenero() {
            return IdGenero;
        }    
        public void setIdGenero(Integer IdGenero) {
            this.IdGenero = IdGenero;
        }
    //nombreGenero
        public String getNombreGenero() {
            return NombreGenero;
        }
        public void setNombreGenero(String NombreGenero) {
            this.NombreGenero = NombreGenero;
        }
    //estadoGenero
        public Boolean getEstadoGenero() {
            return EstadoGenero;
        }
        public void setEstadoGenero(Boolean EstadoGenero) {
            this.EstadoGenero = EstadoGenero;
        }
    //-----
    //Albunes
        public List<Album> getAlbunes(){
            return albunes;
        }
        public void setAlbunes(List<Album> albunes){
            this.albunes = albunes;
        }
        public Genero orElse(Object object) {
            return null;
        }
}

