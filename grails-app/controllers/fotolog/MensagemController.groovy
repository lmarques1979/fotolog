package fotolog
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured


@Secured(["authentication.name=='admin'"])
@Transactional(readOnly = true)
class MensagemController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Transactional
	@Secured('permitAll')
	def enviamensagem(){
		
		def errobanco
		def msgerro = []
		def mensagemInstance = new Mensagem(params)
		def mensagem
		
		if (mensagemInstance == null) {
			notFound()
			return
		}

		mensagemInstance.save flush:true
		
		if (!mensagemInstance.hasErrors()) {
			//Envio o E-mail
			def assunto = "[Fotolog] - Nova Mensagem Cadastrada"
			def destinatario = "liunit@gmail.com"
			def msg = "Mensagem necessita de aprovação do administrador."
			def conteudomensagem = mensagemInstance.mensagem
			def remetente = mensagemInstance.remetente
			enviaEmail(destinatario, assunto , msg, remetente, conteudomensagem)
			mensagem = message(code: 'mensagem.sucessocreated.message')
		}else{
			msgerro=mensagemInstance.errors
			errobanco=true
		}
		
		if(errobanco){
		render(status:500,contentType: "application/json"){
				[erros:msgerro]
			}
		}else{
		render(status:200,contentType: "application/json"){
			[mensagem:mensagem]
		}
		}
	}
	
    def index(Integer max) {
		
		def configuracoes = configuracaoParams
		
		def resultado = Mensagem.createCriteria().list (configuracoes) {
			
			order('autorizada', 'asc')
			order('dateCreated', 'desc')
			
		}
        respond resultado, model:[mensagemInstanceCount: resultado.totalCount]
    }
	
	def moderar(Integer max) {
		
		def configuracoes = configuracaoParams
		
		def resultado = Mensagem.createCriteria().list (configuracoes) {
			eq("autorizada" , false)
			order('autorizada', 'asc')
			order('dateCreated', 'desc')
			
		}
		respond resultado, model:[mensagemInstanceCount: resultado.totalCount]
	}
	
	@Secured('permitAll')
	def mensagemporfoto(){
		
		def midia = Midia.get(Long.valueOf(params.idfoto).longValue()) 
		def mensagem=[]
		def resultado = Mensagem.createCriteria().list () {
			eq("midia" , midia)
			eq("autorizada" , true)
			order('dateCreated', 'desc')
		}
		
		//Populo o Array de Mensagens
		resultado.each(){
			mensagem.add(it)
		}
		
		render(status:200,contentType: "application/json"){
			[mensagens:mensagem]
		}
		
	}
	
    def show(Mensagem mensagemInstance) {
		def configuracoes = configuracaoParams
        respond mensagemInstance
    }

	@Transactional
	@Secured('permitAll')
    def create() {
		
		def  mensagemInstance = new Mensagem(params)
		
		if (mensagemInstance == null) {
			notFound()
			return
		}

		mensagemInstance.save flush:true 
		
		if (!mensagemInstance.hasErrors()) {
			flash.message = message(code: 'mensagem.sucessocreated.message')
		}
		redirect(controller: "foto", action: "listaporevento" , params: [mensagemInstance: mensagemInstance , filtroevento: mensagemInstance.foto.evento.id])
    }

    @Transactional
    def save(Mensagem mensagemInstance) {
		
        if (mensagemInstance == null) {
            notFound()
            return
        }

        mensagemInstance.save flush:true
		
		if (mensagemInstance.hasErrors()) {
			respond mensagemInstance.errors, view:'create'
			return
		}

        redirect(controller: "foto", action: "listaporevento" , params: [filtroevento: mensagemInstance.foto.evento.id])


    }

    def edit(Mensagem mensagemInstance) {
        respond mensagemInstance
    }

    @Transactional
    def update(Mensagem mensagemInstance) {
        if (mensagemInstance == null) {
            notFound()
            return
        }

        if (mensagemInstance.hasErrors()) {
            respond mensagemInstance.errors, view:'edit'
            return
        }

        mensagemInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Mensagem.label', default: 'Mensagem'), mensagemInstance.id])
                redirect mensagemInstance
            }
            '*'{ respond mensagemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Mensagem mensagemInstance) {

        if (mensagemInstance == null) {
            notFound()
            return
        }

        mensagemInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Mensagem.label', default: 'Mensagem'), mensagemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mensagem.label', default: 'Mensagem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
