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
printHtmlPart(1)
invokeTag('set','g',4,['var':("tipomidia"),'value':(session["tipomidia.id"])],-1)
printHtmlPart(2)
}
else {
printHtmlPart(1)
invokeTag('set','g',8,['var':("evento"),'value':(midiaInstance?.evento?.id)],-1)
printHtmlPart(1)
invokeTag('set','g',9,['var':("tipomidia"),'value':(midiaInstance?.tipomidia?.id)],-1)
printHtmlPart(0)
}
printHtmlPart(3)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'tipomidia', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("tipomidia.label"),'default':("Evento")],-1)
printHtmlPart(5)
invokeTag('select','g',18,['id':("tipomidia"),'name':("tipomidia.id"),'from':(fotolog.TipoMidia.list()),'optionKey':("id"),'optionValue':("descricao"),'required':(""),'value':(tipomidia),'class':("many-to-one")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'evento', 'error'))
printHtmlPart(7)
invokeTag('message','g',27,['code':("midia.evento.label"),'default':("Evento")],-1)
printHtmlPart(8)
invokeTag('select','g',30,['id':("evento"),'name':("evento.id"),'from':(fotolog.Evento.list()),'optionKey':("id"),'optionValue':("nome"),'required':(""),'value':(evento),'class':("many-to-one")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(10)
invokeTag('message','g',37,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(11)
expressionOut.print(usuarioInstance?.midia)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(13)
invokeTag('textField','g',51,['name':("midia"),'size':("35")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(10)
invokeTag('message','g',58,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'legenda', 'error'))
printHtmlPart(16)
invokeTag('message','g',67,['code':("midia.legenda.label"),'default':("Legenda")],-1)
printHtmlPart(17)
invokeTag('textField','g',70,['name':("legenda"),'value':(midiaInstance?.legenda)],-1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418493870000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
