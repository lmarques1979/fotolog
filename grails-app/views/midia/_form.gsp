<%@ page import="fotolog.Midia" %>

<g:if test="${params.action == 'create'}">
	<g:set var="evento" value="${session["evento.id"]}" />
	<g:set var="tipomidia" value="${session["tipomidia.id"]}" />
	
</g:if>
<g:else>
	<g:set var="evento" value="${midiaInstance?.evento?.id}" />
	<g:set var="tipomidia" value="${midiaInstance?.tipomidia?.id}" />
</g:else>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'evento', 'error')} required">
	<label for="evento">
		<g:message code="midia.evento.label" default="Evento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="evento" name="evento.id" from="${fotolog.Evento.list()}" optionKey="id" optionValue="nome" required="" value="${evento}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} ">
	<label for="imagem">
		<g:message code="midia.imagem.label" default="Imagem" />
		
	</label>
	<input type="file" name="arquivo" value="${usuarioInstance?.midia}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'legenda', 'error')} ">
	<label for="legenda">
		<g:message code="midia.legenda.label" default="Legenda" />
		
	</label>
	<g:textField name="legenda" value="${midiaInstance?.legenda}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'tipomidia', 'error')} required">
	<label for="evento">
		<g:message code="tipomidia.label" default="Evento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipomidia" name="tipomidia.id" from="${fotolog.TipoMidia.list()}" optionKey="id" optionValue="descricao" required="" value="${tipomidia}" class="many-to-one"/>

</div>

