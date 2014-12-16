<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Fotolog"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		
		<g:layoutHead/>
	</head>
	<body>
		<%@ page import="fotolog.Evento" %>

		<div class="principal">
			<div class="cabecalho">
				<asset:image src="logofoto.png" alt="Luiz Marques Fotolog" title="Luiz Marques Fotolog"/>
				<sec:ifLoggedIn>
					<g:link class="login" controller="logout" action="index" title="Sair"><asset:image src="logout.png"/></g:link><div class="clearer"></div>
					<g:if test="${sec.loggedInUserInfo(field: 'username') == 'admin'}">
						<div class="nav" role="navigation">
							<ul>
								<li><g:link class="eventos" controller="Evento" action="index"><g:message code="evento.label"/></g:link></li>
								<li><g:link class="midia" controller="Midia" action="index"><g:message code="midia.label"/></g:link></li>
								<li><g:link class="extensoes" controller="ExtensoesPermitidas" action="index"><g:message code="extensoes.label"/></g:link></li>
								<li><g:link class="moderar" controller="Mensagem" action="moderar"><g:message code="mensagemmoderar.label"/></g:link></li>
								<li><g:link class="mensagem" controller="Mensagem" action="index"><g:message code="mensagens.label"/></g:link></li>
								<li><g:link class="configuracoes" controller="Configuracao" action="index"><g:message code="configuracao.label"/></g:link></li>
							</ul>
						</div>
					</g:if>
				</sec:ifLoggedIn>
				<sec:ifNotLoggedIn>
					<g:link class="login" controller="login" action="auth" ><asset:image src="admin.png"/></g:link>
				</sec:ifNotLoggedIn>
			</div><div class="clearer"></div>
			
			<sec:ifNotLoggedIn>
				<div class="menu">
					<div class="nav" role="navigation">
						<ul>
							<li><g:link class="imagem" controller="midia" action="listaporevento"><g:message code="imagem.label"/></g:link></li>
							<li><g:link class="video"  controller="midia" action="listavideo"><g:message code="video.label"/></g:link></li>
							<li><g:link class="musica" controller="midia" action="listamusica"><g:message code="musica.label"/></g:link></li>
						</ul>
					</div>
				</div>	
			</sec:ifNotLoggedIn>	
			
			<div class="conteudo">
				<div class="centro">
					<g:layoutBody/>
				</div>
			</div>
			
			<!--  
			<div class="footer" role="contentinfo">
				<span><g:message code="titulopagina.label"/>
						<br>
						<g:message code="copyrigth.label"/>
				</span>
			</div>
			-->
		</div>
	</body>
</html>
