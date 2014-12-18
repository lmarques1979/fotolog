import fotolog.ExtensoesPermitidas
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_extensoesPermitidasshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/extensoesPermitidas/show.gsp" }
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
invokeTag('message','g',8,['code':("extensao.show.label")],-1)
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
invokeTag('message','g',14,['code':("extensao.list.label")],-1)
})
invokeTag('link','g',14,['class':("lista"),'action':("index")],2)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',15,['code':("extensao.create.label")],-1)
})
invokeTag('link','g',15,['class':("novo"),'action':("create")],2)
printHtmlPart(7)
invokeTag('message','g',19,['code':("extensao.show.label")],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (extensoesPermitidasInstance?.extensao)) {
printHtmlPart(12)
invokeTag('message','g',27,['code':("extensoesPermitidas.extensao.label"),'default':("Extensao")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',29,['bean':(extensoesPermitidasInstance),'field':("extensao")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (extensoesPermitidasInstance?.descricao)) {
printHtmlPart(16)
invokeTag('message','g',36,['code':("extensoesPermitidas.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',38,['bean':(extensoesPermitidasInstance),'field':("descricao")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (extensoesPermitidasInstance?.tamanhomaximo)) {
printHtmlPart(18)
invokeTag('message','g',45,['code':("extensoesPermitidas.tamanhomaximo.label"),'default':("Tamanhomaximo")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',47,['bean':(extensoesPermitidasInstance),'field':("tamanhomaximo")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (extensoesPermitidasInstance?.tipomidia)) {
printHtmlPart(20)
invokeTag('message','g',54,['code':("extensoesPermitidas.tipomidia.label"),'default':("Tipomidia")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(extensoesPermitidasInstance?.tipomidia?.descricao.encodeAsHTML())
})
invokeTag('link','g',56,['controller':("tipoMidia"),'action':("show"),'id':(extensoesPermitidasInstance?.tipomidia?.id)],3)
printHtmlPart(14)
}
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createTagBody(3, {->
invokeTag('message','g',66,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',66,['class':("edit"),'action':("edit"),'resource':(extensoesPermitidasInstance)],3)
printHtmlPart(24)
invokeTag('actionSubmit','g',67,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(25)
})
invokeTag('form','g',69,['url':([resource:extensoesPermitidasInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418747441000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
