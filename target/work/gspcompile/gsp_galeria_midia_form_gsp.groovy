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
if(true && (midiaInstance?.evento?.id)) {
printHtmlPart(1)
invokeTag('set','g',3,['var':("evento"),'value':(midiaInstance?.evento?.id)],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',6,['var':("evento"),'value':(session["evento.id"])],-1)
printHtmlPart(0)
}
printHtmlPart(2)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'evento', 'error'))
printHtmlPart(3)
invokeTag('message','g',10,['code':("midia.evento.label"),'default':("Evento")],-1)
printHtmlPart(4)
invokeTag('select','g',13,['id':("evento"),'name':("evento.id"),'from':(fotolog.Evento.list()),'optionKey':("id"),'optionValue':({it.tipomidia.descricao + ' - ' + it.nome}),'required':(""),'value':(evento),'class':("many-to-one")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(6)
invokeTag('message','g',19,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'legenda', 'error'))
printHtmlPart(8)
invokeTag('message','g',28,['code':("midia.legenda.label"),'default':("Legenda")],-1)
printHtmlPart(9)
invokeTag('textField','g',31,['name':("legenda"),'value':(midiaInstance?.legenda)],-1)
printHtmlPart(10)
invokeTag('message','g',37,['code':("midia.largura.label"),'default':("Legenda")],-1)
printHtmlPart(9)
invokeTag('textField','g',40,['name':("largura"),'size':("8"),'value':(midiaInstance?.largura)],-1)
printHtmlPart(11)
invokeTag('message','g',40,['code':("midia.larguramedida.label"),'default':("Legenda")],-1)
printHtmlPart(12)
invokeTag('message','g',46,['code':("midia.altura.label"),'default':("Legenda")],-1)
printHtmlPart(13)
invokeTag('textField','g',48,['name':("altura"),'size':("8"),'value':(midiaInstance?.altura)],-1)
printHtmlPart(14)
invokeTag('message','g',48,['code':("midia.alturamedida.label"),'default':("Legenda")],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418931588000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
