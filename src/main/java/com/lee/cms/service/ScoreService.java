package com.lee.cms.service;

import com.lee.cms.dto.AverageScoreVo;
import com.lee.cms.dto.ScoreVo;
import com.lee.cms.entity.Course;
import com.lee.cms.entity.Score;
import com.lee.cms.utils.page.Pagination;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ScoreService {

	int choiceCourse(Score score);

	int updateScore(Score score);

	int deleteScore(Score s);

	int updateScore(List<Score> scoreList);

	int getTotalItemsCount(String string, Integer result);

	List<Course> getCourseList(Pagination<Course> page, String string, Integer result);

	int getTotalItemsCount(ScoreVo scoreVo);

	List<ScoreVo> getScoreList(Pagination<ScoreVo> page, ScoreVo scoreVo);

	XSSFWorkbook exportExcelInfo(ScoreVo scoreVo) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, IllegalAccessException;

	List<AverageScoreVo> getAverageByCid(Integer cid);

	int getTotalAverageScoreItemsCount(Integer cid);
}
