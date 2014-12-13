<%@ page import="fotolog.TipoMidia" %>



<div class="fieldcontain ${hasErrors(bean: tipoMidiaInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="tipoMidia.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" required="" value="${tipoMidiaInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: tipoMidiaInstance, field: 'midias', 'error')} ">
	<label for="midias">
		<g:message code="tipoMidia.midias.label" default="Midias" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${tipoMidiaInstance?.midias?}" var="m">
    <li><g:link controller="midia" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="midia" action="create" params="['tipoMidia.id': tipoMidiaInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'midia.label', default: 'Midia')])}</g:link>
</li>
</ul>


</div>

