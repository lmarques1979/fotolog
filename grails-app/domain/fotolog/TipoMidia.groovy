package fotolog

import java.util.Date;

class TipoMidia {
	
	String 	descricao
	Date 	dateCreated
	Date 	lastUpdated
	
	static hasMany = [eventos: Evento , extensoespermitidas: ExtensoesPermitidas]
		
    static constraints = {
		descricao(nullable:false,blank:false) 
		extensoespermitidas(nullable:true,blank:true)
	}
	
	static mapping = {
		autoTimestamp true
	}
}
