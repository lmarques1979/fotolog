<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<asset:javascript src="formchange.js"/>
		<g:set var="entityName" value="${message(code: 'midia.label', default: 'Foto')}" />
		<title><g:message code="midia.create.label" /></title>
	</head>
	<body>
		<a href="#create-midia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="lista" action="index"><g:message code="midia.list.label" /></g:link></li>
			</ul>
		</div>
		<div id="create-midia" class="content scaffold-create" role="main">
			<h1><g:message code="midia.create.label"/></h1>
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
			<g:uploadForm url="[resource:midiaInstance, action:'save']">
				<g:hiddenField name="tipo" value="create" />
				<fieldset class="form">
					<g:render template="formCreate"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:uploadForm> 
		</div>
	
	</body>
</html>
