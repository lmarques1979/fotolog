package fotolog

import java.util.Date;

class TipoMidia {
	
	String 	descricao
	Date 	dateCreated
	Date 	lastUpdated
	
	static hasMany = [midias:Midia]	
	
   static constraints = {
		descricao(nullable:false,blank:false)
		
	}
	
	static mapping = {
		autoTimestamp true
	}
}
