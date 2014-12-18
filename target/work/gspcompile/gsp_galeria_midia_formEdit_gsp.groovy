import fotolog.Midia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_midia_formEdit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/midia/_formEdit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',2,['var':("evento"),'value':(midiaInstance?.evento?.id)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',4,['id':("midiabanco"),'name':("midiabanco"),'value':(midiaInstance?.evento?.tipomidia?.id)],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',5,['name':("dadosMidia.id"),'value':(dadosMidiaInstance[0].id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'evento', 'error'))
printHtmlPart(3)
invokeTag('message','g',9,['code':("midia.evento.label"),'default':("Evento")],-1)
printHtmlPart(4)
loop:{
int i = 0
for( eventoInstance in (fotolog.Evento.list()) ) {
printHtmlPart(5)
if(true && (evento== eventoInstance.id)) {
printHtmlPart(6)
expressionOut.print(eventoInstance.id)
printHtmlPart(7)
expressionOut.print(eventoInstance?.tipomidia?.id)
printHtmlPart(8)
expressionOut.print(eventoInstance?.nome)
printHtmlPart(9)
}
else {
printHtmlPart(10)
expressionOut.print(eventoInstance.id)
printHtmlPart(7)
expressionOut.print(eventoInstance?.tipomidia?.id)
printHtmlPart(8)
expressionOut.print(eventoInstance?.nome)
printHtmlPart(9)
}
printHtmlPart(11)
i++
}
}
printHtmlPart(12)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'evento', 'error'))
printHtmlPart(13)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(14)
invokeTag('message','g',28,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(16)
invokeTag('message','g',39,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(17)
invokeTag('textField','g',42,['name':("video"),'size':("35"),'value':(midiaInstance?.midia)],-1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(16)
invokeTag('message','g',49,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'legenda', 'error'))
printHtmlPart(20)
invokeTag('message','g',58,['code':("midia.legenda.label"),'default':("Legenda")],-1)
printHtmlPart(21)
invokeTag('textField','g',61,['name':("legenda"),'value':(midiaInstance?.legenda)],-1)
printHtmlPart(22)
invokeTag('message','g',67,['code':("midia.largura.label"),'default':("Legenda")],-1)
printHtmlPart(23)
invokeTag('textField','g',71,['name':("largura"),'size':("8"),'value':(dadosMidiaInstance[0].largura ? dadosMidiaInstance[0].largura : '')],-1)
printHtmlPart(24)
invokeTag('message','g',71,['code':("midia.larguramedida.label"),'default':("Legenda")],-1)
printHtmlPart(25)
invokeTag('message','g',77,['code':("midia.altura.label"),'default':("Legenda")],-1)
printHtmlPart(26)
invokeTag('textField','g',79,['name':("altura"),'size':("8"),'value':(dadosMidiaInstance[0].altura ? dadosMidiaInstance[0].altura : '')],-1)
printHtmlPart(27)
invokeTag('message','g',79,['code':("midia.alturamedida.label"),'default':("Legenda")],-1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418763005000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
