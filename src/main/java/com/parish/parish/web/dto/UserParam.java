package com.parish.parish.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserParam {
    private String userId;
    private String userName;
    private String userNameSeparator;
    private Integer parishCode;
    private Integer areaCode;
    private Long pastoralCode;
}
