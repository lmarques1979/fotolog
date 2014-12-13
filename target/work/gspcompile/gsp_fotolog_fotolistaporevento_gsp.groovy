import fotolog.Foto
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_fotolistaporevento_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/foto/listaporevento.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'foto.label', default: 'Foto'))],-1)
printHtmlPart(1)
invokeTag('javascript','asset',7,['src':("tratamensagem.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',8,['src':("jssor.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',9,['src':("jssor.slider.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',10,['src':("slider_init.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',11,['src':("enviomensagem.js")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',12,['src':("slider.css")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',13,['code':("foto.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',16,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
if(true && (eventoInstance)) {
printHtmlPart(5)
expressionOut.print(eventoInstance.nome)
printHtmlPart(6)
expressionOut.print(fotoInstanceCount)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (fotoInstanceCount>0)) {
printHtmlPart(9)
loop:{
int i = 0
for( fotoInstance in (fotoInstanceList) ) {
printHtmlPart(10)
invokeTag('image','asset',47,['class':("fotogrande"),'data-fotoid':(fotoInstance?.id),'data-legenda':(fotoInstance?.legenda),'u':("image"),'src':(fotoInstance?.imagem)],-1)
printHtmlPart(11)
invokeTag('image','asset',48,['u':("thumb"),'src':(fotoInstance?.imagem)],-1)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
invokeTag('image','asset',81,['u':("thumb"),'id':("playButton"),'src':("play.png"),'title':(message(code: 'playslide.label'))],-1)
printHtmlPart(14)
invokeTag('image','asset',82,['u':("thumb"),'id':("pauseButton"),'src':("pause.png"),'title':(message(code: 'pauseslide.label'))],-1)
printHtmlPart(15)
invokeTag('image','asset',85,['class':("enviarmensagem"),'src':("enviarmensagem.png"),'title':(message(code: 'mensagem.enviar.label'))],-1)
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('hiddenField','g',91,['class':("fotoid"),'name':("foto.id"),'value':("")],-1)
printHtmlPart(18)
expressionOut.print(message(code: 'mensagem.enviomensagemth.label'))
printHtmlPart(19)
expressionOut.print(message(code: 'mensagem.remetente.label'))
printHtmlPart(20)
invokeTag('textField','g',101,['name':("remetente"),'required':(""),'value':(mensagemInstance?.remetente)],-1)
printHtmlPart(21)
expressionOut.print(message(code: 'mensagem.emailremetente.label'))
printHtmlPart(20)
invokeTag('textField','g',105,['name':("emailremetente"),'required':(""),'value':("")],-1)
printHtmlPart(22)
expressionOut.print(message(code: 'mensagem.mensagem.label'))
printHtmlPart(20)
invokeTag('textArea','g',109,['required':(""),'name':("mensagem"),'rows':("5"),'cols':("20")],-1)
printHtmlPart(23)
invokeTag('submitButton','g',115,['name':("create"),'class':("save"),'value':(message(code: 'default.button.enviar.label', default: 'Create'))],-1)
printHtmlPart(24)
})
invokeTag('form','g',121,['class':("enviomsg"),'controller':("mensagem"),'action':("enviamensagem")],3)
printHtmlPart(25)
}
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',132,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1417722191000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
