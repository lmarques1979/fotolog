package fotolog

import static org.springframework.http.HttpStatus.*
import fotolog.BaseController;
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class MidiaController extends BaseController{

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

	@Secured(["authentication.name=='admin'"])
	def index(Integer max) {

	    def configuracoes = configuracaoParams
		
		if(params.filtroevento==null){
			params.filtroevento='0';
		}		
		def evento = Evento.get(Long.valueOf(params.filtroevento).longValue())
		
		def resultado = Midia.createCriteria().list(configuracoes) {
			if(params.filtroevento!='0'){
				eq("evento" , evento)
			}
			order('evento', 'desc')
			order('midia', 'asc')
		} 
		respond resultado, model:[midiaInstanceCount: resultado.totalCount, eventoInstance: evento , filtroevento:params.filtroevento]
	}
	
	@Secured('permitAll') 
	def listavideo() {
		
		def configuracoes = configuracaoParams
		def evento = Evento.get(Long.valueOf(params.filtrovideo ? params.filtrovideo : '0').longValue())
		
		def resultado = Midia.createCriteria().list () {
			eq("evento" , evento)
			order('dateCreated', 'asc')
			order('evento', 'desc')
			order('midia', 'asc') 
		}
		respond resultado, model:[midiaInstanceCount: resultado.size, eventoInstance: evento , filtrovideo:params.filtrovideo]
	}
	
	@Secured('permitAll')
	def listamusica() {
		def configuracoes = configuracaoParams
		def evento = Evento.get(Long.valueOf(params.filtromusica ? params.filtromusica : '0').longValue())
		
		def resultado = Midia.createCriteria().list () {
			eq("evento" , evento)
			order('dateCreated', 'asc')
			order('evento', 'desc')
			order('midia', 'asc')
		}
		respond resultado, model:[midiaInstanceCount: resultado.size, eventoInstance: evento , filtromusica:params.filtromusica]
	
	}
	
	@Secured('permitAll') 
	def listaporevento() {

		def configuracoes = configuracaoParams
		def evento = Evento.get(Long.valueOf(params.filtroevento ? params.filtroevento : '0').longValue())
		
		def resultado = Midia.createCriteria().list () {
			eq("evento" , evento)
			order('dateCreated', 'asc')
			order('evento', 'desc')
			order('midia', 'asc')
		}
		respond resultado, model:[midiaInstanceCount: resultado.size, eventoInstance: evento , filtroevento:params.filtroevento]
	}

	@Secured(["authentication.name=='admin'"])
    def show(Midia midiaInstance) {
		def configuracoes = configuracaoParams
		def resultado = DadosMidia.createCriteria().list() {
			eq("midia" , midiaInstance)
		}
        respond midiaInstance,model:[dadosMidiaInstance: resultado]
    }

	@Secured(["authentication.name=='admin'"])
	def create() {
		def midiaInstance = new Midia(params)
    }

    @Transactional
	@Secured(["authentication.name=='admin'"])
    def save(Midia midiaInstance) {
		
        if (midiaInstance == null) {
            notFound()
            return
        }		
		
		//Imagem
		if(midiaInstance.evento.tipomidia.id==1){
			def f = request.getFile('arquivo')
			if (!f.empty) {
				def midia = fileUpload(f)
				midiaInstance.midia = midia
			}
		}
		//Url Video
		if(midiaInstance.evento.tipomidia.id==2){
			midiaInstance.midia = params.video
		}
		//Musica
		if(midiaInstance.evento.tipomidia.id==3){
			def f = request.getFile('musica')
			if (!f.empty) {
				//upload musica
				
			}
		}
		
		midiaInstance.save flush:true
		
		if (midiaInstance.hasErrors()) {
			respond midiaInstance.errors, view:'create'
			return
		}else{
			//Insiro DadosMidia
			if(params.altura && params.largura){
						
				def dadosMidiaInstance = new DadosMidia()
				dadosMidiaInstance.altura = Long.valueOf(params.altura).longValue()
				dadosMidiaInstance.largura = Long.valueOf(params.largura).longValue()
				dadosMidiaInstance.midia=midiaInstance
				dadosMidiaInstance.save flush:true
				
			}
		}
		
		if(params.tipo=="create"){
			session["evento.id"] 	= midiaInstance.evento.id
			flash.message = message(code: 'default.created.message', args: [message(code: 'midia.label', default: 'Midia'), midiaInstance.id])
			redirect (action:"create")
		}else{
		        request.withFormat {
		            form multipartForm {
		                flash.message = message(code: 'default.created.message', args: [message(code: 'midia.label', default: 'Midia'), midiaInstance.id])
		                redirect midiaInstance
		            }
		            '*' { respond midiaInstance, [status: CREATED] }
		        }
		}
    }

	@Secured(["authentication.name=='admin'"])
    def edit(Midia midiaInstance) {
		def resultado = DadosMidia.createCriteria().list() {
			eq("midia" , midiaInstance)
		}
        respond midiaInstance , model:[dadosMidiaInstance: resultado]
    }

    @Transactional
	@Secured(["authentication.name=='admin'"])
    def update(Midia midiaInstance) {
        if (midiaInstance == null) {
            notFound()
            return
        }
		
		def f = request.getFile('arquivo')
		if (!f.empty) {
			def deleteS3 = fileDelete(midiaInstance.midia)
			def imagem = fileUpload(f)
			midiaInstance.midia = imagem 
		}
        midiaInstance.save flush:true

		if (midiaInstance.hasErrors()) {
			respond midiaInstance.errors, view:'edit'
			return
		}else{
			
				if(params.altura && params.largura){
					
					def dadosMidiaInstance = DadosMidia.get(Long.valueOf(params.dadosMidia.id).longValue())
				   	dadosMidiaInstance.altura  = Long.valueOf(params.altura).longValue()
					dadosMidiaInstance.largura = Long.valueOf(params.largura).longValue()
					dadosMidiaInstance.save flush:true
				}	
		}
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Midia.label', default: 'Midia'), midiaInstance.id])
                redirect midiaInstance
            }
            '*'{ respond midiaInstance, [status: OK] }
        }
    }

    @Transactional
	@Secured(["authentication.name=='admin'"])
    def delete(Midia midiaInstance) {

        if (midiaInstance == null) {
            notFound()
            return
        }
		
		def midia = midiaInstance.midia

        midiaInstance.delete flush:true

		if (!midiaInstance.hasErrors()) {
			fileDelete(midia)
		}
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Midia.label', default: 'Midia'), midiaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'midia.label', default: 'Midia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
