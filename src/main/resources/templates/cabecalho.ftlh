<header>
    <h1>EstanteWeb</h1>
    <nav>
        <a href="/">Início</a>
        <a href="/livros/html">Livros</a>
        <a href="/sugestoes">Sugestões</a>
        <a href="/contato">Contato</a>
        <#if usuarioLogado??>
            Olá, ${usuarioLogado.nome}
            <form method="POST" action="/logout" style="display: inline;">
                <input type="submit" value="Sair" />
            </form>
        <#else>
            <a href="/login">Entrar</a>
        </#if>
    </nav>
</header>
<hr>