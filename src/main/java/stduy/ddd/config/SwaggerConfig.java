//package stduy.ddd.config;
//
//import org.springframework.context.annotation.Bean;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import io.swagger.v3.oas.models.Components;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SwaggerConfig {
//
//    private static final String SECURITY_SCHEME_NAME = "BearerAuth";
//
//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI()
//                .info(apiInfo())
//                .components(securityComponents())
//                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME));
//    }
//
//    private Info apiInfo() {
//        return new Info()
//                .title("DDD 프로젝트 API")
//                .description("JWT 인증 기반 Q&A 서비스")
//                .version("v1");
//    }
//
//    private Components securityComponents() {
//        return new Components()
//                .addSecuritySchemes(SECURITY_SCHEME_NAME,
//                        new SecurityScheme()
//                                .name(SECURITY_SCHEME_NAME)
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT"));
//    }
//}
