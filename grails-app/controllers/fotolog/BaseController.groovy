package fotolog

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import utils.*

@Transactional(readOnly = true) 
@Secured("isAuthenticated()")     
class BaseController{
	
	def springSecurityService
	
	def enviaEmail(def destinatario , def assunto , def mensagem, def remetente, def conteudomensagem){
		
		def msgfinal = mensagem + "<br><br><b>" + remetente + "</b> enviou a seguinte mensagem: <br><br>" + conteudomensagem 
		
		sendMail {
					to destinatario
					subject assunto
					html msgfinal
		}
	}	
	
	def getConfiguracaoParams(){
		
			def resultado = Configuracao.findAll()
			resultado.each() {
				params.alturaimagens 		= it.alturaimagens ? it.alturaimagens : "120"
				params.larguraimagens 		= it.larguraimagens ? it.larguraimagens : "125"
				params.alturaimagensthumbs 	= it.alturaimagensthumbs ? it.alturaimagensthumbs : "20"
				params.larguraimagensthumbs	= it.larguraimagensthumbs ? it.larguraimagensthumbs : "25"
				params.max = Math.min(it.itensporpagina ? it.itensporpagina : 20, 10000)
			}
			if (resultado.size() == 0){
				params.alturaimagens 		= "120"
				params.larguraimagens 		= "125"
				params.alturaimagensthumbs 	= "20"
				params.larguraimagensthumbs	= "25"
				params.max = Math.min(10, 10000)
			}
			params
	}
  
	
  def getUsuarioLogado(){
		  springSecurityService.currentUser
  }
 
}