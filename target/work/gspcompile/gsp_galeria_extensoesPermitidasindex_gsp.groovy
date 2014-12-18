import fotolog.ExtensoesPermitidas
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_extensoesPermitidasindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/extensoesPermitidas/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'extensoesPermitidas.label', default: 'ExtensoesPermitidas'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("extensao.list.label")],-1)
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
invokeTag('message','g',14,['code':("extensao.create.label")],-1)
})
invokeTag('link','g',14,['class':("novo"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("extensao.list.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('sortableColumn','g',26,['property':("extensao"),'title':(message(code: 'extensoesPermitidas.extensao.label', default: 'Extensao'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("descricao"),'title':(message(code: 'extensoesPermitidas.descricao.label', default: 'Descricao'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',30,['property':("tamanhomaximo"),'title':(message(code: 'extensoesPermitidas.tamanhomaximo.label', default: 'Tamanhomaximo'))],-1)
printHtmlPart(12)
invokeTag('message','g',32,['code':("extensoesPermitidas.tipomidia.label"),'default':("Tipomidia")],-1)
printHtmlPart(13)
loop:{
int i = 0
for( extensoesPermitidasInstance in (extensoesPermitidasInstanceList) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: extensoesPermitidasInstance, field: "extensao"))
})
invokeTag('link','g',40,['action':("show"),'id':(extensoesPermitidasInstance.id)],3)
printHtmlPart(16)
expressionOut.print(fieldValue(bean: extensoesPermitidasInstance, field: "descricao"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: extensoesPermitidasInstance, field: "tamanhomaximo"))
printHtmlPart(16)
expressionOut.print(extensoesPermitidasInstance?.tipomidia?.descricao)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
invokeTag('paginate','g',55,['total':(extensoesPermitidasInstanceCount ?: 0)],-1)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',58,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418747187000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
