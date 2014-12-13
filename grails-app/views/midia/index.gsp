<%@ page import="fotolog.Midia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'midia.label', default: 'Foto')}" />
		<title><g:message code="midia.list.label"/></title> 
	</head>
	<body>
		<a href="#list-midia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="novo" action="create"><g:message code="midia.create.label"/></g:link></li>
				<li>
					<g:form controller="midia" action="index" >
						<g:select onchange="this.form.submit()" noSelection="['0':'Todos...']" value="${filtroevento}" name="filtroevento" optionValue="${{formatDate(format: 'dd/MM/yyyy', date: it.data) + ' - ' + it.nome}}" optionKey="id" from="${fotolog.Evento.list()}"/><br>
					</g:form>
				</li>
			</ul>
			
		</div>
		
		<div id="list-midia" class="content scaffold-list" role="main">
			
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<th>${message(code: 'midia.midia.label', default: 'Nome')}</th>
						<th>${message(code: 'tipomidia.label', default: 'Nome')}</th>
						<th>${message(code: 'midia.evento.label', default: 'Nome')}</th>
						<th>${message(code: 'midia.legenda.label', default: 'Nome')}</th>
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${midiaInstanceList}" status="i" var="midiaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${midiaInstance.id}">
						
							<g:if test="${midiaInstance.midia}">
									<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="${midiaInstance.midia}" title="${midiaInstance.legenda}"/>
							</g:if>
							<g:else>
								<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="noimage.jpg"/>
							</g:else>
						
						</g:link></td>
					
						<td>${midiaInstance?.tipomidia?.descricao}</td>
						
						<td>${midiaInstance?.evento?.nome}</td>
					
						<td>${fieldValue(bean: midiaInstance, field: "legenda")}</td>
					
											
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${midiaInstanceCount ?: 0}" params="${params}" />
			</div>
		</div>
	</body>
</html>
