import fotolog.Evento
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_eventoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/evento/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'evento.label', default: 'Evento'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("evento.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',14,['code':("evento.new.label")],-1)
})
invokeTag('link','g',14,['class':("novo"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("evento.list.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('sortableColumn','g',26,['property':("nome"),'title':(message(code: 'evento.nome.label', default: 'Nome'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("descricao"),'title':(message(code: 'evento.descricao.label', default: 'Descricao'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',30,['property':("data"),'title':(message(code: 'evento.data.label', default: 'Data'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( eventoInstance in (eventoInstanceList) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: eventoInstance, field: "nome"))
})
invokeTag('link','g',38,['action':("show"),'id':(eventoInstance.id)],3)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: eventoInstance, field: "descricao"))
printHtmlPart(15)
invokeTag('formatDate','g',42,['date':(eventoInstance.data),'format':("dd/MM/yyyy")],-1)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
invokeTag('paginate','g',50,['total':(eventoInstanceCount ?: 0)],-1)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',53,[:],1)
printHtmlPart(19)
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
