<%@ page import="fotolog.Mensagem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mensagem.label', default: 'Mensagem')}" />
		<title><g:message code="mesagem.show.label"/></title>
	</head>
	<body>
		<a href="#show-mensagem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="show-mensagem" class="content scaffold-show" role="main">
			<h1><g:message code="mesagem.show.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mensagem">
			
				<g:if test="${mensagemInstance?.midia}">
				<li class="fieldcontain">
					<span id="foto-label" class="property-label"><g:message code="mensagem.foto.label" default="Foto" /></span>
					
						<span class="property-value" aria-labelledby="foto-label"><g:link controller="midia" action="show" id="${mensagemInstance?.midia?.id}"><asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="${mensagemInstance?.midia?.midia}" title="${mensagemInstance?.midia?.legenda}"/></g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${mensagemInstance?.remetente}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="mensagem.remetente.label" default="Remetente" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${mensagemInstance}" field="remetente"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${mensagemInstance?.emailremetente}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="mensagem.emailremetente.label" default="Remetente" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${mensagemInstance}" field="emailremetente"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${mensagemInstance?.mensagem}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="mensagem.mensagem.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${mensagemInstance}" field="mensagem"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mensagemInstance?.autorizada}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="mensagem.autorizada.label"/></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${mensagemInstance?.autorizada}" /></span>
					
				</li>
				</g:if>
				
			</ol>
			<g:form url="[resource:mensagemInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${mensagemInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
