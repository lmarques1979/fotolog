import fotolog.Midia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_midiaindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/midia/index.gsp" }
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
invokeTag('message','g',13,['code':("midia.create.label")],-1)
})
invokeTag('link','g',13,['class':("novo"),'action':("create")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('select','g',16,['onchange':("this.form.submit()"),'noSelection':(['0':'Todos...']),'value':(filtroevento),'name':("filtroevento"),'optionValue':({it.tipomidia.descricao + ' - ' + it.nome}),'optionKey':("id"),'from':(fotolog.Evento.list())],-1)
printHtmlPart(8)
})
invokeTag('form','g',17,['controller':("midia"),'action':("index")],2)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(message(code: 'midia.midia.label', default: 'Nome'))
printHtmlPart(13)
expressionOut.print(message(code: 'midia.url.label', default: 'Nome'))
printHtmlPart(13)
expressionOut.print(message(code: 'midia.evento.label', default: 'Nome'))
printHtmlPart(13)
expressionOut.print(message(code: 'midia.legenda.label', default: 'Nome'))
printHtmlPart(13)
expressionOut.print(message(code: 'midia.tipomidia.label', default: 'Nome'))
printHtmlPart(13)
expressionOut.print(message(code: 'midia.largura.label', default: 'Nome'))
printHtmlPart(13)
expressionOut.print(message(code: 'midia.altura.label', default: 'Nome'))
printHtmlPart(14)
loop:{
int i = 0
for( midiaInstance in (midiaInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
if(true && (midiaInstance?.evento?.tipomidia?.id==1)) {
printHtmlPart(18)
invokeTag('image','asset',47,['src':(midiaInstance?.midia +'.'+midiaInstance?.extensao),'title':(midiaInstance.legenda ? midiaInstance.legenda : '')],-1)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (midiaInstance?.evento?.tipomidia?.id==2 || midiaInstance?.evento?.tipomidia?.id==3)) {
printHtmlPart(18)
invokeTag('image','asset',50,['src':("editar.png"),'title':(midiaInstance.legenda ? midiaInstance.legenda : '')],-1)
printHtmlPart(17)
}
printHtmlPart(19)
})
invokeTag('link','g',53,['action':("show"),'id':(midiaInstance.id)],3)
printHtmlPart(20)
expressionOut.print(midiaInstance?.url)
printHtmlPart(21)
expressionOut.print(midiaInstance?.evento?.nome)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: midiaInstance, field: "legenda"))
printHtmlPart(22)
expressionOut.print(midiaInstance?.evento?.tipomidia?.descricao)
printHtmlPart(21)
expressionOut.print(midiaInstance?.largura ? midiaInstance?.largura : '')
printHtmlPart(21)
expressionOut.print(midiaInstance?.altura ? midiaInstance?.altura : '')
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',73,['total':(midiaInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418927237000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
