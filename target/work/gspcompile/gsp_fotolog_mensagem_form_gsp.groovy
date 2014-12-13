import fotolog.Mensagem
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_mensagem_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mensagem/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['name':("foto.id"),'value':(mensagemInstance?.foto?.id)],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: mensagemInstance, field: 'remetente', 'error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("mensagem.remetente.label")],-1)
printHtmlPart(3)
invokeTag('textField','g',9,['required':(""),'value':(mensagemInstance?.remetente),'name':("remetente")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mensagemInstance, field: 'emailremetente', 'error'))
printHtmlPart(2)
invokeTag('message','g',15,['code':("mensagem.emailremetente.label")],-1)
printHtmlPart(3)
invokeTag('textField','g',18,['required':(""),'value':(mensagemInstance?.emailremetente),'name':("emailremetente")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mensagemInstance, field: 'mensagem', 'error'))
printHtmlPart(2)
invokeTag('message','g',24,['code':("mensagem.mensagem.label")],-1)
printHtmlPart(3)
invokeTag('textArea','g',27,['required':(""),'value':(mensagemInstance?.mensagem),'name':("mensagem"),'rows':("5"),'cols':("20")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mensagemInstance, field: 'autorizada', 'error'))
printHtmlPart(5)
invokeTag('message','g',33,['code':("mensagem.autorizada.label")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',36,['name':("autorizada"),'value':(mensagemInstance?.autorizada)],-1)
printHtmlPart(7)
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
