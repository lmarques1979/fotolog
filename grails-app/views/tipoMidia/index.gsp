
<%@ page import="fotolog.TipoMidia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tipoMidia.label', default: 'TipoMidia')}" />
		<title><g:message code="tipomidia.list.label"/></title>
	</head>
	<body>
		<a href="#list-tipoMidia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="novo" action="create"><g:message code="tipomidia.new.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-tipoMidia" class="content scaffold-list" role="main">
			<h1><g:message code="tipomidia.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="descricao" title="${message(code: 'tipoMidia.descricao.label', default: 'Descricao')}" />
					
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${tipoMidiaInstanceList}" status="i" var="tipoMidiaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tipoMidiaInstance.id}">${fieldValue(bean: tipoMidiaInstance, field: "descricao")}</g:link></td>
					
						
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tipoMidiaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
