package fotolog

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured(["authentication.name=='admin'"])
@Transactional(readOnly = true)
class ExtensoesPermitidasController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ExtensoesPermitidas.list(params), model:[extensoesPermitidasInstanceCount: ExtensoesPermitidas.count()]
    }

    def show(ExtensoesPermitidas extensoesPermitidasInstance) {
        respond extensoesPermitidasInstance
    }

    def create() {
        respond new ExtensoesPermitidas(params)
    }

    @Transactional
    def save(ExtensoesPermitidas extensoesPermitidasInstance) {
        if (extensoesPermitidasInstance == null) {
            notFound()
            return
        }

        if (extensoesPermitidasInstance.hasErrors()) {
            respond extensoesPermitidasInstance.errors, view:'create'
            return
        }

        extensoesPermitidasInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'extensoesPermitidas.label', default: 'ExtensoesPermitidas'), extensoesPermitidasInstance.id])
                redirect extensoesPermitidasInstance
            }
            '*' { respond extensoesPermitidasInstance, [status: CREATED] }
        }
    }

    def edit(ExtensoesPermitidas extensoesPermitidasInstance) {
        respond extensoesPermitidasInstance
    }

    @Transactional
    def update(ExtensoesPermitidas extensoesPermitidasInstance) {
        if (extensoesPermitidasInstance == null) {
            notFound()
            return
        }

        if (extensoesPermitidasInstance.hasErrors()) {
            respond extensoesPermitidasInstance.errors, view:'edit'
            return
        }

        extensoesPermitidasInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ExtensoesPermitidas.label', default: 'ExtensoesPermitidas'), extensoesPermitidasInstance.id])
                redirect extensoesPermitidasInstance
            }
            '*'{ respond extensoesPermitidasInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ExtensoesPermitidas extensoesPermitidasInstance) {

        if (extensoesPermitidasInstance == null) {
            notFound()
            return
        }

        extensoesPermitidasInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ExtensoesPermitidas.label', default: 'ExtensoesPermitidas'), extensoesPermitidasInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'extensoesPermitidas.label', default: 'ExtensoesPermitidas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
