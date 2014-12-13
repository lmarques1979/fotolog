package fotolog

import java.util.Date;

class Midia {
	
	String midia
	Evento evento
	TipoMidia tipomidia
	String legenda
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [mensagens:Mensagem]
	
    static constraints = {
		midia(nullable:false,blank:false)
		evento(nullable:false)
		tipomidia(nullable:false)
		legenda(nullable:true)
		
    }
	
	static mapping = {
		mensagens cascade: 'all-delete-orphan'
		autoTimestamp true
	}
}
