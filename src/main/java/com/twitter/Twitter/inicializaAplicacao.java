package com.twitter.Twitter;

import com.twitter.Twitter.modelo.Mensagem;
import com.twitter.Twitter.modelo.Usuario;
import com.twitter.Twitter.repositorio.MensagemRepositorio;
import com.twitter.Twitter.repositorio.UsuarioRepositorio;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class inicializaAplicacao {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private MensagemRepositorio mensagemRepositorio;

//metodo que vai ser chamado quando a aplicacao for inicializada
//já vai ser setados usuarios para ele    
    @EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Usuario u1 = new Usuario();
		u1.setId("harrisonmitche1");
		u1.setNome("Harrison");
		usuarioRepositorio.save(u1);
		
		Usuario u2 = new Usuario();
		u2.setId("naruto");
		u2.setNome("Naruto");
		usuarioRepositorio.save(u2);
		
		Mensagem m1_u1 = new Mensagem();
		m1_u1.setDataHora(LocalDateTime.now().minusMinutes(45));
		m1_u1.setTexto("O Java ainda tem vida longa, apesar de alguns dizerem que nao...");
		m1_u1.setUsuario(u1);
		mensagemRepositorio.save(m1_u1);
		
		Mensagem m2_u1 = new Mensagem();
		m2_u1.setDataHora(LocalDateTime.now().minusMinutes(42));
		m2_u1.setTexto("FATO: No mercado de trabalho o que mais tem e vaga pra trabalhar com JAVA!");
		m2_u1.setUsuario(u1);
		mensagemRepositorio.save(m2_u1);
		
		Mensagem m1_u2 = new Mensagem();
		m1_u2.setDataHora(LocalDateTime.now().minusMinutes(27));
		m1_u2.setTexto("ser hokage eh o meu sonho");
		m1_u2.setUsuario(u2);
		mensagemRepositorio.save(m1_u2);
		
		Mensagem m2_u2 = new Mensagem();
		m2_u2.setDataHora(LocalDateTime.now().minusMinutes(22));
		m2_u2.setTexto("Rasengan!");
		m2_u2.setUsuario(u2);
		mensagemRepositorio.save(m2_u2);
		
		Mensagem m3_u1 = new Mensagem();
		m3_u1.setDataHora(LocalDateTime.now().minusMinutes(20));
		m3_u1.setTexto("Python eh linguagem de preguicoso");
		m3_u1.setUsuario(u1);
		mensagemRepositorio.save(m3_u1);
	}

}
