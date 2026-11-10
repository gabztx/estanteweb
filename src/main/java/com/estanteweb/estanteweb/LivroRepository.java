package com.estanteweb.estanteweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository 
public class LivroRepository {
    
    @Autowired 
    private JdbcTemplate jdbcTemplate;

    public List<Livro> listarTodos() {
        String sql = "SELECT * FROM livro";
        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql);
        List<Livro> livros = new ArrayList<>();

        for (Map<String, Object> linha : linhas) {
            livros.add(Livro.deMap(linha));
        }

        return livros;
    }

    public String contarLivros() {
        return jdbcTemplate.queryForObject("select count(*) from livro", String.class);
    }

    public List<Livro> listarAtePreco(double precoMaximo) {
        String sql = "SELECT * FROM livro WHERE preco <= ?";
        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql, precoMaximo);
        List<Livro> livros = new ArrayList<>();

        for (Map<String, Object> linha : linhas) {
            livros.add(Livro.deMap(linha));
        }

        return livros;
    }

    public Livro buscarPorId(Long id) {
        String sql = "SELECT * FROM livro WHERE id = ?";
        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql, id);

        if (linhas.isEmpty()) {
            return null;
        }

        return Livro.deMap(linhas.get(0));
    }

    public List<Livro> listarOrdenadoPor(String coluna) {
        String sql = "SELECT * FROM livro";

        if (coluna.equals("titulo") || coluna.equals("autor")
                || coluna.equals("ano") || coluna.equals("preco")) {
            sql = sql + " ORDER BY " + coluna;
        }

        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql);
        List<Livro> livros = new ArrayList<>();

        for (Map<String, Object> linha : linhas) {
            livros.add(Livro.deMap(linha));
        }

        return livros;
    }

    public List<Livro> listarDoMesmoAutor(String autor, Long idAtual) {
        String sql = "SELECT * FROM livro WHERE autor = ? AND id <> ?";
        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql, autor, idAtual);
        List<Livro> livros = new ArrayList<>();

        for (Map<String, Object> linha : linhas) {
            livros.add(Livro.deMap(linha));
        }

        return livros;
    }

    public void salvar(Livro livro) {
        String sql = "INSERT INTO livro (titulo, autor, ano, preco) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAno(),
                livro.getPreco());
    }

    public void atualizar(Livro livro) {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, ano = ?, preco = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAno(),
                livro.getPreco(),
                livro.getId());
    }

    public void remover(Long id) {
        String sql = "DELETE FROM livro WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}