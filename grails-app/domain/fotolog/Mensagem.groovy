package fotolog

import java.util.Date;

class Mensagem {
	
	String 	mensagem
	Midia 	midia
	String 	remetente
	String  emailremetente
	boolean autorizada
	Date 	dateCreated
	Date 	lastUpdated 
	
	
   static constraints = {
		mensagem(blank:false)
		midia(nullable:false,blank:false)
		remetente(blank:false)
		emailremetente(email:true, blank:false)
		autorizada(nullable:true,blank:true)
    }
	
	static mapping = {
		autoTimestamp true
	}
}
