package ejemplo.persistencia

import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MedicoController {

    MedicoService medicoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond medicoService.list(params), model:[medicoCount: medicoService.count()]
    }

    def show(Long id) {
        respond medicoService.get(id)
    }

    def create() {
        respond new Medico(params)
    }

    def save(Medico medico) {
        if (medico == null) {
            notFound()
            return
        }

        try {
            medicoService.save(medico)
        } catch (ValidationException e) {
            respond medico.errors, view:'create'
            return
        }
/*
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'medico.label', default: 'Medico'), medico.id])
                redirect medico
            }
            '*' { respond medico, [status: CREATED] }
        }
        
 */
    }

    def edit(Long id) {
        respond medicoService.get(id)
    }

    def update(Medico medico) {
        if (medico == null) {
            notFound()
            return
        }

        try {
            medicoService.save(medico)
        } catch (ValidationException e) {
            respond medico.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'medico.label', default: 'Medico'), medico.id])
                redirect medico
            }
            '*'{ respond medico, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        medicoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'medico.label', default: 'Medico'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'medico.label', default: 'Medico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    
    def crear() {
    
        Medico medico = new Medico("nombreoriginal")
        medicoService.save(medico)
        render medico.id
    }
    def actualizarSinSet(Long medicoId) {
        medicoService.actualizar(medicoId)
        
        render "ok sin set"
    }
    
    def actualizarConSet(Long medicoId) {
        Medico medico = medicoService.get(medicoId)
        println(medico.isDirty())
        medico.cambiarNombreSet("SETTTTTcambiado")
        medico.cambiarNombre("como use set se actualiza")
       
        println(medico.isDirty())
        //medico.nombre = "se cambio"
        this.save(medico)
        render "ok con set"
    }
    
    def actualizarConPunto(Long medicoId) {
        Medico medico = medicoService.get(medicoId)
        medico.nombre = "se cambio con medico.nombre"
        this.save(medico)
        render "ok con punto"
    }
}
