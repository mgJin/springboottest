package com.mgjinproject.showstack.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "articleDTO")
public class ArticleDTO {
    @Schema(description = "pk",required = true,type="int")
    private int id;
    @Schema(description = "title",required=true,type="String")
    private String title;
    @Schema(description = "content",required = true,type="String")
    private String content;
}
