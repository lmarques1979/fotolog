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
			     <hr>
			</g:if>
			
			<g:if test="${midiaInstanceCount>0}">
			<table class="audio">
				
				<g:each in="${midiaInstanceList}" status="i" var="midiaInstance">
					<tr>
						
						<td>${midiaInstance?.legenda}</td>
						
						<td>
							<audio controls>
								 <source src="${diretorio + File.separator + midiaInstance.evento.nome + File.separator + midiaInstance?.midia+'.'+midiaInstance?.extensao}" type='audio/mp3'>
								 <p>${message(code: 'midia.dowbrowsernotsupoortaudio.label')}</p>
							</audio>
						</td>
						<td>
							<g:link url="${diretorio + File.separator + midiaInstance.evento.nome + File.separator + midiaInstance?.midia+'.'+midiaInstance?.extensao}">
								<asset:image src="download.png" title="${message(code: 'midia.download.label', default: 'Download')}"/>
							</g:link>
						</td>
					</tr>
				</g:each>
			</table>
			</g:if>
			
		</div>
		<div class="pagination"> 
			<g:paginate total="${midiaInstanceCount ? midiaInstanceCount : 0}" params="${params}" />
		</div>
		
	</body>
	
</html>
