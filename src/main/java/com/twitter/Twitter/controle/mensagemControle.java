package com.twitter.Twitter.controle;

import com.twitter.Twitter.modelo.Mensagem;
import com.twitter.Twitter.modelo.Usuario;
import com.twitter.Twitter.repositorio.MensagemRepositorio;
import com.twitter.Twitter.repositorio.UsuarioRepositorio;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mensagem")
public class mensagemControle {
    
    //atributo do tipo mensagemRepositorio
    @Autowired
    private MensagemRepositorio mensagemRepositorio;
    
    //atributo do tipo UsuarioRepositorio
    @Autowired
    private UsuarioRepositorio usuarioRepositorio; 

    //retorna para a pagina mensagem-criar
    @GetMapping(path = "/nova")
    public String nova(Model model) {
        Mensagem mensagem = new Mensagem();
        model.addAttribute("mensagem", mensagem);
        
        //busca e mostra por ordem decrescente
        List <Usuario> usuarios = usuarioRepositorio.findAll(new Sort(Direction.ASC,"nome"));
        
        //torna o atributo visivel para a view
        model.addAttribute("usuarios", usuarios);

        return "mensagem-criar";

    }
    
    
    

    //metodo para criar uma mensagem e adicionar no banco de dados
    @PostMapping(path = "/criar")
    public String criar(Mensagem mensagem) {
        
        if(!mensagem.getTexto().isEmpty()){
        mensagem.setDataHora(LocalDateTime.now());
        mensagemRepositorio.save(mensagem);
            
        }
        
        return "redirect:/mensagem/listar";

    }
    
    //metodo para listar os twttes
    @GetMapping(path= "/listar")
    public String listar(Model model){
        
     List<Mensagem> mensagens = mensagemRepositorio.findAll(new Sort(Direction.DESC,"dataHora"));
     model.addAttribute("mensagens",mensagens);
     
     
        return "mensagem-listar";
        
        
    }
    
    //metodo para curtir
    @GetMapping(path= "/curtir")
    public String curtir(@RequestParam("msgId") Integer msgId){
        
        
    Mensagem mensagem = mensagemRepositorio.findById(msgId).orElseThrow();
    mensagem.curtir();
    mensagemRepositorio.save(mensagem);
       
       return "redirect:/mensagem/listar";
       
       
       
    }
    

}
