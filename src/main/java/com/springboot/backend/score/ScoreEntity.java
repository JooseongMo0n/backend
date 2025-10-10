package com.springboot.backend.score;

import com.springboot.backend.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//STUDY: `@Builder`에 대해 공부하기
//TODO: LocalDateTime 해결

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreEntity extends BaseTimeEntity {
    //--- Properties ---//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = false, length = 20)
    private String name;

    @Column(unique = false)
    private int score;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameMode gameMode;

    @Column(nullable = false)
    private boolean isItemMode;

}

