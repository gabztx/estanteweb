package com.estanteweb.estanteweb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql, email);

        if (linhas.isEmpty()) {
            return null;
        }

        return Usuario.deMap(linhas.get(0));
    }
}