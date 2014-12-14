import fotolog.Midia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_midia_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/midia/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (params.action == 'create')) {
printHtmlPart(1)
invokeTag('set','g',3,['var':("evento"),'value':(session["evento.id"])],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',6,['var':("evento"),'value':(midiaInstance?.evento?.id)],-1)
printHtmlPart(0)
}
printHtmlPart(2)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'tipomidia', 'error'))
printHtmlPart(3)
invokeTag('message','g',12,['code':("tipomidia.label"),'default':("Evento")],-1)
printHtmlPart(4)
invokeTag('select','g',15,['id':("tipomidia"),'name':("tipomidia.id"),'from':(fotolog.TipoMidia.list()),'optionKey':("id"),'optionValue':("descricao"),'required':(""),'value':(usuarioInstance?.midia}),'class':("many-to-one")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'evento', 'error'))
printHtmlPart(6)
invokeTag('message','g',24,['code':("midia.evento.label"),'default':("Evento")],-1)
printHtmlPart(7)
invokeTag('select','g',27,['id':("evento"),'name':("evento.id"),'from':(fotolog.Evento.list()),'optionKey':("id"),'optionValue':("nome"),'required':(""),'value':(evento),'class':("many-to-one")],-1)
printHtmlPart(8)
if(true && (midiaInstance.tipomidia.id == 1)) {
printHtmlPart(9)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(10)
invokeTag('message','g',35,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(11)
expressionOut.print(midiaInstance.midia)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (midiaInstance.tipomidia.id == 2)) {
printHtmlPart(14)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(15)
invokeTag('textField','g',51,['name':("video"),'size':("35"),'value':(midiaInstance.midia)],-1)
printHtmlPart(16)
}
printHtmlPart(13)
if(true && (midiaInstance.tipomidia.id == 3)) {
printHtmlPart(17)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(18)
invokeTag('message','g',60,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(19)
expressionOut.print(midiaInstance.midia)
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'legenda', 'error'))
printHtmlPart(22)
invokeTag('message','g',70,['code':("midia.legenda.label"),'default':("Legenda")],-1)
printHtmlPart(23)
invokeTag('textField','g',73,['name':("legenda"),'value':(midiaInstance?.legenda)],-1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418495570000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
