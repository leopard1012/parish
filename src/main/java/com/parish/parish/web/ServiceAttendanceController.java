package com.parish.parish.web;

import com.parish.parish.service.ServiceAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class ServiceAttendanceController {
    private final ServiceAttendanceService attendanceService;

    @PutMapping(value = "/attendance", produces = "application/json; charset=UTF-8")
    @Transactional
    public Long createUser(@RequestBody HashMap<String, Object> resultMap) {
        return attendanceService.updateServiceAttendanceForSurveyForm(resultMap);
    }
}
