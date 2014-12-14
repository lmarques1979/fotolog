<%@ page import="fotolog.Midia" %>
<g:if test="${params.action == 'create'}">
	<g:set var="evento" value="${session["evento.id"]}" />
</g:if>
<g:else>
	<g:set var="evento" value="${midiaInstance?.evento?.id}" />
</g:else>

<!--create e save -->
<g:if test="${params.action == 'create' || params.action == 'save'}">
	<div>
		<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'tipomidia', 'error')} required">
			<label for="evento">
				<g:message code="tipomidia.label" default="Evento" />
				<span class="required-indicator">*</span>
			</label>
			<g:select id="tipomidia" name="tipomidia.id" from="${fotolog.TipoMidia.list()}" optionKey="id" optionValue="descricao" required="" value="${tipomidia}" class="many-to-one"/>
		
		</div>
	</div>
</g:if>

<g:if test="${params.action == 'edit'}">
	<div>
		<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'tipomidia', 'error')} required">
			<label for="evento">
				<g:message code="tipomidia.label" default="Evento" />
				<span class="required-indicator">*</span>
			</label>
			<g:select id="tipomidiaedit" name="tipomidia.id" from="${fotolog.TipoMidia.list()}" optionKey="id" optionValue="descricao" required="" value="${tipomidia}" class="many-to-one"/>
		
		</div>
	</div>
</g:if>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'evento', 'error')} required">
	<label for="evento">
		<g:message code="midia.evento.label" default="Evento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="evento" name="evento.id" from="${fotolog.Evento.list()}" optionKey="id" optionValue="nome" required="" value="${evento}" class="many-to-one"/>
</div>

<!-- Edit -->
<g:if test="${params.action == 'edit'}">
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
</g:if>

<g:if test="${params.action == 'edit'}">
		<div class="videoedit">
			<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
				<label for="imagem">
					<g:message code="midia.imagem.label" default="Imagem" />
					<span class="required-indicator">*</span>
				</label>
				<g:textField name="video" size="35"/>
			</div>
		</div>
</g:if>

<g:if test="${params.action == 'edit'}">
		<div class="musicaedit">
			<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
				<label for="imagem">
					<g:message code="midia.imagem.label" default="Imagem" />
					<span class="required-indicator">*</span> 
				</label>
				<input type="file" name="musica"/>
			</div>
		</div>
</g:if>

<!--create e save -->
<g:if test="${params.action == 'create' || params.action == 'save'}">
	<div class="imagem">
		<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
			<label for="imagem">
				<g:message code="midia.imagem.label" default="Imagem" />
				<span class="required-indicator">*</span>
			</label>
			<input type="file" name="arquivo"/>
		
		</div>
	</div>
</g:if>

<g:if test="${params.action == 'create' || params.action == 'save'}">
	<div class="video">
		<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
			<label for="imagem">
				<g:message code="midia.imagem.label" default="Imagem" />
				<span class="required-indicator">*</span>
			</label>
			<g:textField name="video" size="35"/>
		</div>
	</div>
</g:if>

<g:if test="${params.action == 'create' || params.action == 'save'}">
	<div class="musica">
		<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'midia', 'error')} required">
			<label for="imagem">
				<g:message code="midia.imagem.label" default="Imagem" />
				<span class="required-indicator">*</span> 
			</label>
			<input type="file" name="musica"/>
		</div>
	</div>
</g:if>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'legenda', 'error')} ">
	<label for="legenda">
		<g:message code="midia.legenda.label" default="Legenda" />
		
	</label>
	<g:textField name="legenda" value="${midiaInstance?.legenda}"/>

</div>



