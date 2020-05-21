package net.desafio.springboot2.dock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("net.desafio.springboot2.dock.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {

		return new ApiInfoBuilder().title("Desafio Dock REST API")
				.description("Microsservico para manipulação de dadaos de conta bancária -  REST API")
				.contact(new Contact("Paulo Victor Sobrinho de Jesus", "https://www.linkedin.com/in/paulo-victor-sobrinho-6a016a21/", "pauo.sobrinho@outlook.com.br"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}
}
