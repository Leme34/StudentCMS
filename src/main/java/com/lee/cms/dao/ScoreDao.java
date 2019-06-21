package com.lee.cms.dao;


import com.lee.cms.dto.AverageScoreVo;
import com.lee.cms.dto.ScoreVo;
import com.lee.cms.entity.Course;
import com.lee.cms.entity.Score;
import com.lee.cms.utils.page.Pagination;

import java.util.List;

public interface ScoreDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

	int delete(Score score);

	int update(List<Score> scoreList);

	List<Course> getCourseList(Pagination<Course> page, String id, Integer result);

	int getTotalItemsCount(String id, Integer result);

	int getTotalItemsCountForExport(ScoreVo scoreVo);

	List<ScoreVo> getScoreListForExport(Pagination<ScoreVo> page,
                                        ScoreVo scoreVo);

	List<AverageScoreVo> getAverageByCid(Integer cid);

	int getTotalAverageScoreItemsCount(Integer cid);
}