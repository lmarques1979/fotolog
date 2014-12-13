import fotolog.Evento
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_eventoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/evento/show.gsp" }
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
invokeTag('message','g',8,['code':("evento.show.label")],-1)
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
invokeTag('message','g',14,['code':("evento.list.label")],-1)
})
invokeTag('link','g',14,['class':("lista"),'action':("index")],2)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',15,['code':("evento.new.label")],-1)
})
invokeTag('link','g',15,['class':("novo"),'action':("create")],2)
printHtmlPart(7)
invokeTag('message','g',19,['code':("evento.show.label")],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (eventoInstance?.nome)) {
printHtmlPart(12)
invokeTag('message','g',27,['code':("evento.nome.label"),'default':("Nome")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',29,['bean':(eventoInstance),'field':("nome")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (eventoInstance?.descricao)) {
printHtmlPart(16)
invokeTag('message','g',36,['code':("evento.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',38,['bean':(eventoInstance),'field':("descricao")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (eventoInstance?.data)) {
printHtmlPart(18)
invokeTag('message','g',45,['code':("evento.data.label"),'default':("Data")],-1)
printHtmlPart(19)
invokeTag('formatDate','g',47,['format':("dd/MM/yyyy"),'date':(eventoInstance?.data)],-1)
printHtmlPart(14)
}
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
invokeTag('message','g',56,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',56,['class':("edit"),'action':("edit"),'resource':(eventoInstance)],3)
printHtmlPart(22)
invokeTag('actionSubmit','g',57,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(23)
})
invokeTag('form','g',59,['url':([resource:eventoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',62,[:],1)
printHtmlPart(25)
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
