package ejemplo.persistencia

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        actualizarConPunto
        get "/medico/crear/"(controller: 'medico', action: 'crear')
        get "/medico/actualizarconset/$medicoId/"(controller: 'medico', action: 'actualizarConSet')
        get "/medico/actualizarsinset/$medicoId/"(controller: 'medico', action: 'actualizarSinSet')
        get "/medico/actualizarconpunto/$medicoId/"(controller: 'medico', action: 'actualizarConPunto')
        get "/medico/crearpersona/"(controller: 'medico', action: 'crearPersona')
        
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
