package br.com.cordialle.cordialle_art.controller;

import br.com.cordialle.cordialle_art.model.Usuario;
import br.com.cordialle.cordialle_art.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    // O Spring cria e injeta o seu LoginService automaticamente
    @Autowired
    private LoginService loginService;

    // Substitui o antigo doPost
    @PostMapping("/login")
    public String fazerLogin(
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            HttpSession sessao,
            Model model) {

        System.out.println("Tentativa de Login - Email: " + email);

        // Chama o seu serviço de autenticação
        Usuario usuarioAutenticado = loginService.autenticar(email, senha);

        if (usuarioAutenticado != null) {
            // Guarda o usuário na sessão (o "crachá")
            sessao.setAttribute("usuarioLogado", usuarioAutenticado);

            // Redireciona para a Rota 2 (Vitrine) igual você fazia com o sendRedirect
            return "redirect:/home";

        } else {
            // Se errar, envia a mensagem de erro para o JSP
            model.addAttribute("erro", "USUÁRIO OU SENHA INCORRETOS");

            // Retorna para a tela de login (index.jsp) sem mudar a URL
            return "index";
        }
    }
}