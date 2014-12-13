import fotolog.Mensagem
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_mensagemshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mensagem/show.gsp" }
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
invokeTag('message','g',8,['code':("mesagem.show.label")],-1)
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
invokeTag('message','g',14,['code':("mesagem.show.label")],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (mensagemInstance?.foto)) {
printHtmlPart(10)
invokeTag('message','g',22,['code':("mensagem.foto.label"),'default':("Foto")],-1)
printHtmlPart(11)
createTagBody(3, {->
invokeTag('image','asset',24,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':(mensagemInstance?.foto?.imagem),'title':(mensagemInstance?.foto?.legenda)],-1)
})
invokeTag('link','g',24,['controller':("foto"),'action':("show"),'id':(mensagemInstance?.foto?.id)],3)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (mensagemInstance?.remetente)) {
printHtmlPart(14)
invokeTag('message','g',31,['code':("mensagem.remetente.label"),'default':("Remetente")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',33,['bean':(mensagemInstance),'field':("remetente")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (mensagemInstance?.emailremetente)) {
printHtmlPart(14)
invokeTag('message','g',40,['code':("mensagem.emailremetente.label"),'default':("Remetente")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',42,['bean':(mensagemInstance),'field':("emailremetente")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (mensagemInstance?.mensagem)) {
printHtmlPart(14)
invokeTag('message','g',49,['code':("mensagem.mensagem.label"),'default':("Descricao")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',51,['bean':(mensagemInstance),'field':("mensagem")],-1)
printHtmlPart(12)
}
printHtmlPart(16)
if(true && (mensagemInstance?.autorizada)) {
printHtmlPart(17)
invokeTag('message','g',58,['code':("mensagem.autorizada.label")],-1)
printHtmlPart(18)
invokeTag('formatBoolean','g',60,['boolean':(mensagemInstance?.autorizada)],-1)
printHtmlPart(12)
}
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',68,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',68,['class':("edit"),'action':("edit"),'resource':(mensagemInstance)],3)
printHtmlPart(21)
invokeTag('actionSubmit','g',69,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(22)
})
invokeTag('form','g',71,['url':([resource:mensagemInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',73,[:],1)
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
