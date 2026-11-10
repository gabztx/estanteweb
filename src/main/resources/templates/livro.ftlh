<#include "cabecalho.ftlh" />

<h1>${livro.titulo}</h1>
<ul>
    <li>Autor: ${livro.autor}</li>
    <li>Ano: ${livro.ano?c}</li>
    <li>Preço: R$ ${livro.preco}</li>
</ul>

<#if doMesmoAutor?size != 0>
    <h2>Outros títulos de ${livro.autor}</h2>
    <ul>
        <#list doMesmoAutor as outro>
            <li><a href="/livros/${outro.id?c}">${outro.titulo}</a></li>
        </#list>
    </ul>
</#if>

<p><a href="/livros/${livro.id?c}/editar">Corrigir este livro</a></p>
<p><a href="/livros/${livro.id?c}/remover">Remover este livro</a></p>
<p><a href="/livros/html">Voltar para o acervo</a></p>