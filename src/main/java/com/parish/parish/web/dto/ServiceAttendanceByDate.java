package com.parish.parish.web.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ServiceAttendanceByDate {
    LocalDate serviceDate;
    String attendanceType;
}
