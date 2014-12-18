package fotolog

import java.util.Date;

import org.codehaus.groovy.grails.web.context.ServletContextHolder

class Midia {
	
	String  midia
	String  extensao
	Evento  evento
	String  legenda
	String  url
	String	altura
	String 	largura
	Date    dateCreated
	Date    lastUpdated
	
	
	static hasMany = [mensagens:Mensagem]
	
	static constraints = {
		midia(nullable:true , blank:true)
		evento(nullable:false)
		legenda(nullable:true , blank:true)
		altura(nullable:true , blank:true)
		largura(nullable:true , blank:true) 
		url(nullable:true , blank:true) 
		extensao(nullable:true , blank:true)
		
	}
	
	static mapping = {
		mensagens cascade: 'all-delete-orphan'
		autoTimestamp true
	}
}
