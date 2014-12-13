import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_mensagemcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mensagem/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
invokeTag('message','g',2,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(1)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("default.home.label")],-1)
printHtmlPart(3)
createTagBody(2, {->
invokeTag('message','g',6,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',6,['class':("list"),'action':("index")],2)
printHtmlPart(4)
invokeTag('message','g',10,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',17,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',18,['bean':(mensagemInstance),'var':("error")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',20,['bean':(mensagemInstance)],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('render','g',23,['template':("form")],-1)
printHtmlPart(17)
invokeTag('submitButton','g',26,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(18)
})
invokeTag('form','g',28,['id':("enviarmensagem"),'url':([resource:mensagemInstance, action:'save'])],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',30,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1416226909000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
