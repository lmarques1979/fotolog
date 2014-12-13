import fotolog.Mensagem
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_mensagemmoderar_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mensagem/moderar.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'mensagem.label', default: 'Mensagem'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("mensagem.list.label")],-1)
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
invokeTag('message','g',14,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('message','g',22,['code':("mensagem.foto.label"),'default':("Foto")],-1)
printHtmlPart(10)
invokeTag('message','g',24,['code':("mensagem.remetente.label"),'default':("Remetente")],-1)
printHtmlPart(10)
invokeTag('message','g',26,['code':("mensagem.emailremetente.label"),'default':("Foto")],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("mensagem"),'title':(message(code: 'mensagem.mensagem.label', default: 'Descricao'))],-1)
printHtmlPart(12)
invokeTag('message','g',33,['code':("mensagem.autorizada.label"),'default':("Autorizada")],-1)
printHtmlPart(13)
loop:{
int i = 0
for( mensagemInstance in (mensagemInstanceList) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
if(true && (mensagemInstance?.foto?.imagem)) {
printHtmlPart(17)
invokeTag('image','asset',43,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':(mensagemInstance?.foto?.imagem),'title':(mensagemInstance?.foto?.legenda ? mensagemInstance?.foto?.legenda : ' ')],-1)
printHtmlPart(16)
}
else {
printHtmlPart(17)
invokeTag('image','asset',46,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':("noimage.jpg"),'title':("")],-1)
printHtmlPart(16)
}
printHtmlPart(18)
})
invokeTag('link','g',48,['action':("edit"),'id':(mensagemInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: mensagemInstance, field: "remetente"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: mensagemInstance, field: "emailremetente"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: mensagemInstance, field: "mensagem"))
printHtmlPart(20)
invokeTag('formatBoolean','g',56,['boolean':(mensagemInstance?.autorizada)],-1)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',63,['total':(mensagemInstanceCount ?: 0)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',66,[:],1)
printHtmlPart(24)
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
