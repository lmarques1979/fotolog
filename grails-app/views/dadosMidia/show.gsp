
<%@ page import="fotolog.DadosMidia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dadosMidia.label', default: 'DadosMidia')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-dadosMidia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-dadosMidia" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list dadosMidia">
			
				<g:if test="${dadosMidiaInstance?.altura}">
				<li class="fieldcontain">
					<span id="altura-label" class="property-label"><g:message code="dadosMidia.altura.label" default="Altura" /></span>
					
						<span class="property-value" aria-labelledby="altura-label"><g:fieldValue bean="${dadosMidiaInstance}" field="altura"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dadosMidiaInstance?.largura}">
				<li class="fieldcontain">
					<span id="largura-label" class="property-label"><g:message code="dadosMidia.largura.label" default="Largura" /></span>
					
						<span class="property-value" aria-labelledby="largura-label"><g:fieldValue bean="${dadosMidiaInstance}" field="largura"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dadosMidiaInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="dadosMidia.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${dadosMidiaInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${dadosMidiaInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="dadosMidia.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${dadosMidiaInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${dadosMidiaInstance?.midia}">
				<li class="fieldcontain">
					<span id="midia-label" class="property-label"><g:message code="dadosMidia.midia.label" default="Midia" /></span>
					
						<span class="property-value" aria-labelledby="midia-label"><g:link controller="midia" action="show" id="${dadosMidiaInstance?.midia?.id}">${dadosMidiaInstance?.midia?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:dadosMidiaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${dadosMidiaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
