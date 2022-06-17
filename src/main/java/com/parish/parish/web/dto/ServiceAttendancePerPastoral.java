package com.parish.parish.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ServiceAttendancePerPastoral {
    private String userName;
    private String userNameSeparator;
    private String pastoralName;
    private LocalDate serviceDate;
    private String attendanceType;
    private Boolean online;
}
