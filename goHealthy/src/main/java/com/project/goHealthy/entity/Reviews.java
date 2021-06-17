package com.project.goHealthy.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "REVIEW_TBL")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer rating;

    @Column
    private String pictureUrl;

    @Column
    private String name;

    @Column
    private String description;

}
