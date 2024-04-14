package com.mgjinproject.showstack.config;

import javax.swing.GroupLayout.Group;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

//OpenAPI 스펙을 따르는 API문서의 전체적인 정보를 정의하는 어노테이션
//API의 버전,제목,설명등을 설정가능
@OpenAPIDefinition(
    info = @Info(title= "Exp API",
                description = "연습용 api 명세",
                version = "v1")
)

@RequiredArgsConstructor
@Configuration
public class SwaggerConfiguration {
    
    //GroupedOpenApi : API를 그룹화하여 관리하기 위한 클래스
    //pathToMatch : API 오퍼레이션에 해당하는 경로. 지금은 전체경로
    @Bean
    public GroupedOpenApi SampleArticlesApi(){
     String[] paths = {"/articles/**"};
     return GroupedOpenApi.builder()
     .group("Sample v1-articles")
     .pathsToMatch(paths)
     .build();
    }
   @Bean
   public GroupedOpenApi SampleOpenApi(){
        String[] paths = {"/**"};
        return GroupedOpenApi.builder()
        .group("Sample v1")
        .pathsToMatch(paths)
        .build();
   }
}

