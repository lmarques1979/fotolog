import fotolog.Evento
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',10,['default':("Fotolog")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(3)
expressionOut.print(assetPath(src: 'favicon.ico'))
printHtmlPart(4)
expressionOut.print(assetPath(src: 'apple-touch-icon.png'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'apple-touch-icon-retina.png'))
printHtmlPart(6)
invokeTag('stylesheet','asset',15,['src':("application.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',16,['src':("application.js")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',17,[:],-1)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(1)
printHtmlPart(8)
invokeTag('image','asset',24,['src':("logofoto.png"),'alt':("Luiz Marques Fotolog"),'title':("Luiz Marques Fotolog")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
invokeTag('image','asset',26,['src':("logout.png")],-1)
})
invokeTag('link','g',26,['class':("login"),'controller':("logout"),'action':("index"),'title':("Sair")],3)
printHtmlPart(10)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',30,['code':("evento.label")],-1)
})
invokeTag('link','g',30,['class':("eventos"),'controller':("Evento"),'action':("index")],4)
printHtmlPart(12)
createTagBody(4, {->
invokeTag('message','g',31,['code':("tipomidia.label")],-1)
})
invokeTag('link','g',31,['class':("tipomidia"),'controller':("TipoMidia"),'action':("index")],4)
printHtmlPart(13)
createTagBody(4, {->
invokeTag('message','g',32,['code':("midia.label")],-1)
})
invokeTag('link','g',32,['class':("midia"),'controller':("Midia"),'action':("index")],4)
printHtmlPart(14)
createTagBody(4, {->
invokeTag('message','g',33,['code':("mensagemmoderar.label")],-1)
})
invokeTag('link','g',33,['class':("moderar"),'controller':("Mensagem"),'action':("moderar")],4)
printHtmlPart(14)
createTagBody(4, {->
invokeTag('message','g',34,['code':("mensagens.label")],-1)
})
invokeTag('link','g',34,['class':("mensagem"),'controller':("Mensagem"),'action':("index")],4)
printHtmlPart(14)
createTagBody(4, {->
invokeTag('message','g',35,['code':("configuracao.label")],-1)
})
invokeTag('link','g',35,['class':("configuracoes"),'controller':("Configuracao"),'action':("index")],4)
printHtmlPart(15)
}
printHtmlPart(9)
})
invokeTag('ifLoggedIn','sec',39,[:],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
invokeTag('image','asset',41,['src':("admin.png")],-1)
})
invokeTag('link','g',41,['class':("login"),'controller':("login"),'action':("auth")],3)
printHtmlPart(9)
})
invokeTag('ifNotLoggedIn','sec',42,[:],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('message','g',48,['code':("eventoscadastrados.label")],-1)
printHtmlPart(18)
invokeTag('select','g',48,['onchange':("this.form.submit()"),'noSelection':(['0':'Selecione um evento...']),'value':(filtroevento),'name':("filtroevento"),'optionValue':({formatDate(format: 'dd/MM/yyyy', date: it.data) + ' - ' + it.nome}),'optionKey':("id"),'from':(fotolog.Evento.list())],-1)
printHtmlPart(10)
})
invokeTag('form','g',49,['controller':("midia"),'action':("listaporevento")],3)
printHtmlPart(9)
})
invokeTag('ifNotLoggedIn','sec',50,[:],2)
printHtmlPart(9)
createClosureForHtmlPart(19, 2)
invokeTag('ifLoggedIn','sec',53,[:],2)
printHtmlPart(20)
invokeTag('layoutBody','g',58,[:],-1)
printHtmlPart(21)
invokeTag('message','g',64,['code':("titulopagina.label")],-1)
printHtmlPart(22)
invokeTag('message','g',66,['code':("copyrigth.label")],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418467941000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
