package fotolog

import java.util.Date;

class Midia {
	
	String midia
	Evento evento
	String legenda
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [mensagens:Mensagem]
	static hasOne = [dadosmidia:DadosMidia]
	
	
    static constraints = {
		midia(nullable:false,blank:false)
		evento(nullable:false)
		legenda(nullable:true) 
		dadosmidia(nullable:true)
	}
	
	static mapping = {
		mensagens cascade: 'all-delete-orphan'
		dadosmidia cascade: 'all-delete-orphan'
		autoTimestamp true
	}
}
