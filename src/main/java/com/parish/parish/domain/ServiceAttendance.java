package com.parish.parish.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ServiceAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceAttendanceId;

    @Column
    private LocalDate serviceDate;

    @Column
    private String serviceType;

    @Column
    private Long userId;

    @Column
    private Boolean isOnline;
}
