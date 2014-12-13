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
invokeTag('select','g',23,['onchange':("this.form.submit()"),'noSelection':(['0':'Selecione um evento...']),'value':(filtroevento),'name':("filtroevento"),'optionValue':({formatDate(format: 'dd/MM/yyyy', date: it.data) + ' - ' + it.nome}),'optionKey':("id"),'from':(fotolog.Evento.list())],-1)
printHtmlPart(6)
})
invokeTag('form','g',24,['controller':("midia"),'action':("listaporevento")],3)
printHtmlPart(9)
})
invokeTag('ifNotLoggedIn','sec',25,[:],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('ifLoggedIn','sec',28,[:],2)
printHtmlPart(11)
if(true && (eventoInstance)) {
printHtmlPart(12)
expressionOut.print(eventoInstance.nome)
printHtmlPart(13)
expressionOut.print(midiaInstanceCount)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (midiaInstanceCount>0)) {
printHtmlPart(16)
loop:{
int i = 0
for( midiaInstance in (midiaInstanceList) ) {
printHtmlPart(17)
invokeTag('image','asset',58,['class':("fotogrande"),'data-fotoid':(midiaInstance?.id),'data-legenda':(midiaInstance?.legenda),'u':("image"),'src':(midiaInstance?.midia)],-1)
printHtmlPart(18)
invokeTag('image','asset',59,['u':("thumb"),'src':(midiaInstance?.midia)],-1)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('image','asset',92,['u':("thumb"),'id':("playButton"),'src':("play.png"),'title':(message(code: 'playslide.label'))],-1)
printHtmlPart(21)
invokeTag('image','asset',93,['u':("thumb"),'id':("pauseButton"),'src':("pause.png"),'title':(message(code: 'pauseslide.label'))],-1)
printHtmlPart(22)
invokeTag('image','asset',96,['class':("enviarmensagem"),'src':("enviarmensagem.png"),'title':(message(code: 'mensagem.enviar.label'))],-1)
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('hiddenField','g',103,['class':("fotoid"),'name':("midia.id"),'value':("")],-1)
printHtmlPart(25)
expressionOut.print(message(code: 'mensagem.enviomensagemth.label'))
printHtmlPart(26)
expressionOut.print(message(code: 'mensagem.remetente.label'))
printHtmlPart(27)
invokeTag('textField','g',113,['name':("remetente"),'required':(""),'value':(mensagemInstance?.remetente)],-1)
printHtmlPart(28)
expressionOut.print(message(code: 'mensagem.emailremetente.label'))
printHtmlPart(27)
invokeTag('textField','g',117,['name':("emailremetente"),'required':(""),'value':("")],-1)
printHtmlPart(29)
expressionOut.print(message(code: 'mensagem.mensagem.label'))
printHtmlPart(27)
invokeTag('textArea','g',121,['required':(""),'name':("mensagem"),'rows':("5"),'cols':("20")],-1)
printHtmlPart(30)
invokeTag('submitButton','g',127,['name':("create"),'class':("save"),'value':(message(code: 'default.button.enviar.label', default: 'Create'))],-1)
printHtmlPart(31)
})
invokeTag('form','g',133,['class':("enviomsg"),'controller':("mensagem"),'action':("enviamensagem")],3)
printHtmlPart(32)
}
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',144,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418469795000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
