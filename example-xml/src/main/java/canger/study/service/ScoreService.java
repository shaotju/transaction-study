package canger.study.service;

import canger.study.model.Score;

public interface ScoreService {
    Score getScore(int id);
    int updateScore(int id,int score);
}
