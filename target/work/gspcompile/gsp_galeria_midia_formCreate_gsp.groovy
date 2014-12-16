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
expressionOut.print(hasErrors(bean: midiaInstance, field: 'tipomidia', 'error'))
printHtmlPart(2)
invokeTag('message','g',8,['code':("tipomidia.label"),'default':("Evento")],-1)
printHtmlPart(3)
invokeTag('select','g',11,['id':("tipomidia"),'name':("tipomidia.id"),'from':(fotolog.TipoMidia.list()),'optionKey':("id"),'optionValue':("descricao"),'required':(""),'value':(tipomidia),'class':("many-to-one")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'evento', 'error'))
printHtmlPart(5)
invokeTag('message','g',18,['code':("midia.evento.label"),'default':("Evento")],-1)
printHtmlPart(6)
invokeTag('select','g',21,['id':("evento"),'name':("evento.id"),'from':(fotolog.Evento.list()),'optionKey':("id"),'optionValue':("nome"),'required':(""),'value':(evento),'class':("many-to-one")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(8)
invokeTag('message','g',28,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(10)
invokeTag('message','g',40,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(11)
invokeTag('textField','g',43,['name':("video"),'size':("35")],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(8)
invokeTag('message','g',52,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'legenda', 'error'))
printHtmlPart(14)
invokeTag('message','g',62,['code':("midia.legenda.label"),'default':("Legenda")],-1)
printHtmlPart(15)
invokeTag('textField','g',65,['name':("legenda"),'value':(midiaInstance?.legenda)],-1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418558332000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
