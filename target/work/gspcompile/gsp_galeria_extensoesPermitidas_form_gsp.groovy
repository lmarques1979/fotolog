import fotolog.ExtensoesPermitidas
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_extensoesPermitidas_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/extensoesPermitidas/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: extensoesPermitidasInstance, field: 'extensao', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("extensoesPermitidas.extensao.label"),'default':("Extensao")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("extensao"),'required':(""),'value':(extensoesPermitidasInstance?.extensao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: extensoesPermitidasInstance, field: 'descricao', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("extensoesPermitidas.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(5)
invokeTag('textField','g',17,['name':("descricao"),'value':(extensoesPermitidasInstance?.descricao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: extensoesPermitidasInstance, field: 'tamanhomaximo', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("extensoesPermitidas.tamanhomaximo.label"),'default':("Tamanhomaximo")],-1)
printHtmlPart(2)
invokeTag('field','g',26,['name':("tamanhomaximo"),'type':("number"),'value':(extensoesPermitidasInstance.tamanhomaximo),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: extensoesPermitidasInstance, field: 'tipomidia', 'error'))
printHtmlPart(7)
invokeTag('message','g',32,['code':("extensoesPermitidas.tipomidia.label"),'default':("Tipomidia")],-1)
printHtmlPart(2)
invokeTag('select','g',35,['id':("tipomidia"),'name':("tipomidia.id"),'from':(fotolog.TipoMidia.list()),'optionKey':("id"),'optionValue':("descricao"),'required':(""),'value':(extensoesPermitidasInstance?.tipomidia?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418746788000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
