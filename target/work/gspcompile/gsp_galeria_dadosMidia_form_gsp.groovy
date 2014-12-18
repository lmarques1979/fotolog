import fotolog.DadosMidia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_dadosMidia_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dadosMidia/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: dadosMidiaInstance, field: 'altura', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("dadosMidia.altura.label"),'default':("Altura")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("altura"),'type':("number"),'value':(dadosMidiaInstance.altura),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: dadosMidiaInstance, field: 'largura', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("dadosMidia.largura.label"),'default':("Largura")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['name':("largura"),'type':("number"),'value':(dadosMidiaInstance.largura),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: dadosMidiaInstance, field: 'midia', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("dadosMidia.midia.label"),'default':("Midia")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['id':("midia"),'name':("midia.id"),'from':(fotolog.Midia.list()),'optionKey':("id"),'required':(""),'value':(dadosMidiaInstance?.midia?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418740085000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
