
<%@ page import="fotolog.TipoMidia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tipoMidia.label', default: 'TipoMidia')}" />
		<title><g:message code="tipomidia.show.label"/></title>
	</head>
	<body>
		<a href="#show-tipoMidia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="lista" action="index"><g:message code="tipomidia.list.label"/></g:link></li>
				<li><g:link class="novo" action="create"><g:message code="tipomidia.new.label"/></g:link></li>
			</ul>
		</div>
		<div id="show-tipoMidia" class="content scaffold-show" role="main">
			<h1><g:message code="tipomidia.show.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tipoMidia">
			
				<g:if test="${tipoMidiaInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="tipoMidia.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${tipoMidiaInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tipoMidiaInstance?.midias}">
				<li class="fieldcontain">
					<span id="midias-label" class="property-label"><g:message code="tipoMidia.midias.label" default="Midias" /></span>
					
						<g:each in="${tipoMidiaInstance.midias}" var="m">
						<span class="property-value" aria-labelledby="midias-label"><g:link controller="midia" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:tipoMidiaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${tipoMidiaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
