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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String userName;

    @Column
    private String userNameSeparator;

    @Column
    private Integer parishCode;

    @Column
    private Integer areaCode;

    @Column
    private Long pastoralCode;

    @Column(columnDefinition = "boolean default false")
    @Builder.Default
    private Boolean parishLeader = false;

    @Column(columnDefinition = "boolean default false")
    @Builder.Default
    private Boolean areaLeader = false;

    @Column(columnDefinition = "boolean default false")
    @Builder.Default
    private Boolean pastoralLeader = false;

    @Column(columnDefinition = "boolean default false")
    @Builder.Default
    private Boolean deleteYn = false;

    @Column
    private String email;

    @Column
    private Boolean administrator;
}
