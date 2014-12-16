
<%@ page import="fotolog.DadosMidia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dadosMidia.label', default: 'DadosMidia')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dadosMidia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-dadosMidia" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="altura" title="${message(code: 'dadosMidia.altura.label', default: 'Altura')}" />
					
						<g:sortableColumn property="largura" title="${message(code: 'dadosMidia.largura.label', default: 'Largura')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'dadosMidia.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'dadosMidia.lastUpdated.label', default: 'Last Updated')}" />
					
						<th><g:message code="dadosMidia.midia.label" default="Midia" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dadosMidiaInstanceList}" status="i" var="dadosMidiaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dadosMidiaInstance.id}">${fieldValue(bean: dadosMidiaInstance, field: "altura")}</g:link></td>
					
						<td>${fieldValue(bean: dadosMidiaInstance, field: "largura")}</td>
					
						<td><g:formatDate date="${dadosMidiaInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${dadosMidiaInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: dadosMidiaInstance, field: "midia")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dadosMidiaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
