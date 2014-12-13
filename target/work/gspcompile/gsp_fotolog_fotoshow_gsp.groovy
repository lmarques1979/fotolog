import fotolog.Foto
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_fotoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/foto/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'foto.label', default: 'Foto'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("foto.show.label")],-1)
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
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',15,['code':("foto.list.label")],-1)
})
invokeTag('link','g',15,['class':("lista"),'action':("index")],2)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',16,['code':("foto.create.label")],-1)
})
invokeTag('link','g',16,['class':("novo"),'action':("create")],2)
printHtmlPart(7)
invokeTag('message','g',20,['code':("foto.show.label")],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fotoInstance?.imagem)) {
printHtmlPart(12)
invokeTag('message','g',28,['code':("foto.imagem.label"),'default':("Nome")],-1)
printHtmlPart(13)
if(true && (fotoInstance.imagem)) {
printHtmlPart(14)
invokeTag('image','asset',32,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':(fotoInstance.imagem),'title':(fotoInstance.legenda)],-1)
printHtmlPart(15)
}
else {
printHtmlPart(16)
invokeTag('image','asset',35,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':("noimage.jpg"),'title':(usuarioInstance.username)],-1)
printHtmlPart(15)
}
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (fotoInstance?.evento)) {
printHtmlPart(19)
invokeTag('message','g',45,['code':("foto.evento.label"),'default':("Evento")],-1)
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(fotoInstance?.evento?.nome)
})
invokeTag('link','g',47,['controller':("evento"),'action':("show"),'id':(fotoInstance?.evento?.id)],3)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (fotoInstance?.legenda)) {
printHtmlPart(19)
invokeTag('message','g',54,['code':("foto.legenda.label"),'default':("Evento")],-1)
printHtmlPart(20)
expressionOut.print(fotoInstance?.legenda)
printHtmlPart(21)
}
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',66,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',66,['class':("edit"),'action':("edit"),'resource':(fotoInstance)],3)
printHtmlPart(25)
invokeTag('actionSubmit','g',67,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(26)
})
invokeTag('form','g',69,['url':([resource:fotoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(28)
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
