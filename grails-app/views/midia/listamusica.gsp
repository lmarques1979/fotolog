<%@ page import="fotolog.Midia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'midia.label', default: 'Foto')}" />
		<title><g:message code="midia.list.label"/></title>
	</head> 
	<body>
		<a href="#list-midia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-midia" class="content scaffold-list" role="main">
			
			<div class="eventos">
				<sec:ifNotLoggedIn>
					<g:form controller="midia" action="listamusica" >
						<p><g:message code="galeriamusica.label"/></p><g:select onchange="this.form.submit()" noSelection="['0':'Selecione um evento...']" value="${filtromusica}" name="filtromusica" optionValue="nome" optionKey="id" from="${fotolog.Evento.findAll("from Evento e where e.tipomidia.id=3")}"/>
					</g:form>
				</sec:ifNotLoggedIn>
			</div><div class="clearer"></div>
			
			<g:if test="${eventoInstance}">
			     <h1>${eventoInstance.nome}</h1>  
			</g:if>
			
		</div>
	
	</body>
	
</html>
