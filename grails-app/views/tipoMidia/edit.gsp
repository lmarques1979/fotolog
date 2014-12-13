<%@ page import="fotolog.TipoMidia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tipoMidia.label', default: 'TipoMidia')}" />
		<title><g:message code="tipomidia.edit.label" /></title>
	</head>
	<body>
		<a href="#edit-tipoMidia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="lista" action="index"><g:message code="tipomidia.list.label" /></g:link></li>
				<li><g:link class="novo" action="create"><g:message code="tipomidia.new.label"/></g:link></li>
			</ul>
		</div>
		<div id="edit-tipoMidia" class="content scaffold-edit" role="main">
			<h1><g:message code="tipomidia.edit.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${tipoMidiaInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${tipoMidiaInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:tipoMidiaInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${tipoMidiaInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
