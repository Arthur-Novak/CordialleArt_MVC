package br.com.cordialle.cordialle_art.controller;

import br.com.cordialle.cordialle_art.model.Usuario;
import br.com.cordialle.cordialle_art.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // ==========================================
    // 1. ROTAS DE VISUALIZAÇÃO (O antigo doGet)
    // ==========================================

    @GetMapping("/cadastrar")
    public String abrirCadastro() {
        return "Cadastrousuario";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "Listausuarios";
    }

    @GetMapping("/editar")
    public String abrirEdicao(@RequestParam("id") int id, Model model) {
        Usuario usuarioEditar = null;

        for (Usuario u : usuarioService.listarTodos()) {
            if (u.getCodigo() == id) {
                usuarioEditar = u;
                break;
            }
        }

        model.addAttribute("usuario", usuarioEditar);
        return "Editarusuario";
    }

    @GetMapping("/deletar")
    public String confirmarDelecao(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id == null) {
            return "redirect:/usuario/listar";
        }

        Usuario usuarioDel = null;
        for (Usuario u : usuarioService.listarTodos()) {
            if (u.getCodigo() == id) {
                usuarioDel = u;
                break;
            }
        }

        model.addAttribute("usuario", usuarioDel);
        return "Deletausuario";
    }

    // ==========================================
    // 2. ROTAS DE AÇÃO (O antigo doPost)
    // ==========================================

    @PostMapping("/inserir")
    public String inserir(Usuario usuario) {
        // O Spring lê o HTML e já cria o objeto com nome, email, senha, booleanos, tudo pronto!
        usuarioService.cadastrar(usuario);

        // Ajuste para onde você quer redirecionar após cadastrar (ex: dashboard ou login)
        return "redirect:/dashboard";
    }

    @PostMapping("/atualizar")
    public String atualizar(Usuario usuario, Model model) {
        usuarioService.atualizar(usuario);

        model.addAttribute("mensagem", "Dados atualizados com sucesso. Faça login novamente!");

        // Retorna para a tela inicial (index.jsp) sem redirecionamento para não perder a mensagem
        return "index";
    }

    @PostMapping("/confirmar-exclusao")
    public String deletar(Usuario usuario, HttpSession sessao) {

        // 1. Exclui o usuário no banco
        usuarioService.excluir(usuario);

        // 2. A sua lógica excelente de verificar a sessão
        if (sessao != null) {
            Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado");

            // Verifica se quem está logado é a mesma pessoa que acabou de ser excluída
            if (usuarioLogado != null && usuarioLogado.getCodigo() == usuario.getCodigo()) {
                // Invalida a sessão, forçando o logout
                sessao.invalidate();

                // Redireciona para o index passando a mensagem pela URL
                return "redirect:/?msg=Sua conta foi excluida.";
            }
        }

        // Se excluiu outro usuário (modo admin, por exemplo), continua na lista
        return "redirect:/usuario/listar";
    }
}