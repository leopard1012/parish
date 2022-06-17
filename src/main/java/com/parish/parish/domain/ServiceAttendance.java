package com.parish.parish.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    private User user;
}
