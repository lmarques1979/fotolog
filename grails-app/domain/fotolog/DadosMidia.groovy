package fotolog

import java.util.Date;

class DadosMidia {
	
	int		altura
	int		largura
	Date 	dateCreated
	Date 	lastUpdated
	Midia	midia
		
	static constraints = {
		altura(nullable:true)
		largura(nullable:true)
		largura(nullable:false)
	}
	
	static mapping = {
		autoTimestamp true
	}
}
