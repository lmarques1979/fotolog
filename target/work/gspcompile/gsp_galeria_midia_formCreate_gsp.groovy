import fotolog.Midia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_midia_formCreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/midia/_formCreate.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',2,['var':("evento"),'value':(session["evento.id"])],-1)
printHtmlPart(0)
invokeTag('set','g',3,['var':("tipomidia"),'value':("")],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'evento', 'error'))
printHtmlPart(2)
invokeTag('message','g',7,['code':("midia.evento.label"),'default':("Evento")],-1)
printHtmlPart(3)
loop:{
int i = 0
for( eventoInstance in (fotolog.Evento.list()) ) {
printHtmlPart(4)
expressionOut.print(eventoInstance.id)
printHtmlPart(5)
expressionOut.print(eventoInstance?.tipomidia?.id)
printHtmlPart(6)
expressionOut.print(eventoInstance?.nome)
printHtmlPart(7)
i++
}
}
printHtmlPart(8)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(9)
invokeTag('message','g',22,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(11)
invokeTag('message','g',34,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(12)
invokeTag('textField','g',37,['name':("video"),'size':("35")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(9)
invokeTag('message','g',46,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'legenda', 'error'))
printHtmlPart(15)
invokeTag('message','g',56,['code':("midia.legenda.label"),'default':("Legenda")],-1)
printHtmlPart(16)
invokeTag('textField','g',59,['name':("legenda"),'value':(midiaInstance?.legenda)],-1)
printHtmlPart(17)
invokeTag('message','g',65,['code':("midia.largura.label"),'default':("Legenda")],-1)
printHtmlPart(18)
invokeTag('textField','g',67,['name':("altura"),'size':("8")],-1)
printHtmlPart(19)
invokeTag('message','g',67,['code':("midia.alturamedida.label"),'default':("Legenda")],-1)
printHtmlPart(20)
invokeTag('message','g',72,['code':("midia.altura.label"),'default':("Legenda")],-1)
printHtmlPart(16)
invokeTag('textField','g',75,['name':("largura"),'size':("8")],-1)
printHtmlPart(21)
invokeTag('message','g',75,['code':("midia.larguramedida.label"),'default':("Legenda")],-1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418757183000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
