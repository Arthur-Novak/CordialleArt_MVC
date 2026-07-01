package br.com.cordialle.cordialle_art.controller;

import br.com.cordialle.cordialle_art.model.Produto;
import br.com.cordialle.cordialle_art.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class RelatorioController {

    // O Spring injeta o seu Service automaticamente
    @Autowired
    private ProdutoService produtoService;

    // Substitui o @WebServlet e o doGet
    @GetMapping("/relatorio")
    public String gerarRelatorio(Model model) {

        // 1. Busca os dados usando o seu Service (sem precisar de try/catch aqui, o Service já trata)
        ArrayList<Produto> produtos = produtoService.listarTodos();

        // 2. Variáveis para armazenar o processamento
        int totalProdutos = 0;
        double valorTotalCatalogo = 0.0;
        double mediaPreco = 0.0;
        Produto maisCaro = null;
        Produto maisBarato = null;

        if (produtos != null && !produtos.isEmpty()) {
            totalProdutos = produtos.size();
            maisCaro = produtos.get(0);
            maisBarato = produtos.get(0);

            for (Produto p : produtos) {
                valorTotalCatalogo += p.getPreco();

                // Descobre o produto mais caro
                if (p.getPreco() > maisCaro.getPreco()) {
                    maisCaro = p;
                }
                // Descobre o produto mais barato
                if (p.getPreco() < maisBarato.getPreco()) {
                    maisBarato = p;
                }
            }

            // Calcula o ticket médio do catálogo
            mediaPreco = valorTotalCatalogo / totalProdutos;
        }

        // 4. O "Model" substitui o request.setAttribute()
        model.addAttribute("totalProdutos", totalProdutos);
        model.addAttribute("valorTotalCatalogo", valorTotalCatalogo);
        model.addAttribute("mediaPreco", mediaPreco);
        model.addAttribute("maisCaro", maisCaro);
        model.addAttribute("maisBarato", maisBarato);

        // 5. Substitui o RequestDispatcher. O Spring acha o Relatorio.jsp automaticamente.
        return "Relatorio";
    }
}