package fotolog

import static org.springframework.http.HttpStatus.*
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.codehaus.groovy.grails.web.mapping.LinkGenerator
import fotolog.BaseController;
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured 

@Transactional(readOnly = true)
class MidiaController extends BaseController{

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]
	
	def FileUploadService
	// Inject link generator
	LinkGenerator grailsLinkGenerator
	
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
				
		def evento = Evento.get(Long.valueOf(params.filtrovideo ? params.filtrovideo : '0').longValue())
		params.max = Math.min(1,10000)
		
		def url = grailsLinkGenerator.resource(dir: '/' , absolute: true) + message(code: 'diretoriovideos.message') + File.separator
		
		def resultado = Midia.createCriteria().list (params) {
			eq("evento" , evento)
			order('dateCreated', 'asc')
			order('evento', 'desc')
			order('midia', 'asc') 
		}
		def total = resultado.totalCount ? resultado.totalCount : 0
		respond resultado, model:[diretorio: url, midiaInstanceCount: total , eventoInstance: evento , filtrovideo:params.filtrovideo]
	}
	
	@Secured('permitAll')
	def listamusica() {
		
		def configuracoes = configuracaoParams
		def evento = Evento.get(Long.valueOf(params.filtromusica ? params.filtromusica : '0').longValue())
		
		def url = grailsLinkGenerator.resource(dir: '/' , absolute: true) + message(code: 'diretoriomusicas.message')
				
		def resultado = Midia.createCriteria().list (configuracoes) {
			eq("evento" , evento)
			order('dateCreated', 'asc')
			order('evento', 'desc')
			order('midia', 'asc')
		}
		def total = resultado.totalCount ? resultado.totalCount : 0
		respond resultado, model:[diretorio: url, midiaInstanceCount: total, eventoInstance: evento , filtromusica:params.filtromusica]
	
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
		respond midiaInstance
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
		
		def f = request.getFile('arquivo')
		def ret
		
		if (!f.empty) {
			
			//Imagem (Upload Pro Amazon S3
			if(midiaInstance.evento.tipomidia.id==1){
				def midia = FileUploadService.fileUpload(f , 'fotologlmdcm' , 'assets/')
				midiaInstance.midia = midia
			}
			
			//Video
			if(midiaInstance.evento.tipomidia.id==2 || midiaInstance.evento.tipomidia.id==3){
				
				midiaInstance.extensao=FileUploadService.getExtension(f.getOriginalFilename())
				midiaInstance.midia = FileUploadService.removeExtension(f.getOriginalFilename())
				
				if(midiaInstance.evento.tipomidia.id==2){
					def dir = message(code: 'diretoriovideos.message') + File.separator + midiaInstance.evento.nome
					ret = FileUploadService.uploadFile(f , f.getOriginalFilename() , dir)
				}
				if(midiaInstance.evento.tipomidia.id==3){
					def dir = message(code: 'diretoriomusicas.message') + File.separator + midiaInstance.evento.nome
					ret = FileUploadService.uploadFile(f , f.getOriginalFilename() , dir)					
				}
			}
		}
		
		session["evento.id"] = midiaInstance.evento.id
		midiaInstance.save flush:true
		
		if (midiaInstance.hasErrors()) {
			respond midiaInstance.errors, view:'create'
			return
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
		
        respond midiaInstance
    }

    @Transactional
	@Secured(["authentication.name=='admin'"])
    def update(Midia midiaInstance) {
        if (midiaInstance == null) {
            notFound()
            return
        }
		
		def f = request.getFile('arquivo')
		def ret
		
		if (!f.empty) {
			
			//Imagem (Upload Pro Amazon S3
			if(midiaInstance.evento.tipomidia.id==1){
				def midia = FileUploadService.fileUpload(f , 'fotologlmdcm' , 'assets/')
				midiaInstance.extensao=FileUploadService.getExtension(midia)
				midiaInstance.midia = FileUploadService.removeExtension(midia)
				
			}
			
			//Video
			if(midiaInstance.evento.tipomidia.id==2 || midiaInstance.evento.tipomidia.id==3){
				
				midiaInstance.extensao=FileUploadService.getExtension(f.getOriginalFilename())
				midiaInstance.midia = FileUploadService.removeExtension(f.getOriginalFilename())
				
				if(midiaInstance.evento.tipomidia.id==2){
					def dir = message(code: 'diretoriovideos.message') + File.separator + midiaInstance.evento.nome
					ret = FileUploadService.uploadFile(f , f.getOriginalFilename() , dir)
				}
				if(midiaInstance.evento.tipomidia.id==3){
					def dir = message(code: 'diretoriomusicas.message') + File.separator + midiaInstance.evento.nome
					ret = FileUploadService.uploadFile(f , f.getOriginalFilename() , dir)
				}
			}
		}

        midiaInstance.save flush:true

		if (midiaInstance.hasErrors()) {
			respond midiaInstance.errors, view:'edit'
			return
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
		
		def midiaDeleted = new Midia()
		midiaDeleted = midiaInstance

        midiaInstance.delete flush:true

		if (!midiaInstance.hasErrors()) {
			
			if(midiaDeleted.evento.tipomidia.id==1){
				FileUploadService.fileDelete(midiaDeleted?.midia + '.' + midiaDeleted?.extensao, 'fotologlmdcm' , 'assets/')
			}
			if(midiaDeleted.evento.tipomidia.id==2){
				def dir = message(code: 'diretoriovideos.message') + File.separator + midiaInstance.evento.nome + File.separator + midiaDeleted?.midia + '.' + midiaDeleted?.extensao
				def ret = FileUploadService.fileLocalDelete(dir)
			}
			if(midiaDeleted.evento.tipomidia.id==3){
				def dir = message(code: 'diretoriomusicas.message') + File.separator + midiaInstance.evento.nome + File.separator + midiaDeleted?.midia + '.' + midiaDeleted?.extensao
				def ret = FileUploadService.fileLocalDelete(dir)
			}
			
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
