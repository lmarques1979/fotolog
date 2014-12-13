<%@ page import="fotolog.Mensagem" %>
<g:hiddenField name="midia.id" value="${mensagemInstance?.midia?.id }" />
 
<div class="fieldcontain ${hasErrors(bean: mensagemInstance, field: 'remetente', 'error')} required">
	<label for="nome">
		<g:message code="mensagem.remetente.label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField required="" value="${mensagemInstance?.remetente}" name="remetente"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: mensagemInstance, field: 'emailremetente', 'error')} required">
	<label for="nome">
		<g:message code="mensagem.emailremetente.label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField required="" value="${mensagemInstance?.emailremetente}" name="emailremetente"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: mensagemInstance, field: 'mensagem', 'error')} required">
	<label for="nome">
		<g:message code="mensagem.mensagem.label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea required="" value="${mensagemInstance?.mensagem}" name="mensagem" rows="5" cols="20"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: mensagemInstance, field: 'autorizada', 'error')} ">
	<label for="enabled">
		<g:message code="mensagem.autorizada.label"/>
		
	</label>
	<g:checkBox name="autorizada" value="${mensagemInstance?.autorizada}" />

</div>

