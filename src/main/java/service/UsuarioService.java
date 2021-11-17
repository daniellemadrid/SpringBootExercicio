package service;

import org.springframework.stereotype.Service;
import domain.TipoUsuario;
import domain.Usuario;

import java.util.ArrayList;
import java.util.List;

import static controller.UsuarioController.locatarioLogado;
import static controller.UsuarioController.locadorLogado;

@Service
public class UsuarioService {
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public void iniciar(){
        listaUsuarios.add(new Usuario("Manu", "1", TipoUsuario.LOCADOR));
        listaUsuarios.add(new Usuario("Maria", "2", TipoUsuario.LOCATARIO));
    }

    public Usuario cadastraUsuario(Usuario usuario){
        listaUsuarios.add(usuario);
        return usuario;
    }

    public List busca(){
        return listaUsuarios;
    }

    public Usuario buscaUm(String user){
        for(int i = 0; i < listaUsuarios.size(); i++){
            if (listaUsuarios.get(i).getUser().equals(user));
            return listaUsuarios.get(i);
        }
        return null;
    }

    public void delete(String user){
        for(int i = 0; i < listaUsuarios.size(); i++){
            if (listaUsuarios.get(i).getUser().equals(user));
            listaUsuarios.remove(i);
        }
        System.out.println("Removido com sucesso!");
    }

    public String valida(String user, String senha){
        Usuario usuario = listaUsuarios.stream().filter(s -> s.getUser().equals(user)).findFirst().get();
        if(usuario.getSenha().equals(senha) && usuario.getTipoUsuario().equals(TipoUsuario.LOCADOR)){
            locadorLogado = true;
            return "Logado!";
        }else if(usuario.getSenha().equals(senha) && usuario.getTipoUsuario().equals(TipoUsuario.LOCATARIO)){
            locatarioLogado = true;
            return "Logado!";
        }
        return "Não logado.";
    }
}