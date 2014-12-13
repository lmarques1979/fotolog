package fotolog

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(["authentication.name=='admin'"])
@Transactional(readOnly = true)
class EventoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def configuracoes = configuracaoParams
        respond Evento.list(configuracoes), model:[eventoInstanceCount: Evento.count()]
    }

    def show(Evento eventoInstance) {
        respond eventoInstance
    }

    def create() {
        respond new Evento(params)
    }

    @Transactional
    def save(Evento eventoInstance) {
        if (eventoInstance == null) {
            notFound()
            return
        }

        if (eventoInstance.hasErrors()) {
            respond eventoInstance.errors, view:'create'
            return
        }

        eventoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'evento.label', default: 'Evento'), eventoInstance.id])
                redirect eventoInstance
            }
            '*' { respond eventoInstance, [status: CREATED] }
        }
    }

    def edit(Evento eventoInstance) {
        respond eventoInstance
    }

    @Transactional
    def update(Evento eventoInstance) {
        if (eventoInstance == null) {
            notFound()
            return
        }

        if (eventoInstance.hasErrors()) {
            respond eventoInstance.errors, view:'edit'
            return
        }

        eventoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Evento.label', default: 'Evento'), eventoInstance.id])
                redirect eventoInstance
            }
            '*'{ respond eventoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Evento eventoInstance) {

        if (eventoInstance == null) {
            notFound()
            return
        }
		
		def resultado = Foto.createCriteria().list () {
			eq("evento" , eventoInstance)
		}
		
		resultado.each(){
			def deleteS3 = fileDelete(it.imagem)
		}
		
        eventoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Evento.label', default: 'Evento'), eventoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'evento.label', default: 'Evento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
