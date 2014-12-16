<%@ page import="fotolog.Evento" %>
<%@ page import="fotolog.TipoMidia" %>
<g:set var="tipomidia" value="${midiaInstance?.tipomidia?.id}" />

<div class="fieldcontain ${hasErrors(bean: eventoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="evento.nome.label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${eventoInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: midiaInstance, field: 'tipomidia', 'error')} required">
		<label for="evento">
			<g:message code="tipomidia.label" default="Evento" />
			<span class="required-indicator">*</span>
		</label>
		<g:select id="tipomidia" name="tipomidia.id" from="${fotolog.TipoMidia.list()}" optionKey="id" optionValue="descricao" required="" value="${tipomidia}" class="many-to-one"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: eventoInstance, field: 'descricao', 'error')} ">
	<label for="descricao">
		<g:message code="evento.descricao.label" default="Descricao" />
		
	</label>
	<g:textField name="descricao" value="${eventoInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventoInstance, field: 'data', 'error')} ">
	<label for="data">
		<g:message code="evento.data.label" default="Data" />
		
	</label>
	<g:datePicker name="data" precision="day"  value="${eventoInstance?.data}" default="none" noSelection="['': '']" />

</div>

