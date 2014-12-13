import fotolog.Configuracao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fotolog_configuracao_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/configuracao/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'alturaimagens', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("configuracao.alturaimagens.label"),'default':("Alturaimagens")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("alturaimagens"),'type':("number"),'value':(configuracaoInstance.alturaimagens),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'larguraimagens', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("configuracao.larguraimagens.label"),'default':("Larguraimagens")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['name':("larguraimagens"),'type':("number"),'value':(configuracaoInstance.larguraimagens),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'alturaimagensthumbs', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("configuracao.alturaimagensthumbs.label"),'default':("Alturaimagensthumbs")],-1)
printHtmlPart(2)
invokeTag('field','g',28,['name':("alturaimagensthumbs"),'type':("number"),'value':(configuracaoInstance.alturaimagensthumbs),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'larguraimagensthumbs', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("configuracao.larguraimagensthumbs.label"),'default':("Larguraimagensthumbs")],-1)
printHtmlPart(2)
invokeTag('field','g',37,['name':("larguraimagensthumbs"),'type':("number"),'value':(configuracaoInstance.larguraimagensthumbs),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'itensporpagina', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("configuracao.itensporpagina.label"),'default':("Itensporpagina")],-1)
printHtmlPart(2)
invokeTag('field','g',46,['name':("itensporpagina"),'type':("number"),'value':(configuracaoInstance.itensporpagina),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'usuario', 'error'))
printHtmlPart(8)
invokeTag('message','g',52,['code':("configuracao.usuario.label"),'default':("Usuario")],-1)
printHtmlPart(2)
invokeTag('select','g',55,['id':("usuario"),'name':("usuario.id"),'from':(seguranca.Usuario.list()),'optionKey':("id"),'optionValue':("username"),'required':(""),'value':(configuracaoInstance?.usuario?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
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
