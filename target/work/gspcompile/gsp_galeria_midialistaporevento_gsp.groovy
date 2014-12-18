import fotolog.Midia
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_galeria_midialistaporevento_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/midia/listaporevento.gsp" }
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
invokeTag('message','g',13,['code':("midia.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',16,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
invokeTag('message','g',23,['code':("eventoscadastrados.label")],-1)
printHtmlPart(8)
invokeTag('select','g',23,['onchange':("this.form.submit()"),'noSelection':(['0':'Selecione um evento...']),'value':(filtroevento),'name':("filtroevento"),'optionValue':({formatDate(format: 'dd/MM/yyyy', date: it.data) + ' - ' + it.nome}),'optionKey':("id"),'from':(fotolog.Evento.findAll("from Evento e where e.tipomidia.id=1"))],-1)
printHtmlPart(6)
})
invokeTag('form','g',24,['controller':("midia"),'action':("listaporevento")],3)
printHtmlPart(9)
})
invokeTag('ifNotLoggedIn','sec',25,[:],2)
printHtmlPart(10)
if(true && (eventoInstance)) {
printHtmlPart(11)
expressionOut.print(eventoInstance.nome)
printHtmlPart(12)
expressionOut.print(midiaInstanceCount)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (midiaInstanceCount>0)) {
printHtmlPart(15)
loop:{
int i = 0
for( midiaInstance in (midiaInstanceList) ) {
printHtmlPart(16)
invokeTag('image','asset',54,['class':("fotogrande"),'data-fotoid':(midiaInstance?.id),'data-legenda':(midiaInstance?.legenda),'u':("image"),'src':(midiaInstance?.midia+'.'+midiaInstance?.extensao)],-1)
printHtmlPart(17)
invokeTag('image','asset',55,['u':("thumb"),'src':(midiaInstance?.midia+'.'+midiaInstance?.extensao)],-1)
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('image','asset',88,['u':("thumb"),'id':("playButton"),'src':("play.png"),'title':(message(code: 'playslide.label'))],-1)
printHtmlPart(20)
invokeTag('image','asset',89,['u':("thumb"),'id':("pauseButton"),'src':("pause.png"),'title':(message(code: 'pauseslide.label'))],-1)
printHtmlPart(21)
invokeTag('image','asset',92,['class':("enviarmensagem"),'src':("enviarmensagem.png"),'title':(message(code: 'mensagem.enviar.label'))],-1)
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('hiddenField','g',99,['class':("fotoid"),'name':("midia.id"),'value':("")],-1)
printHtmlPart(23)
expressionOut.print(message(code: 'mensagem.enviomensagemth.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'mensagem.remetente.label'))
printHtmlPart(25)
invokeTag('textField','g',109,['name':("remetente"),'required':(""),'value':(mensagemInstance?.remetente)],-1)
printHtmlPart(26)
expressionOut.print(message(code: 'mensagem.emailremetente.label'))
printHtmlPart(25)
invokeTag('textField','g',113,['name':("emailremetente"),'required':(""),'value':("")],-1)
printHtmlPart(27)
expressionOut.print(message(code: 'mensagem.mensagem.label'))
printHtmlPart(25)
invokeTag('textArea','g',117,['required':(""),'name':("mensagem"),'rows':("5"),'cols':("20")],-1)
printHtmlPart(28)
invokeTag('submitButton','g',123,['name':("create"),'class':("save"),'value':(message(code: 'default.button.enviar.label', default: 'Create'))],-1)
printHtmlPart(29)
})
invokeTag('form','g',129,['class':("enviomsg"),'controller':("mensagem"),'action':("enviamensagem")],3)
printHtmlPart(30)
}
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',140,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418931227000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
