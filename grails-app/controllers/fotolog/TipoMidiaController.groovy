package fotolog
import fotolog.BaseController;
import grails.plugin.springsecurity.annotation.Secured

@Secured(["authentication.name=='admin'"])
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TipoMidiaController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TipoMidia.list(params), model:[tipoMidiaInstanceCount: TipoMidia.count()]
    }

    def show(TipoMidia tipoMidiaInstance) {
        respond tipoMidiaInstance
    }

    def create() {
        respond new TipoMidia(params)
    }

    @Transactional
    def save(TipoMidia tipoMidiaInstance) {
        if (tipoMidiaInstance == null) {
            notFound()
            return
        }

        if (tipoMidiaInstance.hasErrors()) {
            respond tipoMidiaInstance.errors, view:'create'
            return
        }

        tipoMidiaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoMidia.label', default: 'TipoMidia'), tipoMidiaInstance.id])
                redirect tipoMidiaInstance
            }
            '*' { respond tipoMidiaInstance, [status: CREATED] }
        }
    }

    def edit(TipoMidia tipoMidiaInstance) {
        respond tipoMidiaInstance
    }

    @Transactional
    def update(TipoMidia tipoMidiaInstance) {
        if (tipoMidiaInstance == null) {
            notFound()
            return
        }

        if (tipoMidiaInstance.hasErrors()) {
            respond tipoMidiaInstance.errors, view:'edit'
            return
        }

        tipoMidiaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TipoMidia.label', default: 'TipoMidia'), tipoMidiaInstance.id])
                redirect tipoMidiaInstance
            }
            '*'{ respond tipoMidiaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TipoMidia tipoMidiaInstance) {

        if (tipoMidiaInstance == null) {
            notFound()
            return
        }

        tipoMidiaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TipoMidia.label', default: 'TipoMidia'), tipoMidiaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoMidia.label', default: 'TipoMidia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
