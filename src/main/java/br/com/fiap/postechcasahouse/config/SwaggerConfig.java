//package br.com.fiap.postechcasahouse.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("CasaHouse") // Define um nome de grupo para evitar a dependência do Servlet API
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("br.com.fiap.postechcasahouse"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("API da CasaHouse")
//                .description("Documentação da API da CasaHouse")
//                .version("1.0")
//                .contact(new Contact("Casahouse", "https://www.casahouse.com", "postechcasahouse@postechcasahouse.com"))
//                .build();
//    }
//}
