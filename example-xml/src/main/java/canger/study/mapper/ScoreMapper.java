package canger.study.mapper;

import canger.study.model.Score;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    Score selectScore(@Param("id") int id);
    int updateScore(@Param("id")int id,@Param("score")int score);
}
