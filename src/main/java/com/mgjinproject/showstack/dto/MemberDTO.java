package com.mgjinproject.showstack.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "member")
@Getter
public class MemberDTO {
    private Long id;

    @Schema(description = "name", example = "hal")
    private String name;

    @Schema(description = "sex",example = "female")
    private String gender;
}
