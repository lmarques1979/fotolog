import fotolog.Foto
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_fotoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/foto/index.gsp" }
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
invokeTag('message','g',8,['code':("foto.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',14,['code':("foto.create.label")],-1)
})
invokeTag('link','g',14,['class':("novo"),'action':("create")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('select','g',17,['onchange':("this.form.submit()"),'noSelection':(['0':'Todos...']),'value':(filtroevento),'name':("filtroevento"),'optionValue':({formatDate(format: 'dd/MM/yyyy', date: it.data) + ' - ' + it.nome}),'optionKey':("id"),'from':(fotolog.Evento.list())],-1)
printHtmlPart(9)
})
invokeTag('form','g',18,['controller':("foto"),'action':("index")],2)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(message(code: 'foto.imagem.label', default: 'Nome'))
printHtmlPart(14)
expressionOut.print(message(code: 'foto.evento.label', default: 'Nome'))
printHtmlPart(14)
expressionOut.print(message(code: 'foto.legenda.label', default: 'Nome'))
printHtmlPart(15)
loop:{
int i = 0
for( fotoInstance in (fotoInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
if(true && (fotoInstance.imagem)) {
printHtmlPart(19)
invokeTag('image','asset',45,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':(fotoInstance.imagem),'title':(fotoInstance.legenda)],-1)
printHtmlPart(20)
}
else {
printHtmlPart(21)
invokeTag('image','asset',48,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':("noimage.jpg"),'title':(usuarioInstance.username)],-1)
printHtmlPart(20)
}
printHtmlPart(22)
})
invokeTag('link','g',51,['action':("show"),'id':(fotoInstance.id)],3)
printHtmlPart(23)
expressionOut.print(fotoInstance?.evento?.nome)
printHtmlPart(23)
expressionOut.print(fieldValue(bean: fotoInstance, field: "legenda"))
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',63,['total':(fotoInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',66,[:],1)
printHtmlPart(27)
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
