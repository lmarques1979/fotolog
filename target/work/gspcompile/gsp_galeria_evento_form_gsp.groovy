import fotolog.Evento
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_evento_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/evento/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: eventoInstance, field: 'nome', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("evento.nome.label")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("nome"),'required':(""),'value':(eventoInstance?.nome)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventoInstance, field: 'descricao', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("evento.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(5)
invokeTag('textField','g',17,['name':("descricao"),'value':(eventoInstance?.descricao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventoInstance, field: 'data', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("evento.data.label"),'default':("Data")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',26,['name':("data"),'precision':("day"),'value':(eventoInstance?.data),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418330980000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
