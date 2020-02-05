
package com.twitter.Twitter.repositorio;

import com.twitter.Twitter.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepositorio extends JpaRepository<Usuario,String>  {
    
}
