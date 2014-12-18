<%@ page import="fotolog.Midia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'midia.label', default: 'Foto')}" />
		<asset:javascript src="tratamensagem.js"/>
		<asset:javascript src="jssor.js"/>
		<asset:javascript src="jssor.slider.js"/>
		<asset:javascript src="slider_init.js"/>
		<asset:javascript src="enviomensagem.js"/>
		<asset:stylesheet src="slider.css"/>
		<title><g:message code="midia.list.label"/></title>
	</head> 
	<body>
		<a href="#list-midia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-midia" class="content scaffold-list" role="main">
			
			<div class="eventos">
				<sec:ifNotLoggedIn>
					<g:form controller="midia" action="listaporevento" >
						<p><g:message code="eventoscadastrados.label"/></p><g:select onchange="this.form.submit()" noSelection="['0':'Selecione um evento...']" value="${filtroevento}" name="filtroevento" optionValue="${{formatDate(format: 'dd/MM/yyyy', date: it.data) + ' - ' + it.nome}}" optionKey="id" from="${fotolog.Evento.findAll("from Evento e where e.tipomidia.id=1")}"/>
					</g:form>
				</sec:ifNotLoggedIn>
			</div><div class="clearer"></div>
			
			<g:if test="${eventoInstance}">
			     <h1>${eventoInstance.nome}</h1>  
			     <div id="legenda"></div>
			     <div class="totalfotos" data-totalfotos="${midiaInstanceCount}"></div>
			</g:if>
			
			<g:if test="${midiaInstanceCount>0}">
				
			<!-- Jssor Slider Begin -->
		    <!-- You can move inline styles to css file or css block. -->
		    <div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 800px;
		        height: 600px; background: #000; overflow: hidden;">

	       <!-- Loading Screen -->
        	<div u="loading" style="position: absolute; top: 0px; left: 0px;">
	            <div style="filter: alpha(opacity=70); opacity:0.7; position: absolute; display: block;
	                background-color: #000000; top: 0px; left: 0px;width: 100%;height:100%;">
	            </div>
	            <div class="gifloading"></div>
        	</div>
        	

        	<!-- Slides Container -->
        	<div id="slides" u="slides" style="background-color:#000 ; cursor: move; position: absolute; left: 0px; top: 0px; width: 800px; height: 500px; /*width: 800px; height: 356px;*/ overflow: hidden;">
           		<g:each in="${midiaInstanceList}" status="i" var="midiaInstance">
					<div>
						<asset:image class="fotogrande" data-fotoid="${midiaInstance?.id}" data-legenda="${midiaInstance?.legenda}" u="image" src="${midiaInstance?.midia+'.'+midiaInstance?.extensao}" />
						<asset:image u="thumb" src="${midiaInstance?.midia+'.'+midiaInstance?.extensao}"/> 
				   	</div>
				</g:each>
				
				
        	</div>
        	
        	<div class="caption"  style="position:absolute; right:5px; bottom:135px; width:790px;"> 
                
            </div>
        	
        	<!-- Arrow Left -->
        	<span u="arrowleft" class="jssora05l" style="width: 40px; height: 40px; top: 158px; left: 8px;">
        	</span>
	        <!-- Arrow Right -->
	        <span u="arrowright" class="jssora05r" style="width: 40px; height: 40px; top: 158px; right: 8px">
	        </span>
	        <!-- Arrow Navigator Skin End -->
        	
	        <!-- Thumbnail Navigator Skin Begin -->
	        <div u="thumbnavigator" class="jssort01" style="position: absolute; width: 800px; height: 100px; left:0px; bottom: 0px;">
           
	        <div u="slides" style="cursor: move;">
	              <div u="prototype" class="p" style="position: absolute; width: 72px; height: 72px; top: 0; left: 0;">
	                  <div class=w><thumbnailtemplate style=" width: 100%; height: 100%; border: none;position:absolute; top: 0; left: 0;"></thumbnailtemplate></div>
	                  <div class=c></div>
	             </div>
	        </div>
	        <!-- Thumbnail Item Skin End -->
	        </div>
	        </div>
	    	<!-- Jssor Slider End -->
			
			<div class="play"><asset:image u="thumb" id="playButton" src="play.png" title="${message(code: 'playslide.label')}"/></div>
        	<div class="pause"><asset:image u="thumb" id="pauseButton" src="pause.png" title="${message(code: 'pauseslide.label')}"/></div>
        	       	        	        	
        	
			<asset:image class="enviarmensagem" src="enviarmensagem.png" title="${message(code: 'mensagem.enviar.label')}"/>
			
			<div class="message" role="status"></div>
			<div class="ajaxerror"></div>
			
			<g:form class="enviomsg" controller="mensagem" action="enviamensagem" >
			
			<g:hiddenField class="fotoid" name="midia.id" value="" />
			
			<table class="tabelaenvio">
				<tbody class="tabelaenvio">
					<tr>
							<th colspan="3" class="esquerda">${message(code: 'mensagem.enviomensagemth.label')}</th>
					</tr>
					
					<tr>
						<td>${message(code: 'mensagem.remetente.label')}</td>
						<td><g:textField name="remetente" required="" value="${mensagemInstance?.remetente}"/></td>
					</tr>
					<tr>					
						<td>${message(code: 'mensagem.emailremetente.label')}</td>
						<td><g:textField name="emailremetente" required="" value=""/></td>
					</tr>
					<tr>
						<td>${message(code: 'mensagem.mensagem.label')}</td>
						<td><g:textArea required="" name="mensagem" rows="5" cols="20"/></td>
					<tr>
						    	
					<tr>
						 <td colspan="3">
						   	<fieldset class="buttons">
									<g:submitButton name="create" class="save" value="${message(code: 'default.button.enviar.label', default: 'Create')}" />
							</fieldset>
						</td>
			 		</tr>
					</tbody>
				</table>
			</g:form>
			
			<div id="comentarios">
					
					
			</div>	
			
											
   		 </g:if>
	</div>
	
	</body>
	
</html>
