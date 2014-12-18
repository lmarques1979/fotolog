<%@ page import="fotolog.Midia" %>
<g:if test="${midiaInstance?.evento?.id}">
	<g:set var="evento" value="${midiaInstance?.evento?.id}" />
</g:if>
<g:else>
	<g:set var="evento" value="${session["evento.id"]}" />
</g:else>
<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'evento', 'error')} required">
	<label for="evento">
		<g:message code="midia.evento.label" default="Evento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="evento" name="evento.id" from="${fotolog.Evento.list()}" optionKey="id" optionValue="${{it.tipomidia.descricao + ' - ' + it.nome}}" required="" value="${evento}" class="many-to-one"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
	<label for="imagem">
		<g:message code="midia.imagem.label" default="Imagem" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" name="arquivo"/>

</div>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'legenda', 'error')} ">
	<label for="legenda">
		<g:message code="midia.legenda.label" default="Legenda" />
		
	</label>
	<g:textField name="legenda" value="${midiaInstance?.legenda}"/>

</div>

<div class="fieldcontain">
	<label for="largura">
		<g:message code="midia.largura.label" default="Legenda" />
		
	</label>
	<g:textField name="largura" size="8" value="${midiaInstance?.largura}"/><label class="desc" for="largura"><g:message code="midia.larguramedida.label" default="Legenda" /></label>

</div>

<div class="fieldcontain">
	<label for="altura">
		<g:message code="midia.altura.label" default="Legenda" />
	</label>
	<g:textField name="altura" size="8" value="${midiaInstance?.altura}"/><label class="desc" for="altura"><g:message code="midia.alturamedida.label" default="Legenda" /></label>
</div>




