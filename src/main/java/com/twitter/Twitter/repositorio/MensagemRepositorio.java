
package com.twitter.Twitter.repositorio;

import com.twitter.Twitter.modelo.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MensagemRepositorio extends JpaRepository<Mensagem,Integer> {
    
}
