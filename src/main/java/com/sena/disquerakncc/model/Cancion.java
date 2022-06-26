package com.sena.disquerakncc.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="canciones")
public class Cancion {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Integer IdCancion;

    @NotEmpty
    @Size(min = 2,max = 50)
    @Column(length = 50,nullable = false)
    private String NombreCancion;

    @Column(nullable = false)
    private Date FechaGrabacion;

    @NotEmpty
    @Size(min = 2,max = 5)
    @Column(length = 5,nullable = false)
    private String DuracionCancion;
    private Boolean EstadoAlbum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    //constructor vacio
    public Cancion() {
        
    }
    //contructor
    public Cancion(Integer IdCancion,String NombreCancion,Date FechaGrabacion,String DuracionCancion,Boolean EstadoAlbum) {
        this.IdCancion=IdCancion;
        this.NombreCancion=NombreCancion;
        this.FechaGrabacion=FechaGrabacion;
        this.DuracionCancion=DuracionCancion;
        this.EstadoAlbum=EstadoAlbum;
    }
    //get´rs and set´rs
    //IdCancion
        public Integer getIdCancion() {
            return IdCancion;
        }
        public void setIdCancion(Integer IdCancion) {
            this.IdCancion = IdCancion;
        }
    //NombreCancion
        public String getNombreCancion(){
            return NombreCancion;
        }
        public void setNombreCancion(String NombreCancion){
            this.NombreCancion=NombreCancion;
        }
    //FechaGrabacion
        public Date getFechaGrabacion(){
            return FechaGrabacion;
        }
        public void setFechaGrabacion(Date FechaGrabacion) {
            this.FechaGrabacion=FechaGrabacion;
        }
    //DuracionCancion
        public String getDuracionCancion(){
            return DuracionCancion;
        }
        public void setDuracionCancion(String DuracionCancion) {
            this.DuracionCancion=DuracionCancion;
        }
    //EstadoAlbum
        public Boolean getEstadoAlbum(){
            return EstadoAlbum;
        }
        public void setEstadoAlbum(Boolean EstadoAlbum) {
            this.EstadoAlbum=EstadoAlbum;
        }
}
