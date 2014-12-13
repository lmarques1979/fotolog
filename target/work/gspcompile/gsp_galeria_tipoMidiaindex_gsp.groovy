import fotolog.TipoMidia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_tipoMidiaindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tipoMidia/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'tipoMidia.label', default: 'TipoMidia'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("tipomidia.list.label")],-1)
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
invokeTag('message','g',14,['code':("tipomidia.new.label")],-1)
})
invokeTag('link','g',14,['class':("novo"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("tipomidia.list.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('sortableColumn','g',26,['property':("descricao"),'title':(message(code: 'tipoMidia.descricao.label', default: 'Descricao'))],-1)
printHtmlPart(11)
loop:{
int i = 0
for( tipoMidiaInstance in (tipoMidiaInstanceList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: tipoMidiaInstance, field: "descricao"))
})
invokeTag('link','g',35,['action':("show"),'id':(tipoMidiaInstance.id)],3)
printHtmlPart(14)
i++
}
}
printHtmlPart(15)
invokeTag('paginate','g',44,['total':(tipoMidiaInstanceCount ?: 0)],-1)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',47,[:],1)
printHtmlPart(17)
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
