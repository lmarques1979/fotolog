package fotolog

import java.util.Date;


class Evento {
	
	String nome
	String descricao
	Date data
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [midias:Midia]
	static hasOne = [tipomidia:TipoMidia]
		
    static constraints = {
		nome(nullable:false,blank:false)
		descricao(nullable:true,blank:true)
		data(nullable:true,blank:true)
		tipomidia(nullable:true,blank:true)
    }
	
	static mapping = {
		midias cascade: 'all-delete-orphan'
		sort data:"desc"
		autoTimestamp true
	}
	
}
