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
if(true && (params.action == 'create' || params.action == 'save')) {
printHtmlPart(3)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'tipomidia', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("tipomidia.label"),'default':("Evento")],-1)
printHtmlPart(5)
invokeTag('select','g',17,['id':("tipomidia"),'name':("tipomidia.id"),'from':(fotolog.TipoMidia.list()),'optionKey':("id"),'optionValue':("descricao"),'required':(""),'value':(tipomidia),'class':("many-to-one")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (params.action == 'edit')) {
printHtmlPart(3)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'tipomidia', 'error'))
printHtmlPart(4)
invokeTag('message','g',27,['code':("tipomidia.label"),'default':("Evento")],-1)
printHtmlPart(5)
invokeTag('select','g',30,['id':("tipomidiaedit"),'name':("tipomidia.id"),'from':(fotolog.TipoMidia.list()),'optionKey':("id"),'optionValue':("descricao"),'required':(""),'value':(tipomidia),'class':("many-to-one")],-1)
printHtmlPart(6)
}
printHtmlPart(8)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'evento', 'error'))
printHtmlPart(9)
invokeTag('message','g',38,['code':("midia.evento.label"),'default':("Evento")],-1)
printHtmlPart(10)
invokeTag('select','g',41,['id':("evento"),'name':("evento.id"),'from':(fotolog.Evento.list()),'optionKey':("id"),'optionValue':("nome"),'required':(""),'value':(evento),'class':("many-to-one")],-1)
printHtmlPart(11)
if(true && (params.action == 'edit')) {
printHtmlPart(12)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'evento', 'error'))
printHtmlPart(13)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(14)
invokeTag('message','g',50,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(15)
}
printHtmlPart(7)
if(true && (params.action == 'edit')) {
printHtmlPart(16)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(17)
invokeTag('message','g',63,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(18)
invokeTag('textField','g',66,['name':("video"),'size':("35")],-1)
printHtmlPart(19)
}
printHtmlPart(7)
if(true && (params.action == 'edit')) {
printHtmlPart(20)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(17)
invokeTag('message','g',75,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(21)
}
printHtmlPart(2)
if(true && (params.action == 'create' || params.action == 'save')) {
printHtmlPart(22)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(23)
invokeTag('message','g',88,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(24)
}
printHtmlPart(7)
if(true && (params.action == 'create' || params.action == 'save')) {
printHtmlPart(25)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(23)
invokeTag('message','g',101,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(5)
invokeTag('textField','g',104,['name':("video"),'size':("35")],-1)
printHtmlPart(26)
}
printHtmlPart(7)
if(true && (params.action == 'create' || params.action == 'save')) {
printHtmlPart(27)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'midia', 'error'))
printHtmlPart(23)
invokeTag('message','g',113,['code':("midia.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(28)
}
printHtmlPart(8)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'legenda', 'error'))
printHtmlPart(29)
invokeTag('message','g',123,['code':("midia.legenda.label"),'default':("Legenda")],-1)
printHtmlPart(30)
invokeTag('textField','g',126,['name':("legenda"),'value':(midiaInstance?.legenda)],-1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418525670000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
