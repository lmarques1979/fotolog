<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'extensoesPermitidas.label', default: 'ExtensoesPermitidas')}" />
		<title><g:message code="extensao.create.label"/></title>
	</head>
	<body>
		<a href="#create-extensoesPermitidas" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="lista" action="index"><g:message code="extensao.list.label" /></g:link></li>
			</ul>
		</div>
		<div id="create-extensoesPermitidas" class="content scaffold-create" role="main">
			<h1><g:message code="extensao.create.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${extensoesPermitidasInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${extensoesPermitidasInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:extensoesPermitidasInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
