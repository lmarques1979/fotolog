
<%@ page import="fotolog.ExtensoesPermitidas" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'extensoesPermitidas.label', default: 'ExtensoesPermitidas')}" />
		<title><g:message code="extensao.list.label" /></title>
	</head>
	<body>
		<a href="#list-extensoesPermitidas" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="novo" action="create"><g:message code="extensao.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-extensoesPermitidas" class="content scaffold-list" role="main">
			<h1><g:message code="extensao.list.label" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="extensao" title="${message(code: 'extensoesPermitidas.extensao.label', default: 'Extensao')}" />
					
						<g:sortableColumn property="descricao" title="${message(code: 'extensoesPermitidas.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="tamanhomaximo" title="${message(code: 'extensoesPermitidas.tamanhomaximo.label', default: 'Tamanhomaximo')}" />
					
						<th><g:message code="extensoesPermitidas.tipomidia.label" default="Tipomidia" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${extensoesPermitidasInstanceList}" status="i" var="extensoesPermitidasInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${extensoesPermitidasInstance.id}">${fieldValue(bean: extensoesPermitidasInstance, field: "extensao")}</g:link></td>
					
						<td>${fieldValue(bean: extensoesPermitidasInstance, field: "descricao")}</td>
					
						<td>${fieldValue(bean: extensoesPermitidasInstance, field: "tamanhomaximo")}</td>
					
						<td>${extensoesPermitidasInstance?.tipomidia?.descricao}</td>
					
						
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${extensoesPermitidasInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
