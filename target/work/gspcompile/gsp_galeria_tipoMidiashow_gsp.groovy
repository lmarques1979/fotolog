import fotolog.TipoMidia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_tipoMidiashow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tipoMidia/show.gsp" }
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
invokeTag('message','g',8,['code':("tipomidia.show.label")],-1)
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
invokeTag('message','g',14,['code':("tipomidia.list.label")],-1)
})
invokeTag('link','g',14,['class':("lista"),'action':("index")],2)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',15,['code':("tipomidia.new.label")],-1)
})
invokeTag('link','g',15,['class':("novo"),'action':("create")],2)
printHtmlPart(7)
invokeTag('message','g',19,['code':("tipomidia.show.label")],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (tipoMidiaInstance?.descricao)) {
printHtmlPart(12)
invokeTag('message','g',27,['code':("tipoMidia.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',29,['bean':(tipoMidiaInstance),'field':("descricao")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (tipoMidiaInstance?.midias)) {
printHtmlPart(16)
invokeTag('message','g',36,['code':("tipoMidia.midias.label"),'default':("Midias")],-1)
printHtmlPart(17)
for( m in (tipoMidiaInstance.midias) ) {
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("midia"),'action':("show"),'id':(m.id)],4)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',48,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',48,['class':("edit"),'action':("edit"),'resource':(tipoMidiaInstance)],3)
printHtmlPart(23)
invokeTag('actionSubmit','g',49,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(24)
})
invokeTag('form','g',51,['url':([resource:tipoMidiaInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',53,[:],1)
printHtmlPart(26)
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
