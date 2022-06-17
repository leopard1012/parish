package com.parish.parish.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class PastoralLeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pastoralLeaderId;

    @Column
    private String userName;

    @Column
    private String userNameSeparator;

    @Column
    private Integer parishCode;

    @Column
    private Integer areaCode;

    @Column
    private Long userId;
}
