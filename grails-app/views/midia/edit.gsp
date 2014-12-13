<%@ page import="fotolog.Midia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'midia.label', default: 'Foto')}" />
		<title><g:message code="midia.edit.label" /></title>
	</head>
	<body>
		<a href="#edit-midia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="lista" action="index"><g:message code="midia.list.label" /></g:link></li>
				<li><g:link class="novo" action="create"><g:message code="midia.create.label"  /></g:link></li>
			</ul>
		</div>
		<div id="edit-midia" class="content scaffold-edit" role="main">
			<h1><g:message code="midia.edit.label" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${midiaInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${midiaInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:uploadForm url="[resource:midiaInstance, action:'update']">
				<g:hiddenField name="version" value="${midiaInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:uploadForm>
		</div>
	</body>
</html>
