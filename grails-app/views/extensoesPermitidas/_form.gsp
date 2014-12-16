<%@ page import="fotolog.ExtensoesPermitidas" %>

<div class="fieldcontain ${hasErrors(bean: extensoesPermitidasInstance, field: 'extensao', 'error')} required">
	<label for="extensao">
		<g:message code="extensoesPermitidas.extensao.label" default="Extensao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="extensao" required="" value="${extensoesPermitidasInstance?.extensao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: extensoesPermitidasInstance, field: 'descricao', 'error')} ">
	<label for="descricao">
		<g:message code="extensoesPermitidas.descricao.label" default="Descricao" />
		
	</label>
	<g:textField name="descricao" value="${extensoesPermitidasInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: extensoesPermitidasInstance, field: 'tamanhomaximo', 'error')} required">
	<label for="tamanhomaximo">
		<g:message code="extensoesPermitidas.tamanhomaximo.label" default="Tamanhomaximo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="tamanhomaximo" type="number" value="${extensoesPermitidasInstance.tamanhomaximo}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: extensoesPermitidasInstance, field: 'tipomidia', 'error')} required">
	<label for="tipomidia">
		<g:message code="extensoesPermitidas.tipomidia.label" default="Tipomidia" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipomidia" name="tipomidia.id" from="${fotolog.TipoMidia.list()}" optionKey="id" optionValue="descricao" required="" value="${extensoesPermitidasInstance?.tipomidia?.id}" class="many-to-one"/>

</div>

