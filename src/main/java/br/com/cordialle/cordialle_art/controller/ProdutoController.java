package br.com.cordialle.cordialle_art.controller;

import br.com.cordialle.cordialle_art.model.Produto;
import br.com.cordialle.cordialle_art.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/produto") // Define que todas as rotas desta classe começam com /produto
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    // 1. ROTAS DE VISUALIZAÇÃO (O antigo doGet)
    // Substitui o case "listar"
    @GetMapping("/listar")
    public String listar(Model model) {

        System.out.println("Entrou no listar");

        var lista = produtoService.listarTodos();

        System.out.println("Quantidade de produtos: " + lista.size());

        model.addAttribute("produtos", lista);

        return "Listaprodutos";
    }

    // Substitui o case "cadastrar"
    @GetMapping("/cadastrar")
    public String abrirCadastro() {
        return "Cadastroproduto";
    }

    // Substitui o case "editar"
    @GetMapping("/editar")
    public String abrirEdicao(@RequestParam("id") int id, Model model) {
        Produto produtoEditar = null;

        for (Produto p : produtoService.listarTodos()) {
            if (p.getCodigo() == id) {
                produtoEditar = p;
                break;
            }
        }

        model.addAttribute("produto", produtoEditar);
        return "Editarproduto";
    }

    // Substitui o case "deletar" (Tela de confirmação)
    @GetMapping("/deletar")
    public String confirmarDelecao(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id == null) {
            return "redirect:/produto/listar";
        }

        Produto produtoDel = null;
        for (Produto p : produtoService.listarTodos()) {
            if (p.getCodigo() == id) {
                produtoDel = p;
                break;
            }
        }

        model.addAttribute("produto", produtoDel);
        return "Deletaproduto";
    }

    // Substitui o case "dashboard"
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Dashboard";
    }


    // 2. ROTAS DE AÇÃO (O antigo doPost)

    // Substitui o if ("inserir")
    @PostMapping("/inserir")
    public String inserir(Produto produto) {
        // O Spring lê os <input> do HTML e já entrega o objeto "Produto" montado
        // e com os tipos convertidos (Double, Int) não precisa mais de getParameter!
        produtoService.cadastrar(produto);
        return "redirect:/produto/listar";
    }

    // Substitui o if ("atualizar")
    @PostMapping("/atualizar")
    public String atualizar(Produto produto) {
        produtoService.atualizar(produto);
        return "redirect:/produto/listar";
    }

    // Substitui o if ("deletar") do Post
    @PostMapping("/confirmar-exclusao")
    public String deletar(Produto produto) {
        produtoService.excluir(produto);
        return "redirect:/produto/listar";
    }
}