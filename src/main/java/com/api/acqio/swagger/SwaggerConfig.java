package com.api.acqio.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket detalheApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.acqio"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build());

        return docket;
    }

    private ApiInfoBuilder informacoesApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("API-ACQIO");
        apiInfoBuilder.description("Api para cadastro de transação de cartão");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos");
        apiInfoBuilder.license("Licença - Open Source");
        apiInfoBuilder.licenseUrl("https://github.com/HigorRobertoDev/acqio-spring");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
    }

    private Contact contato() {
        return new Contact(
                "Higor Roberto",
                "https://github.com/HigorRobertoDev/air-plane-spring-boot",
                "h.saposilva@gmail.com"
        );
    }


}
