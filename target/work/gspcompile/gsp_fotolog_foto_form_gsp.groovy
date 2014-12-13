import fotolog.Foto
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_foto_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/foto/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (params.action == 'create')) {
printHtmlPart(1)
invokeTag('set','g',4,['var':("evento"),'value':(session["evento.id"])],-1)
printHtmlPart(2)
}
else {
printHtmlPart(1)
invokeTag('set','g',8,['var':("evento"),'value':(fotoInstance?.evento?.id)],-1)
printHtmlPart(3)
}
printHtmlPart(4)
expressionOut.print(hasErrors(bean: fotoInstance, field: 'evento', 'error'))
printHtmlPart(5)
invokeTag('message','g',13,['code':("foto.evento.label"),'default':("Evento")],-1)
printHtmlPart(6)
invokeTag('select','g',16,['id':("evento"),'name':("evento.id"),'from':(fotolog.Evento.list()),'optionKey':("id"),'optionValue':("nome"),'required':(""),'value':(evento),'class':("many-to-one")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: fotoInstance, field: 'imagem', 'error'))
printHtmlPart(8)
invokeTag('message','g',22,['code':("mensagem.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(9)
expressionOut.print(usuarioInstance?.imagem)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: fotoInstance, field: 'legenda', 'error'))
printHtmlPart(11)
invokeTag('message','g',31,['code':("foto.legenda.label"),'default':("Legenda")],-1)
printHtmlPart(12)
invokeTag('textField','g',34,['name':("legenda"),'value':(fotoInstance?.legenda)],-1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1417635780000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
