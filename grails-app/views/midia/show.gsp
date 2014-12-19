<%@ page import="fotolog.Midia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'midia.label', default: 'Foto')}" />
		<title><g:message code="midia.show.label"/></title>
	</head>
	<body>
		
		<a href="#show-midia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="lista" action="index"><g:message code="midia.list.label"  /></g:link></li>
				<li><g:link class="novo" action="create"><g:message code="midia.create.label" /></g:link></li>
			</ul>
		</div>
		<div id="show-midia" class="content scaffold-show" role="main">
			<h1><g:message code="midia.show.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list midia">
			
				<g:if test="${midiaInstance?.midia}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="midia.imagem.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label">
							<g:if test="${midiaInstance.evento.tipomidia.id==1}">
								<g:if test="${midiaInstance.midia}">
										<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="${midiaInstance.midia+'.'+midiaInstance.extensao}" title="${midiaInstance.legenda ? midiaInstance.legenda : '' }"/>
								</g:if>
								<g:else>
									<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="noimage.jpg" />
								</g:else>
							</g:if>
							<g:if test="${midiaInstance.evento.tipomidia.id==2 || midiaInstance.evento.tipomidia.id==3}">
								<g:if test="${midiaInstance.midia}">
										${midiaInstance.midia}
								</g:if>
								
							</g:if>
						</span>
					
				</li>
				</g:if>
				
				<g:if test="${midiaInstance?.url}">
					<li class="fieldcontain">
						<span id="evento-label" class="property-label"><g:message code="midia.url.label" default="Evento" /></span>
						
							<span class="property-value" aria-labelledby="evento-label">${midiaInstance?.url}</span>
						
					</li>
				</g:if>
				
				<g:if test="${midiaInstance?.evento}">
				<li class="fieldcontain">
					<span id="evento-label" class="property-label"><g:message code="midia.evento.label" default="Evento" /></span>
					
						<span class="property-value" aria-labelledby="evento-label"><g:link controller="evento" action="show" id="${midiaInstance?.evento?.id}">${midiaInstance?.evento?.nome}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${midiaInstance?.legenda}">
				<li class="fieldcontain">
					<span id="evento-label" class="property-label"><g:message code="midia.legenda.label" default="Evento" /></span>
					
						<span class="property-value" aria-labelledby="evento-label">${midiaInstance?.legenda}</span>
					
				</li>
				</g:if>
			
				<g:if test="${midiaInstance?.largura}">
				<li class="fieldcontain">
					<span id="evento-label" class="property-label"><g:message code="midia.largura.label" default="Evento" /></span>
					
						<span class="property-value" aria-labelledby="evento-label">${midiaInstance?.largura}</span>
					
				</li>
				</g:if>
				
				<g:if test="${midiaInstance?.altura}">
				<li class="fieldcontain">
					<span id="evento-label" class="property-label"><g:message code="midia.altura.label" default="Evento" /></span>
					
						<span class="property-value" aria-labelledby="evento-label">${midiaInstance?.altura}</span>
					
				</li>
				</g:if>
								
				
			
			</ol>
			<g:form url="[resource:midiaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${midiaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
