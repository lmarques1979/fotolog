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
printHtmlPart(7)
invokeTag('layoutHead','g',18,[:],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(1)
printHtmlPart(9)
invokeTag('image','asset',25,['src':("logofoto.png"),'alt':("Luiz Marques Fotolog"),'title':("Luiz Marques Fotolog")],-1)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
createTagBody(3, {->
invokeTag('image','asset',27,['src':("logout.png")],-1)
})
invokeTag('link','g',27,['class':("login"),'controller':("logout"),'action':("index"),'title':("Sair")],3)
printHtmlPart(12)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(13)
createTagBody(4, {->
invokeTag('message','g',31,['code':("evento.label")],-1)
})
invokeTag('link','g',31,['class':("eventos"),'controller':("Evento"),'action':("index")],4)
printHtmlPart(14)
createTagBody(4, {->
invokeTag('message','g',32,['code':("midia.label")],-1)
})
invokeTag('link','g',32,['class':("midia"),'controller':("Midia"),'action':("index")],4)
printHtmlPart(14)
createTagBody(4, {->
invokeTag('message','g',33,['code':("extensoes.label")],-1)
})
invokeTag('link','g',33,['class':("extensoes"),'controller':("ExtensoesPermitidas"),'action':("index")],4)
printHtmlPart(14)
createTagBody(4, {->
invokeTag('message','g',34,['code':("mensagemmoderar.label")],-1)
})
invokeTag('link','g',34,['class':("moderar"),'controller':("Mensagem"),'action':("moderar")],4)
printHtmlPart(14)
createTagBody(4, {->
invokeTag('message','g',35,['code':("mensagens.label")],-1)
})
invokeTag('link','g',35,['class':("mensagem"),'controller':("Mensagem"),'action':("index")],4)
printHtmlPart(14)
createTagBody(4, {->
invokeTag('message','g',36,['code':("configuracao.label")],-1)
})
invokeTag('link','g',36,['class':("configuracoes"),'controller':("Configuracao"),'action':("index")],4)
printHtmlPart(15)
}
printHtmlPart(10)
})
invokeTag('ifLoggedIn','sec',40,[:],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
createTagBody(3, {->
invokeTag('image','asset',42,['src':("admin.png")],-1)
})
invokeTag('link','g',42,['class':("login"),'controller':("login"),'action':("auth")],3)
printHtmlPart(10)
})
invokeTag('ifNotLoggedIn','sec',43,[:],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
createTagBody(3, {->
invokeTag('message','g',50,['code':("imagem.label")],-1)
})
invokeTag('link','g',50,['class':("imagem"),'controller':("midia"),'action':("listaporevento")],3)
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',51,['code':("video.label")],-1)
})
invokeTag('link','g',51,['class':("video"),'controller':("midia"),'action':("listavideo")],3)
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',52,['code':("musica.label")],-1)
})
invokeTag('link','g',52,['class':("musica"),'controller':("midia"),'action':("listamusica")],3)
printHtmlPart(19)
})
invokeTag('ifNotLoggedIn','sec',56,[:],2)
printHtmlPart(20)
invokeTag('layoutBody','g',60,[:],-1)
printHtmlPart(21)
invokeTag('message','g',66,['code':("titulopagina.label")],-1)
printHtmlPart(22)
invokeTag('message','g',68,['code':("copyrigth.label")],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',73,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418746406000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
