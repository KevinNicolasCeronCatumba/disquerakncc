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
@Table(name="artistas")
public class Artista {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdArtista;
    @NotEmpty
    @Column(length = 20,nullable = false)
    private String NoDocumento;
    @NotEmpty
    @Column(length = 20,nullable = false)
    private String TipoDocumento;
    @NotEmpty
    @Size(min = 2,max = 50)
    @Column(length = 50,nullable = false)
    private String NombreArtista;
    @NotEmpty
    @Size(min = 2,max = 50)
    @Column(length = 50,nullable = false)
    private String ApellidoArtista;
    @NotEmpty
    @Size(min = 2,max = 50)
    @Column(length = 50,nullable = false)
    private String NombreArtistico;
    @Column(nullable = false)
    private Date FNaciArtista;
    @NotEmpty
    @Size(min = 2,max = 50)
    @Column(length = 50,nullable = false)
    private String EmailArtista;
    private Boolean EstadoArtista;


    @ManyToOne(fetch = FetchType.LAZY)
    private Disquera disquera;

    @OneToMany(mappedBy = "artista", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Album> albunes;

    //contructores
    public Artista() {
        albunes = new ArrayList<Album>();
    }
    //Constructor
    public Artista(Integer IdArtista, String NoDocumento, String TipoDocumento,String NombreArtista, String ApellidoArtista, String NombreArtistico, Date FNaciArtista, String EmailArtista,Boolean EstadoArtista, Disquera disquera){
        this.IdArtista = IdArtista;
        this.NoDocumento = NoDocumento;
        this.TipoDocumento = TipoDocumento;
        this.NombreArtista = NombreArtista;
        this.ApellidoArtista = ApellidoArtista;
        this.NombreArtistico = NombreArtistico;
        this.FNaciArtista = FNaciArtista;
        this.EmailArtista = EmailArtista;
        this.EstadoArtista = EstadoArtista;
        this.disquera = disquera;
    }
    //get´rs and set´rs
    //IdArtista
        public Integer getIdArtista() {
            return IdArtista;
        }
        public void setIdArtista(Integer IdArtista){
            this.IdArtista = IdArtista;
        }
    //NoDocumento
        public String getNoDocumento() {
            return NoDocumento;
        }
        public void setNoDocumento(String NoDocumento) {
            this.NoDocumento = NoDocumento;
        }
    //TipoDocumento
        public String getTipoDocumento() {
            return TipoDocumento;
        }
        public void setTipoDocumento(String TipoDocumento) {
            this.TipoDocumento = TipoDocumento;
        }
    //NombreArtista
        public String getNombreArtista(){
            return NombreArtista;
        }
        public void setNombreArtista(String NombreArtista) {
            this.NombreArtista = NombreArtista;
        }
    //ApellidoArtista
        public String getApellidoArtista(){
            return ApellidoArtista;
        }
        public void setApellidoArtista(String ApellidoArtista) {
            this.ApellidoArtista = ApellidoArtista;
        }
    //NombreArtistico
        public String getNombreArtistico(){
            return NombreArtistico;
        }
        public void setNombreArtistico(String NombreArtistico) {
            this.NombreArtistico = NombreArtistico;
        }
    //FNaciArtista
        public Date getFNaciArtista(){
            return FNaciArtista;
        }
        public void setFNaciArtista(Date FNaciArtista) {
            this.FNaciArtista = FNaciArtista;
        }
    //EmailArtista
        public String getEmailArtista(){
            return EmailArtista;
        }
        public void setEmailArtista(String EmailArtista){
            this.EmailArtista = EmailArtista;
        }
    //EstadoArtista
        public Boolean getEstadoArtista(){
            return EstadoArtista;
        }
        public void setEstadoArtista(Boolean EstadoArtista) {
            this.EstadoArtista = EstadoArtista;
        }


    //Disquera
        public Disquera getDisquera(){
            return disquera;
        }
        public void setDisquera(Disquera disquera) {
            this.disquera = disquera;
        }
    //-----
    //Albunes
        public List<Album> getAlbunes(){
            return albunes;
        }
        public void setAlbunes(List<Album> albunes){
            this.albunes = albunes;
        }
        public Artista orElse(Object object) {
            return null;
        }

}
