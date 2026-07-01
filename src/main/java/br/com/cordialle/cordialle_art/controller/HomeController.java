package br.com.cordialle.cordialle_art.controller;

import br.com.cordialle.cordialle_art.dao.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.sql.SQLException;

@Controller
public class HomeController {

    @Autowired
    private ProdutoDAO produtoDAO;

    // Rota 1: Tela inicial de Login (index.jsp)
    @GetMapping("/")
    public String abrirIndex() {
        return "index";
    }

    // Rota 2: Vitrine de Produtos (Home.jsp)
    @GetMapping("/home")
    public String exibirVitrine(Model model) {
        try {
            var lista = produtoDAO.getProdutos();
            model.addAttribute("produtos", lista);
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produtos: " + e.getMessage());
        }
        return "Home";
    }

    @GetMapping("/quem-somos")
    public String quemSomos() {
        return "QuemSomos"; // Abre o ficheiro /WEB-INF/pages/QuemSomos.jsp
    }

    // E a Galeria também:
    @GetMapping("/galeria")
    public String abrirGaleria() {
        return "Galeria";
    }
}