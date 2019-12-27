package canger.study.service.impl;

import canger.study.mapper.ScoreMapper;
import canger.study.model.Score;
import canger.study.service.ScoreService;

public class ScoreServiceImpl implements ScoreService {

    private ScoreMapper scoreMapper;

    public ScoreMapper getScoreMapper() {
        return scoreMapper;
    }

    public void setScoreMapper(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    @Override
    public Score getScore(int id) {
        return scoreMapper.selectScore(id);
    }

    @Override
    public int updateScore(int id, int score) {
        return scoreMapper.updateScore(id,score);
    }
}
