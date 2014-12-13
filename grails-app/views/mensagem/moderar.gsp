<%@ page import="fotolog.Mensagem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mensagem.label', default: 'Mensagem')}" />
		<title><g:message code="mensagem.list.label"/></title>
	</head>
	<body>
		<a href="#list-mensagem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-mensagem" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead> 
					<tr>
					
						<th><g:message code="mensagem.foto.label" default="Foto" /></th>
						
						<th><g:message code="mensagem.remetente.label" default="Remetente" /></th>
						
						<th><g:message code="mensagem.emailremetente.label" default="Foto" /></th>
						
						<g:sortableColumn property="mensagem" title="${message(code: 'mensagem.mensagem.label', default: 'Descricao')}" />
					
						
						
					
						<th><g:message code="mensagem.autorizada.label" default="Autorizada" /></th>
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${mensagemInstanceList}" status="i" var="mensagemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="edit" id="${mensagemInstance.id}">
							<g:if test="${mensagemInstance?.midia?.midia}">
									<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="${mensagemInstance?.midia?.midia}" title="${mensagemInstance?.midia?.legenda ? mensagemInstance?.midia?.legenda : ' '}"/>
							</g:if>
							<g:else>
									<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="noimage.jpg" title=""/>
							</g:else>
						</g:link></td>
						
						<td>${fieldValue(bean: mensagemInstance, field: "remetente")}</td>
						
						<td>${fieldValue(bean: mensagemInstance, field: "emailremetente")}</td>
						
						<td>${fieldValue(bean: mensagemInstance, field: "mensagem")}</td>
					
						<td><g:formatBoolean boolean="${mensagemInstance?.autorizada}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mensagemInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
