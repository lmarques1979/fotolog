package fotolog

import java.util.Date;

class ExtensoesPermitidas {
	
	String  extensao
	String	descricao
	int		tamanhomaximo
	Date 	dateCreated
	Date 	lastUpdated
	TipoMidia tipomidia 
	
	static constraints = {
		extensao(nullable:false)
		descricao(nullable:true)
		tamanhomaximo(nullable:true)
		tipomidia(nullable:false)
	}
	
	static mapping = {
		autoTimestamp true
	}
}
