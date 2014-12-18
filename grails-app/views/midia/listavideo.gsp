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
					<g:form controller="midia" action="listavideo" >
						<p><g:message code="galeriavideos.label"/></p><g:select onchange="this.form.submit()" noSelection="['0':'Selecione um evento...']" value="${filtrovideo}" name="filtrovideo" optionValue="nome" optionKey="id" from="${fotolog.Evento.findAll("from Evento e where e.tipomidia.id=2")}"/>
					</g:form>
				</sec:ifNotLoggedIn>
			</div><div class="clearer"></div>
			
			<g:each in="${midiaInstanceList}" status="i" var="midiaInstance">
				<g:if test="${midiaInstance?.midia}">
				  <div id="videos" style="width:${midiaInstance?.largura ? midiaInstance?.largura + 'px;' : '560px;'}">
						
						<span class="legenda">${midiaInstance?.legenda}</span>
						<video class="iframevideo" height="${midiaInstance?.altura ? midiaInstance?.altura : '315'} width="${midiaInstance?.largura ? midiaInstance?.largura : '560' }" controls>
						  
						  <source src="${diretorio + midiaInstance?.evento?.nome + File.separator + midiaInstance?.midia+'.'+midiaInstance?.extensao}">
						  <p>${message(code: 'midia.dowbrowsernotsupoortaudio.label')}</p>
						</video>
					</div>	
				</g:if>
				<g:else>
					 <div id="videos" style="width:${midiaInstance?.largura ? midiaInstance?.largura + 'px;' : '560px;'}">
						<iframe class="iframevideo" width="${midiaInstance?.largura ? midiaInstance?.largura : '560' }" height="${midiaInstance?.altura ? midiaInstance?.altura : '315'}" src="${midiaInstance?.url}" frameborder="0" allowfullscreen></iframe>
					 </div>
				</g:else>
			</g:each>
			
			
		</div>
		
		<div class="pagination">
			<g:paginate total="${midiaInstanceCount ? midiaInstanceCount : 0}" params="${params}" />
		</div>
	
	</body>
	
</html>
