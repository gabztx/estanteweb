<#include "cabecalho.ftlh" />

<h1>Remover livro</h1>

<p>Você está prestes a remover este livro:</p>
<ul>
    <li>Título: ${livro.titulo!}</li>
    <li>Autor: ${livro.autor!}</li>
    <li>Ano: ${(livro.ano?c)!}</li>
    <li>Preço: R$ ${livro.preco!}</li>
</ul>

<form method="POST" action="/livros/${livro.id?c}/remover">
    <input type="submit" value="Confirmar remoção" />
</form>

<p><a href="/livros/${livro.id?c}">Desistir</a></p>