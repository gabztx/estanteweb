<#include "cabecalho.ftlh" />

<h1>Entrar</h1>

<#if erro??>
    <p style="color: red;">${erro}</p>
</#if>

<form method="POST" action="/login">
    E-mail: <input type="email" name="email" value="${email!}" /> <br />
    Senha: <input type="password" name="senha" /> <br />
    <input type="submit" value="Entrar" />
</form>