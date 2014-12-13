<%@ page import="fotolog.Evento" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'evento.label', default: 'Evento')}" />
		<title><g:message code="evento.edit.label" /></title>
	</head>
	<body>
		<a href="#edit-evento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="lista" action="index"><g:message code="evento.list.label" /></g:link></li>
				<li><g:link class="novo" action="create"><g:message code="evento.new.label"/></g:link></li>
			</ul>
		</div>
		<div id="edit-evento" class="content scaffold-edit" role="main">
			<h1><g:message code="evento.edit.label" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${eventoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${eventoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:eventoInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${eventoInstance?.version}" />
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
