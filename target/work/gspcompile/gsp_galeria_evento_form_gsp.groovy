import fotolog.Evento
import fotolog.TipoMidia
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
printHtmlPart(1)
if(true && (eventoInstance?.tipomidia?.id)) {
printHtmlPart(2)
invokeTag('set','g',5,['var':("tipomidia"),'value':(eventoInstance?.tipomidia?.id)],-1)
printHtmlPart(0)
}
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventoInstance, field: 'nome', 'error'))
printHtmlPart(4)
invokeTag('message','g',10,['code':("evento.nome.label")],-1)
printHtmlPart(5)
invokeTag('textField','g',13,['name':("nome"),'required':(""),'value':(eventoInstance?.nome)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: midiaInstance, field: 'tipomidia', 'error'))
printHtmlPart(7)
invokeTag('message','g',19,['code':("tipomidia.label"),'default':("Evento")],-1)
printHtmlPart(8)
invokeTag('select','g',22,['id':("tipomidia"),'name':("tipomidia.id"),'from':(fotolog.TipoMidia.list()),'optionKey':("id"),'optionValue':("descricao"),'required':(""),'value':(tipomidia),'class':("many-to-one")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: eventoInstance, field: 'descricao', 'error'))
printHtmlPart(10)
invokeTag('message','g',28,['code':("evento.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(11)
invokeTag('textField','g',31,['name':("descricao"),'value':(eventoInstance?.descricao)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: eventoInstance, field: 'data', 'error'))
printHtmlPart(12)
invokeTag('message','g',37,['code':("evento.data.label"),'default':("Data")],-1)
printHtmlPart(11)
invokeTag('datePicker','g',40,['name':("data"),'precision':("day"),'value':(eventoInstance?.data),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418931710000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
