package com.parish.parish.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceAttendanceParam {
    private String formId;
    private String forTitle;
    private String userNameSeparator;
    private Integer parishCode;
    private Integer areaCode;
    private Long pastoralCode;
}
