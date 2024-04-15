package com.mgjinproject.showstack.dto;


import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "articleDTO")
@Getter
public class ArticleDTO {
    public Long id;
    @Schema(description = "title",required=true,type="String",example = "df")
    private String title;

    @Schema(description = "content",required = true,type="String")
    private String content;
}
