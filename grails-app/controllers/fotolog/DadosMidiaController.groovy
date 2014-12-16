package fotolog



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DadosMidiaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DadosMidia.list(params), model:[dadosMidiaInstanceCount: DadosMidia.count()]
    }

    def show(DadosMidia dadosMidiaInstance) {
        respond dadosMidiaInstance
    }

    def create() {
        respond new DadosMidia(params)
    }

    @Transactional
    def save(DadosMidia dadosMidiaInstance) {
        if (dadosMidiaInstance == null) {
            notFound()
            return
        }

        if (dadosMidiaInstance.hasErrors()) {
            respond dadosMidiaInstance.errors, view:'create'
            return
        }

        dadosMidiaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dadosMidia.label', default: 'DadosMidia'), dadosMidiaInstance.id])
                redirect dadosMidiaInstance
            }
            '*' { respond dadosMidiaInstance, [status: CREATED] }
        }
    }

    def edit(DadosMidia dadosMidiaInstance) {
        respond dadosMidiaInstance
    }

    @Transactional
    def update(DadosMidia dadosMidiaInstance) {
        if (dadosMidiaInstance == null) {
            notFound()
            return
        }

        if (dadosMidiaInstance.hasErrors()) {
            respond dadosMidiaInstance.errors, view:'edit'
            return
        }

        dadosMidiaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DadosMidia.label', default: 'DadosMidia'), dadosMidiaInstance.id])
                redirect dadosMidiaInstance
            }
            '*'{ respond dadosMidiaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DadosMidia dadosMidiaInstance) {

        if (dadosMidiaInstance == null) {
            notFound()
            return
        }

        dadosMidiaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DadosMidia.label', default: 'DadosMidia'), dadosMidiaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dadosMidia.label', default: 'DadosMidia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
