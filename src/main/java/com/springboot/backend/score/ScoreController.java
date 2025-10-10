package com.springboot.backend.score;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tetris/scores")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    /**
     * 모든 점수 조회
     * 일반적으로 Get 요청에는 ResponseEntity.ok
     */
    //TODO: ScoreBoard가 empty일 때 추가.
    @GetMapping
    public ResponseEntity<List<ScoreResponseDto>> getScoreBoard() {
        List<ScoreResponseDto> scoreBoard = scoreService.getScoreBoard();
        return ResponseEntity.ok(scoreBoard);
    }

    /**
     * score 추가
     */
    @PostMapping
    public ResponseEntity<ScoreResponseDto> saveScore(@Valid @RequestBody ScoreRequestDto newScore) {
        ScoreResponseDto responseDto = scoreService.saveScore(newScore);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    /**
     * Score Board 초기화
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteScoreBoard() {
        scoreService.deleteScoreBoard();
        return ResponseEntity.noContent().build();
        // 다음 코드도 가능함
        // return ResponseEntity.ok("Score Board Deleted");
    }

}

//STUDY: 하단 Controller 반환값
/*
Controller 반환값 정의
//--- 성공 ---//
ResponseEntity.ok(body): 200 OK 상태 코드와 데이터를 함께 반환 (Get)
ResponseEntity.status(HttpStatus.CREATED).body(body): 201 Created 상태 코드와 데이터를 함께 반환 (Post, Push)
ResponseEntity.noContent().build(): 204 No Content 상태 코드를 반환 (본문 없음) (Delete)

//--- 실패 ---//
ResponseEntity.notFound().build(): 404 Not Found 상태 코드를 반환
 */

//STUDY: final keyword