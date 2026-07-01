package br.com.cordialle.cordialle_art.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarrinhoController {

    // Substitui o @WebServlet e o doGet
    @GetMapping("/carrinho")
    public String abrirCarrinho() {

        // Retorna apenas o nome exato do arquivo JSP.
        // O Spring se encarrega de procurar em /WEB-INF/pages/Carrinho.jsp
        return "Carrinho";
    }
}