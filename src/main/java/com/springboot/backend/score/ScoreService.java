package com.springboot.backend.score;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    @Transactional(readOnly = true)
    public List<ScoreResponseDto> getScoreBoard() {
        List<ScoreEntity> scoreEntities = scoreRepository.findAll();
        //STUDY: 해당 코드 공부하기
        return scoreEntities.stream().map(ScoreResponseDto::new).toList();
    }

    @Transactional
    public ScoreResponseDto saveScore(ScoreRequestDto newScore) {
        ScoreEntity scoreEntity = newScore.toEntity();
        ScoreEntity savedScore = scoreRepository.save(scoreEntity);
        return new ScoreResponseDto(savedScore);
    }

    public void deleteScoreBoard() {
        scoreRepository.deleteAll();
    }
}
