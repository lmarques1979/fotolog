<%@ page import="fotolog.DadosMidia" %>



<div class="fieldcontain ${hasErrors(bean: dadosMidiaInstance, field: 'altura', 'error')} required">
	<label for="altura">
		<g:message code="dadosMidia.altura.label" default="Altura" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="altura" type="number" value="${dadosMidiaInstance.altura}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: dadosMidiaInstance, field: 'largura', 'error')} required">
	<label for="largura">
		<g:message code="dadosMidia.largura.label" default="Largura" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="largura" type="number" value="${dadosMidiaInstance.largura}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: dadosMidiaInstance, field: 'midia', 'error')} required">
	<label for="midia">
		<g:message code="dadosMidia.midia.label" default="Midia" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="midia" name="midia.id" from="${fotolog.Midia.list()}" optionKey="id" required="" value="${dadosMidiaInstance?.midia?.id}" class="many-to-one"/>

</div>

