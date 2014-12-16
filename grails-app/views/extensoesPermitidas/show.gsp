
<%@ page import="fotolog.ExtensoesPermitidas" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'extensoesPermitidas.label', default: 'ExtensoesPermitidas')}" />
		<title><g:message code="extensao.show.label"/></title>
	</head>
	<body>
		<a href="#show-extensoesPermitidas" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="lista" action="index"><g:message code="extensao.list.label" /></g:link></li>
				<li><g:link class="novo" action="create"><g:message code="extensao.create.label" /></g:link></li>
			</ul>
		</div>
		<div id="show-extensoesPermitidas" class="content scaffold-show" role="main">
			<h1><g:message code="extensao.show.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list extensoesPermitidas">
			
				<g:if test="${extensoesPermitidasInstance?.extensao}">
				<li class="fieldcontain">
					<span id="extensao-label" class="property-label"><g:message code="extensoesPermitidas.extensao.label" default="Extensao" /></span>
					
						<span class="property-value" aria-labelledby="extensao-label"><g:fieldValue bean="${extensoesPermitidasInstance}" field="extensao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${extensoesPermitidasInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="extensoesPermitidas.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${extensoesPermitidasInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${extensoesPermitidasInstance?.tamanhomaximo}">
				<li class="fieldcontain">
					<span id="tamanhomaximo-label" class="property-label"><g:message code="extensoesPermitidas.tamanhomaximo.label" default="Tamanhomaximo" /></span>
					
						<span class="property-value" aria-labelledby="tamanhomaximo-label"><g:fieldValue bean="${extensoesPermitidasInstance}" field="tamanhomaximo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${extensoesPermitidasInstance?.tipomidia}">
				<li class="fieldcontain">
					<span id="tipomidia-label" class="property-label"><g:message code="extensoesPermitidas.tipomidia.label" default="Tipomidia" /></span>
					
						<span class="property-value" aria-labelledby="tipomidia-label"><g:link controller="tipoMidia" action="show" id="${extensoesPermitidasInstance?.tipomidia?.id}">${extensoesPermitidasInstance?.tipomidia?.descricao.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				
			
			</ol>
			<g:form url="[resource:extensoesPermitidasInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${extensoesPermitidasInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
