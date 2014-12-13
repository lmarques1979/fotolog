import fotolog.Midia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_midiashow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/midia/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'midia.label', default: 'Foto'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("midia.show.label")],-1)
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
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',14,['code':("midia.list.label")],-1)
})
invokeTag('link','g',14,['class':("lista"),'action':("index")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',15,['code':("midia.create.label")],-1)
})
invokeTag('link','g',15,['class':("novo"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',19,['code':("midia.show.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (midiaInstance?.midia)) {
printHtmlPart(11)
invokeTag('message','g',27,['code':("midia.imagem.label"),'default':("Nome")],-1)
printHtmlPart(12)
if(true && (midiaInstance.midia)) {
printHtmlPart(13)
invokeTag('image','asset',31,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':(midiaInstance.midia),'title':(midiaInstance.legenda)],-1)
printHtmlPart(14)
}
else {
printHtmlPart(15)
invokeTag('image','asset',34,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':("noimage.jpg")],-1)
printHtmlPart(14)
}
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (midiaInstance?.tipomidia)) {
printHtmlPart(18)
invokeTag('message','g',44,['code':("tipomidia.label"),'default':("Evento")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(midiaInstance?.tipomidia?.descricao)
})
invokeTag('link','g',46,['controller':("tipoMidia"),'action':("show"),'id':(midiaInstance?.tipomidia?.id)],3)
printHtmlPart(20)
}
printHtmlPart(17)
if(true && (midiaInstance?.evento)) {
printHtmlPart(18)
invokeTag('message','g',53,['code':("midia.evento.label"),'default':("Evento")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(midiaInstance?.evento?.nome)
})
invokeTag('link','g',55,['controller':("evento"),'action':("show"),'id':(midiaInstance?.evento?.id)],3)
printHtmlPart(20)
}
printHtmlPart(17)
if(true && (midiaInstance?.legenda)) {
printHtmlPart(18)
invokeTag('message','g',62,['code':("midia.legenda.label"),'default':("Evento")],-1)
printHtmlPart(19)
expressionOut.print(midiaInstance?.legenda)
printHtmlPart(20)
}
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',74,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',74,['class':("edit"),'action':("edit"),'resource':(midiaInstance)],3)
printHtmlPart(23)
invokeTag('actionSubmit','g',75,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(24)
})
invokeTag('form','g',77,['url':([resource:midiaInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',79,[:],1)
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
