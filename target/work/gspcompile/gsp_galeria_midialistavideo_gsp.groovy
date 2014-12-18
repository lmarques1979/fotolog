import fotolog.Midia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_midialistavideo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/midia/listavideo.gsp" }
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
invokeTag('message','g',7,['code':("midia.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
invokeTag('message','g',17,['code':("galeriavideos.label")],-1)
printHtmlPart(8)
invokeTag('select','g',17,['onchange':("this.form.submit()"),'noSelection':(['0':'Selecione um evento...']),'value':(filtrovideo),'name':("filtrovideo"),'optionValue':("nome"),'optionKey':("id"),'from':(fotolog.Evento.findAll("from Evento e where e.tipomidia.id=2"))],-1)
printHtmlPart(6)
})
invokeTag('form','g',18,['controller':("midia"),'action':("listavideo")],3)
printHtmlPart(9)
})
invokeTag('ifNotLoggedIn','sec',19,[:],2)
printHtmlPart(10)
loop:{
int i = 0
for( midiaInstance in (midiaInstanceList) ) {
printHtmlPart(9)
if(true && (midiaInstance?.midia)) {
printHtmlPart(11)
expressionOut.print(midiaInstance?.largura ? midiaInstance?.largura + 'px;' : '560px;')
printHtmlPart(12)
expressionOut.print(midiaInstance?.legenda)
printHtmlPart(13)
expressionOut.print(midiaInstance?.altura ? midiaInstance?.altura : '315')
printHtmlPart(14)
expressionOut.print(midiaInstance?.largura ? midiaInstance?.largura : '560')
printHtmlPart(15)
expressionOut.print(diretorio + midiaInstance?.evento?.nome + File.separator + midiaInstance?.midia+'.'+midiaInstance?.extensao)
printHtmlPart(16)
expressionOut.print(message(code: 'midia.dowbrowsernotsupoortaudio.label'))
printHtmlPart(17)
}
else {
printHtmlPart(18)
expressionOut.print(midiaInstance?.largura ? midiaInstance?.largura + 'px;' : '560px;')
printHtmlPart(19)
expressionOut.print(midiaInstance?.largura ? midiaInstance?.largura : '560')
printHtmlPart(20)
expressionOut.print(midiaInstance?.altura ? midiaInstance?.altura : '315')
printHtmlPart(21)
expressionOut.print(midiaInstance?.url)
printHtmlPart(22)
}
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',45,['total':(midiaInstanceCount ? midiaInstanceCount : 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',48,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418934711000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
