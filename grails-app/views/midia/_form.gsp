<%@ page import="fotolog.Midia" %>
<g:if test="${params.action == 'create'}">
	<g:set var="evento" value="${session["evento.id"]}" />
</g:if>
<g:else>
	<g:set var="evento" value="${midiaInstance?.evento?.id}" />
</g:else>

<div>
	<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'tipomidia', 'error')} required">
		<label for="evento">
			<g:message code="tipomidia.label" default="Evento" />
			<span class="required-indicator">*</span>
		</label>
		<g:select id="tipomidia" name="tipomidia.id" from="${fotolog.TipoMidia.list()}" optionKey="id" optionValue="descricao" required="" value="${usuarioInstance?.midia}}" class="many-to-one"/>
	
	</div>
	
		
</div>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'evento', 'error')} required">
	<label for="evento">
		<g:message code="midia.evento.label" default="Evento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="evento" name="evento.id" from="${fotolog.Evento.list()}" optionKey="id" optionValue="nome" required="" value="${evento}" class="many-to-one"/>

</div>

<g:if test="${midiaInstance.tipomidia.id == 1}">
	<div class="imagem" style="display:block;">
		<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
			<label for="imagem">
				<g:message code="midia.imagem.label" default="Imagem" />
				<span class="required-indicator">*</span>
			</label>
			<input type="file" name="arquivo" value="${midiaInstance.midia}"/>
		
		</div>
	</div>
</g:if>

<g:if test="${midiaInstance.tipomidia.id == 2}">
	<div class="video" style="display:block;">
		<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
			<label for="imagem">
				<g:message code="midia.imagem.label" default="Imagem" />
				<span class="required-indicator">*</span>
			</label>
			<g:textField name="video" size="35" value="${midiaInstance.midia}"/>
		</div>
	</div>
</g:if>

<g:if test="${midiaInstance.tipomidia.id == 3}">
	<div class="musica" style="display:block;">
		<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} ">
			<label for="imagem">
				<g:message code="midia.imagem.label" default="Imagem" />
				
			</label>
			<input type="file" name="musica" value="${midiaInstance.midia}"/>
		</div>
	</div>
</g:if>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'legenda', 'error')} ">
	<label for="legenda">
		<g:message code="midia.legenda.label" default="Legenda" />
		
	</label>
	<g:textField name="legenda" value="${midiaInstance?.legenda}"/>

</div>



