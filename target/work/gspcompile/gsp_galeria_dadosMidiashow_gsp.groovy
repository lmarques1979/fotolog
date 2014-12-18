import fotolog.DadosMidia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_dadosMidiashow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dadosMidia/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'dadosMidia.label', default: 'DadosMidia'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (dadosMidiaInstance?.altura)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("dadosMidia.altura.label"),'default':("Altura")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(dadosMidiaInstance),'field':("altura")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (dadosMidiaInstance?.largura)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("dadosMidia.largura.label"),'default':("Largura")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(dadosMidiaInstance),'field':("largura")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (dadosMidiaInstance?.dateCreated)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("dadosMidia.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(21)
invokeTag('formatDate','g',48,['date':(dadosMidiaInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (dadosMidiaInstance?.lastUpdated)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("dadosMidia.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',57,['date':(dadosMidiaInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (dadosMidiaInstance?.midia)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("dadosMidia.midia.label"),'default':("Midia")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(dadosMidiaInstance?.midia?.encodeAsHTML())
})
invokeTag('link','g',66,['controller':("midia"),'action':("show"),'id':(dadosMidiaInstance?.midia?.id)],3)
printHtmlPart(16)
}
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createTagBody(3, {->
invokeTag('message','g',74,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',74,['class':("edit"),'action':("edit"),'resource':(dadosMidiaInstance)],3)
printHtmlPart(28)
invokeTag('actionSubmit','g',75,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(29)
})
invokeTag('form','g',77,['url':([resource:dadosMidiaInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418740084000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
