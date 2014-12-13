import fotolog.TipoMidia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_tipoMidia_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tipoMidia/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: tipoMidiaInstance, field: 'descricao', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("tipoMidia.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("descricao"),'required':(""),'value':(tipoMidiaInstance?.descricao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: tipoMidiaInstance, field: 'midias', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("tipoMidia.midias.label"),'default':("Midias")],-1)
printHtmlPart(5)
for( m in (tipoMidiaInstance?.midias) ) {
printHtmlPart(6)
createTagBody(2, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',22,['controller':("midia"),'action':("show"),'id':(m.id)],2)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'midia.label', default: 'Midia')]))
})
invokeTag('link','g',25,['controller':("midia"),'action':("create"),'params':(['tipoMidia.id': tipoMidiaInstance?.id])],1)
printHtmlPart(9)
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
