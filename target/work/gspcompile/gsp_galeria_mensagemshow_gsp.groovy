import fotolog.Mensagem
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_mensagemshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mensagem/show.gsp" }
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
invokeTag('message','g',7,['code':("mesagem.show.label")],-1)
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
invokeTag('message','g',13,['code':("mesagem.show.label")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (mensagemInstance?.midia)) {
printHtmlPart(9)
invokeTag('message','g',21,['code':("mensagem.foto.label"),'default':("Foto")],-1)
printHtmlPart(10)
createTagBody(3, {->
invokeTag('image','asset',23,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':(mensagemInstance?.midia?.midia),'title':(mensagemInstance?.midia?.legenda)],-1)
})
invokeTag('link','g',23,['controller':("midia"),'action':("show"),'id':(mensagemInstance?.midia?.id)],3)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (mensagemInstance?.remetente)) {
printHtmlPart(13)
invokeTag('message','g',30,['code':("mensagem.remetente.label"),'default':("Remetente")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',32,['bean':(mensagemInstance),'field':("remetente")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (mensagemInstance?.emailremetente)) {
printHtmlPart(13)
invokeTag('message','g',39,['code':("mensagem.emailremetente.label"),'default':("Remetente")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',41,['bean':(mensagemInstance),'field':("emailremetente")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (mensagemInstance?.mensagem)) {
printHtmlPart(13)
invokeTag('message','g',48,['code':("mensagem.mensagem.label"),'default':("Descricao")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',50,['bean':(mensagemInstance),'field':("mensagem")],-1)
printHtmlPart(11)
}
printHtmlPart(15)
if(true && (mensagemInstance?.autorizada)) {
printHtmlPart(16)
invokeTag('message','g',57,['code':("mensagem.autorizada.label")],-1)
printHtmlPart(17)
invokeTag('formatBoolean','g',59,['boolean':(mensagemInstance?.autorizada)],-1)
printHtmlPart(11)
}
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',67,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',67,['class':("edit"),'action':("edit"),'resource':(mensagemInstance)],3)
printHtmlPart(20)
invokeTag('actionSubmit','g',68,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(21)
})
invokeTag('form','g',70,['url':([resource:mensagemInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',72,[:],1)
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
