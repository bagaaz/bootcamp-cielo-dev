package ada.tech.cielo3.infra.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersOpenAPI() {
        return new OpenAPI()
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title("API de Gerenciamento de Clientes")
                                .description("Documentação da API para gerenciamento de clientes.")
                                .version("1.0.0")
                );
    }
}
