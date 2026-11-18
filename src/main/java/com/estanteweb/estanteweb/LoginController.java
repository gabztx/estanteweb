package com.estanteweb.estanteweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String formulario() {
        return "login";
    }

    @PostMapping("/login")
    public String entrar(@RequestParam String email,
            @RequestParam String senha,
            Model model) {

        Usuario usuario = usuarioRepository.buscarPorEmail(email);

        if (usuario == null || !usuario.getSenha().equals(senha)) {
            model.addAttribute("erro", "E-mail ou senha inválidos.");
            model.addAttribute("email", email);
            return "login";
        }

        return "redirect:/livros/html";
    }
}