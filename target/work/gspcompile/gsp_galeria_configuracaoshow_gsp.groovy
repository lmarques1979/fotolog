import fotolog.Configuracao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_configuracaoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/configuracao/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'configuracao.label', default: 'Configuracao'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("configuracao.show.label")],-1)
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
invokeTag('message','g',14,['code':("configuracao.list.label")],-1)
})
invokeTag('link','g',14,['class':("lista"),'action':("index")],2)
printHtmlPart(6)
invokeTag('message','g',19,['code':("configuracao.show.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (configuracaoInstance?.alturaimagens)) {
printHtmlPart(11)
invokeTag('message','g',27,['code':("configuracao.alturaimagens.label"),'default':("Alturaimagens")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',29,['bean':(configuracaoInstance),'field':("alturaimagens")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (configuracaoInstance?.larguraimagens)) {
printHtmlPart(15)
invokeTag('message','g',36,['code':("configuracao.larguraimagens.label"),'default':("Larguraimagens")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',38,['bean':(configuracaoInstance),'field':("larguraimagens")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (configuracaoInstance?.alturaimagensthumbs)) {
printHtmlPart(17)
invokeTag('message','g',45,['code':("configuracao.alturaimagensthumbs.label"),'default':("Alturaimagensthumbs")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',47,['bean':(configuracaoInstance),'field':("alturaimagensthumbs")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (configuracaoInstance?.larguraimagensthumbs)) {
printHtmlPart(19)
invokeTag('message','g',54,['code':("configuracao.larguraimagensthumbs.label"),'default':("Larguraimagensthumbs")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',56,['bean':(configuracaoInstance),'field':("larguraimagensthumbs")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (configuracaoInstance?.itensporpagina)) {
printHtmlPart(21)
invokeTag('message','g',63,['code':("configuracao.itensporpagina.label"),'default':("Itensporpagina")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',65,['bean':(configuracaoInstance),'field':("itensporpagina")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (configuracaoInstance?.usuario)) {
printHtmlPart(23)
invokeTag('message','g',72,['code':("configuracao.usuario.label"),'default':("Usuario")],-1)
printHtmlPart(24)
createTagBody(3, {->
expressionOut.print(configuracaoInstance?.usuario?.username)
})
invokeTag('link','g',74,['controller':("usuario"),'action':("show"),'id':(configuracaoInstance?.usuario?.id)],3)
printHtmlPart(13)
}
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',85,['class':("edit"),'action':("edit"),'resource':(configuracaoInstance)],3)
printHtmlPart(27)
invokeTag('actionSubmit','g',86,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(28)
})
invokeTag('form','g',88,['url':([resource:configuracaoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',90,[:],1)
printHtmlPart(30)
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
