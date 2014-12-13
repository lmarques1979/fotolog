
<%@ page import="fotolog.Evento" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'evento.label', default: 'Evento')}" />
		<title><g:message code="evento.list.label" /></title>
	</head>
	<body>
		<a href="#list-evento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="novo" action="create"><g:message code="evento.new.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-evento" class="content scaffold-list" role="main">
			<h1><g:message code="evento.list.label" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'evento.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="descricao" title="${message(code: 'evento.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="data" title="${message(code: 'evento.data.label', default: 'Data')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${eventoInstanceList}" status="i" var="eventoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${eventoInstance.id}">${fieldValue(bean: eventoInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: eventoInstance, field: "descricao")}</td>
					
						<td><g:formatDate date="${eventoInstance.data}" format="dd/MM/yyyy" /></td>
					
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${eventoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
