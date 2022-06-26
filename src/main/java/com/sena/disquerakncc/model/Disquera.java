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
@Table(name="disqueras")

public class Disquera {
    //atributos   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdDisquera;
    @NotEmpty

    @Column(name="NitDisquera", length = 50, nullable = false)
    @NotEmpty
    private String NitDisquera;

    @Column(name="NombreDisquera", length = 100, nullable = false)
    @NotEmpty
    private String NombreDisquera;

    @Column(name="TelefonoDisquera", length = 50, nullable = false)
    @NotEmpty
    private String TelefonoDisquera;

    @Column(name="DireccionDisquera", length = 200, nullable = false)
    @NotEmpty
    private String DireccionDisquera;

    private Boolean EstadoDisquera;

    @OneToMany(mappedBy = "disquera", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Artista> artistas;
    

    //Metodo constructores
    public Disquera(){
        artistas = new ArrayList<Artista>();
    }
    //metodo constructor
    public Disquera(Integer IdDisquera, String NitDisquera, String NombreDisquera, String TelefonoDisquera, String DireccionDisquera, Boolean EstadoDisquera){
        this.IdDisquera=IdDisquera;
        this.NitDisquera=NitDisquera;
        this.NombreDisquera=NombreDisquera;
        this.TelefonoDisquera=TelefonoDisquera;
        this.DireccionDisquera=DireccionDisquera;
        this.EstadoDisquera=EstadoDisquera;
    }
    //metodos accesores get´rs and set´rs
    //IdDisquera
        public Integer getIdDisquera(){
            return IdDisquera;
        }
        public void setIdDisquera(Integer IdDisquera){
            this.IdDisquera=IdDisquera;
        }
    //NitDisquera
        public String getNitDisquera() {
            return NitDisquera;
        }
        public void setNitDisquera(String NitDisquera) {
            this.NitDisquera = NitDisquera;
        }
    //NombreDisquera
        public String getNombreDisquera() {
            return NombreDisquera;
        }
        public void setNombreDisquera(String NombreDisquera) {
            this.NombreDisquera = NombreDisquera;
        }
    //TelefonoDisquera
        public String getTelefonoDisquera() {
            return TelefonoDisquera;
        }
        public void setTelefonoDisquera(String TelefonoDisquera) {
            this.TelefonoDisquera = TelefonoDisquera;
        }
    //DireccionDisquera
        public String getDireccionDisquera() {
            return DireccionDisquera;
        }
        public void setDireccionDisquera(String DireccionDisquera) {
            this.DireccionDisquera = DireccionDisquera;
        }
    //EstadoDisquera
        public Boolean getEstadoDisquera() {
            return EstadoDisquera;
        }
        public void setEstadoDisquera(Boolean EstadoDisquera) {
            this.EstadoDisquera = EstadoDisquera;
        }
    //-----
    //Artistas
        public List<Artista> getArtistas(){
            return artistas;
        }
        public void setArtistas(List<Artista> artistas){
            this.artistas = artistas;
        }
        public Disquera orElse(Object object) {
            return null;
        }
}
 