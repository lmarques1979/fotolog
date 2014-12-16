<%@ page import="fotolog.Midia" %>
<g:set var="evento" value="${midiaInstance?.evento?.id}" />

<g:hiddenField id="midiabanco" name="midiabanco" value="${midiaInstance?.evento?.tipomidia?.id}" />
<g:hiddenField name="dadosMidia.id" value="${dadosMidiaInstance[0].id}" />

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'evento', 'error')} required">
	<label for="evento">
		<g:message code="midia.evento.label" default="Evento" />
		<span class="required-indicator">*</span>
	</label>
	<select id="eventoedit" name="evento.id">
		<g:each in="${fotolog.Evento.list()}" status="i" var="eventoInstance">
			<g:if test="${evento== eventoInstance.id}">
  				<option selected=selected value="${eventoInstance.id}" data-tipomidia="${eventoInstance?.tipomidia?.id}" >${eventoInstance?.nome}</option>
			</g:if>
			<g:else>
				<option value="${eventoInstance.id}" data-tipomidia="${eventoInstance?.tipomidia?.id}" >${eventoInstance?.nome}</option>
			</g:else>
		</g:each>
	</select> 
</div>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'evento', 'error')} required">
		<div class="imagemedit">
			<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
				<label for="imagem">
					<g:message code="midia.imagem.label" default="Imagem" />
					<span class="required-indicator">*</span>
				</label>
				<input type="file" name="arquivo"/>
			
		</div>
</div>

<div class="videoedit" style="display:block;">
	<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
		<label for="imagem">
			<g:message code="midia.imagem.label" default="Imagem" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="video" size="35" value="${midiaInstance?.midia}"/>
	</div>
</div>

<div class="musicaedit">
	<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
		<label for="imagem">
			<g:message code="midia.imagem.label" default="Imagem" />
			<span class="required-indicator">*</span> 
		</label>
		<input type="file" name="musica"/>
	</div>
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
	
	<g:textField name="largura" size="8" value="${dadosMidiaInstance[0].largura ? dadosMidiaInstance[0].largura : ''}"/><label class="desc" for="largura"><g:message code="midia.larguramedida.label" default="Legenda" /></label>
	
</div>

<div class="fieldcontain">
	<label for="altura">
		<g:message code="midia.altura.label" default="Legenda" />
	</label>
	<g:textField name="altura" size="8" value="${dadosMidiaInstance[0].altura ? dadosMidiaInstance[0].altura : ''}"/><label class="desc" for="altura"><g:message code="midia.alturamedida.label" default="Legenda" /></label>
	
</div>

