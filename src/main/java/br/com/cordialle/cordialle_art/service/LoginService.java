package br.com.cordialle.cordialle_art.service;

import br.com.cordialle.cordialle_art.dao.UsuarioDAO;
import br.com.cordialle.cordialle_art.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 1. Avisamos ao Spring que esta classe contém regras de negócio
@Service
public class LoginService {

    // 2. Pedimos ao Spring para trazer o DAO pronto (Injeção de Dependência)
    @Autowired
    private UsuarioDAO dao;

    public Usuario autenticar(String email, String senha) {
        try {
            // 3. Usamos o DAO diretamente, sem precisar escrever "new UsuarioDAO()"
            Usuario u = dao.autenticar(email, senha);
            return u;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}