package br.com.cordialle.cordialle_art.service;

import br.com.cordialle.cordialle_art.dao.UsuarioDAO;
import br.com.cordialle.cordialle_art.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// 1. Avisa ao Spring que esta classe gerencia as regras de negócio dos usuários
@Service
public class UsuarioService {

    // 2. Injeção de Dependência: O Spring traz o DAO pronto para uso
    @Autowired
    private UsuarioDAO dao;

    public boolean cadastrar(Usuario u) {
        try {
            // A sua regra de validação continua intacta
            if (u.getNome() == null || u.getNome().trim().isEmpty() ||
                    u.getEmail() == null || u.getEmail().trim().isEmpty() ||
                    u.getSenha() == null || u.getSenha().trim().isEmpty()) {

                System.out.println("Erro: Dados obrigatórios do usuário faltando para cadastro.");
                return false;
            }

            // Chama diretamente o DAO injetado
            return dao.inserir(u);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean atualizar(Usuario u) {
        try {
            if (u.getCodigo() <= 0 ||
                    u.getNome() == null || u.getNome().trim().isEmpty() ||
                    u.getEmail() == null || u.getEmail().trim().isEmpty()) {

                System.out.println("Erro: Dados inválidos para atualização do usuário.");
                return false;
            }

            return dao.atualizar(u);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean excluir(Usuario u) {
        try {
            if (u.getCodigo() <= 0) {
                System.out.println("Erro: Código de usuário inválido para exclusão.");
                return false;
            }

            return dao.excluir(u);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Usuario> listarTodos() {
        try {
            return dao.getUsuarios();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public ArrayList<Usuario> buscarPorNome(String nome) {
        try {
            if (nome == null) {
                nome = "";
            }

            return dao.getUsuariosPorNome(nome);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}