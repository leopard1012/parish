package com.parish.parish.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SurveyFormParam {
    private String formId;
    private String formTitle;
    private String userNameSeparator;
    private Integer parishCode;
    private Integer areaCode;
    private Long pastoralCode;
}
