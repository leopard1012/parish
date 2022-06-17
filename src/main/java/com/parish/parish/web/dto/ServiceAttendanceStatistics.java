package com.parish.parish.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ServiceAttendanceStatistics {
    private LocalDate serviceDate;

    private int offline_sum_1;
    private int offline_sum_2;
    private int offline_sum_3;
    private int offline_sum_4;
    private int offline_sum_5;
    private int offline_sum_6;
    private int offline_sum_7;

    private int online_sum_1;
    private int online_sum_2;
    private int online_sum_3;
    private int online_sum_4;
    private int online_sum_5;
    private int online_sum_6;
}
