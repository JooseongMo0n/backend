package com.springboot.backend.score;

import jakarta.validation.constraints.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.time.LocalDateTime;


public class ScoreRequestDto {
    @NotBlank
    @Size(max = 20)
    private String name;

    @NotNull
    @Positive
    private int score;

    private GameMode gameMode;
    private boolean isItemMode;

    public ScoreRequestDto(String name, Integer score, LocalDateTime updatedAt, GameMode gameMode, boolean isItemMode) {
        this.name = name;
        this.score = score;
        this.gameMode = gameMode;
        this.isItemMode = isItemMode;
    }

    public ScoreEntity toEntity() {
        return ScoreEntity.builder()
                .name(this.name)
                .score(this.score)
                .gameMode(this.gameMode)
                .isItemMode(this.isItemMode)
                .build();
    }
}
