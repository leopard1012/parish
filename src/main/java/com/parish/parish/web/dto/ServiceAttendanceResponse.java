package com.parish.parish.web.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
public class ServiceAttendanceResponse {
    List<String> pastoralUserList;
    Map<String,List<LocalDate>> onLineMap;
    Map<String,List<LocalDate>> offLineMap;
    List<LocalDate> cols;
}
