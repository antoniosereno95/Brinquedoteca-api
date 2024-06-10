    package com.upe.brinquedotecaapi.config;

    import io.swagger.v3.oas.annotations.OpenAPIDefinition;
    import io.swagger.v3.oas.annotations.info.Contact;
    import io.swagger.v3.oas.annotations.info.Info;
    import io.swagger.v3.oas.annotations.servers.Server;

    @OpenAPIDefinition(info = @Info(
            contact = @Contact(name = "Projeto de cadastramento na brinquedoteca"),
            description = "backend Brinquedoteca-UPE", title = "Brinquedoteca UPE", version = "1.0"), servers = {@Server(description = "Local ENV",
            url = "http://localhost:8080")})
    public class OpenApiConfig {
    }