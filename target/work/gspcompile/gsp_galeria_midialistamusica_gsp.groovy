import fotolog.Midia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_midialistamusica_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/midia/listamusica.gsp" }
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
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
invokeTag('message','g',18,['code':("galeriamusica.label")],-1)
printHtmlPart(8)
invokeTag('select','g',18,['onchange':("this.form.submit()"),'noSelection':(['0':'Selecione um evento...']),'value':(filtromusica),'name':("filtromusica"),'optionValue':("nome"),'optionKey':("id"),'from':(fotolog.Evento.findAll("from Evento e where e.tipomidia.id=3"))],-1)
printHtmlPart(6)
})
invokeTag('form','g',19,['controller':("midia"),'action':("listamusica")],3)
printHtmlPart(9)
})
invokeTag('ifNotLoggedIn','sec',20,[:],2)
printHtmlPart(10)
if(true && (eventoInstance)) {
printHtmlPart(11)
expressionOut.print(eventoInstance.nome)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (midiaInstanceCount>0)) {
printHtmlPart(14)
loop:{
int i = 0
for( midiaInstance in (midiaInstanceList) ) {
printHtmlPart(15)
expressionOut.print(midiaInstance?.legenda)
printHtmlPart(16)
expressionOut.print(diretorio + File.separator + midiaInstance.evento.nome + File.separator + midiaInstance?.midia+'.'+midiaInstance?.extensao)
printHtmlPart(17)
expressionOut.print(message(code: 'midia.dowbrowsernotsupoortaudio.label'))
printHtmlPart(18)
createTagBody(4, {->
printHtmlPart(19)
invokeTag('image','asset',44,['src':("download.png"),'title':(message(code: 'midia.download.label', default: 'Download'))],-1)
printHtmlPart(20)
})
invokeTag('link','g',45,['url':(diretorio + File.separator + midiaInstance.evento.nome + File.separator + midiaInstance?.midia+'.'+midiaInstance?.extensao)],4)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
}
printHtmlPart(23)
invokeTag('paginate','g',54,['total':(midiaInstanceCount ? midiaInstanceCount : 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418930894000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
