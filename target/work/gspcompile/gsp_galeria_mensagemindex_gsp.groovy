import fotolog.Mensagem
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_mensagemindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mensagem/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'mensagem.label', default: 'Mensagem'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("mensagem.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
invokeTag('message','g',13,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('message','g',21,['code':("mensagem.foto.label"),'default':("Foto")],-1)
printHtmlPart(9)
invokeTag('message','g',23,['code':("mensagem.remetente.label"),'default':("Remetente")],-1)
printHtmlPart(9)
invokeTag('message','g',25,['code':("mensagem.emailremetente.label"),'default':("Foto")],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',27,['property':("mensagem"),'title':(message(code: 'mensagem.mensagem.label', default: 'Descricao'))],-1)
printHtmlPart(11)
invokeTag('message','g',32,['code':("mensagem.autorizada.label"),'default':("Autorizada")],-1)
printHtmlPart(12)
loop:{
int i = 0
for( mensagemInstance in (mensagemInstanceList) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
if(true && (mensagemInstance?.midia?.midia)) {
printHtmlPart(16)
invokeTag('image','asset',42,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':(mensagemInstance?.midia?.midia),'title':(mensagemInstance?.midia?.legenda ? mensagemInstance?.midia?.legenda  : ' ')],-1)
printHtmlPart(15)
}
else {
printHtmlPart(16)
invokeTag('image','asset',45,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':("noimage.jpg"),'title':("")],-1)
printHtmlPart(15)
}
printHtmlPart(17)
})
invokeTag('link','g',47,['action':("show"),'id':(mensagemInstance.id)],3)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: mensagemInstance, field: "remetente"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: mensagemInstance, field: "emailremetente"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: mensagemInstance, field: "mensagem"))
printHtmlPart(19)
invokeTag('formatBoolean','g',55,['boolean':(mensagemInstance?.autorizada)],-1)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',62,['total':(mensagemInstanceCount ?: 0)],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(23)
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
