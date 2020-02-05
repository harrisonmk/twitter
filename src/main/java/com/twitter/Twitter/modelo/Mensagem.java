
package com.twitter.Twitter.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mensagem implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer id;
    
    
     
    private LocalDateTime dataHora;
    
    
   
    private String texto;
     
     private int curtidas;
     
    
    @ManyToOne  //relacionamentos tem um | muitos textos possuem um usuario
    private Usuario usuario;

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCurtidas() {
        return curtidas;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public Long calcularTempoMinutos(){
        
        
       return ChronoUnit.MINUTES.between(dataHora, LocalDateTime.now());
        
    }
    
    public void curtir(){
        curtidas++;
    }
    
    
}
