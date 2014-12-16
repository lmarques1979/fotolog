<%@ page import="fotolog.Midia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'midia.label', default: 'Foto')}" />
		<asset:javascript src="jssor.player.ytiframe.js"/>
		<asset:javascript src="video_init.js"/>
		<title><g:message code="midia.list.label"/></title>
	</head> 
	<body>
		<a href="#list-midia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-midia" class="content scaffold-list" role="main">
			
			<div class="eventos">
				<sec:ifNotLoggedIn>
					<g:form controller="midia" action="listavideo" >
						<p><g:message code="galeriavideos.label"/></p><g:select onchange="this.form.submit()" noSelection="['0':'Selecione um evento...']" value="${filtrovideo}" name="filtrovideo" optionValue="nome" optionKey="id" from="${fotolog.Evento.findAll("from Evento e where e.tipomidia.id=2")}"/>
					</g:form>
				</sec:ifNotLoggedIn>
			</div><div class="clearer"></div>
			
			<g:if test="${eventoInstance}">
			     <h1>${eventoInstance.nome}</h1>  
			</g:if>
			
			
					<!-- Jssor Slider Begin -->
				    <!-- You can move inline styles to css file or css block. -->
				    <div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 640px;
				        height: 390px;">
				        <!-- Slides Container -->
				        <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 640px; height: 390px;
				            overflow: hidden;">
				           			<div>
						                <div u="player" style="position: relative; top: 0px; left: 0px; width: 640px; height: 390px; overflow: hidden;">
						                    <!-- iframe in ebay page is not allowed, youtube iframe video is not supported for ebay listing -->
						                    <iframe pHandler="ytiframe" pHideControls="0" width="640" height="390" style="z-index: 0;" url="http://www.youtube.com/embed/YbT0xy_Jai0?enablejsapi=1&version=3&playerapiid=ytplayer&fs=1&wmode=transparent" frameborder="0" scrolling="no"></iframe>
						                </div>
						            </div>
				           
				        </div>
				 
				        <!-- Bullet Navigator Skin Begin -->
				        <asset:stylesheet src="videos.css"/>
				        
				        <!-- bullet navigator container -->
				        <div u="navigator" class="jssorb03" style="position: absolute; bottom: 6px; left: 6px;">
				            <!-- bullet navigator item prototype -->
				            <div u="prototype" style="POSITION: absolute; WIDTH: 21px; HEIGHT: 21px; text-align:center; line-height:21px; color:White; font-size:12px;"><NumberTemplate></NumberTemplate></div>
				        </div>
				        <!-- Bullet Navigator Skin End -->
				    </div>
				    <!-- Jssor Slider End -->
					
		   
			
		</div>
		

	
	</body>
	
</html>
