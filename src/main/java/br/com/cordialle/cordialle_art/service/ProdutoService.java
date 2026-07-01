package br.com.cordialle.cordialle_art.service;

import br.com.cordialle.cordialle_art.dao.ProdutoDAO;
import br.com.cordialle.cordialle_art.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// 1. O "crachá" que avisa o Spring que esta classe processa regras de negócio
@Service
public class ProdutoService {

    // 2. O Spring injeta o DAO aqui uma única vez para a classe toda usar
    @Autowired
    private ProdutoDAO dao;

    public boolean cadastrar(Produto p) {
        try {
            // A sua regra de negócio perfeita continua intacta
            if (p.getNome() == null || p.getNome().trim().isEmpty() || p.getPreco() < 0) {
                System.out.println("Erro: Produto inválido para cadastro.");
                return false;
            }

            // Usamos o DAO injetado diretamente!
            return dao.inserir(p);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean atualizar(Produto p) {
        try {
            if (p.getCodigo() <= 0 || p.getNome() == null || p.getNome().trim().isEmpty() || p.getPreco() < 0) {
                System.out.println("Erro: Dados inválidos para atualização.");
                return false;
            }

            return dao.atualizar(p);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean excluir(Produto p) {
        try {
            if (p.getCodigo() <= 0) {
                System.out.println("Erro: Código de produto inválido para exclusão.");
                return false;
            }

            return dao.excluir(p);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Produto> listarTodos() {
        try {
            return dao.getProdutos();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public ArrayList<Produto> buscarPorNome(String nome) {
        try {
            if (nome == null) {
                nome = "";
            }

            return dao.getProdutosPorNome(nome);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}