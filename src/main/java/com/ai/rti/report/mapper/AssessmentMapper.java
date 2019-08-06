package com.ai.rti.report.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssessmentMapper {
	// 所有部门数据
	// 获取月份、部门、一级指标、二级指标获取三级指标名和数据
	List<Map<String, Object>> getData(@Param(value = "month") String month,
			@Param(value = "target_level1_code") String target_level1_code,
			@Param(value = "target_level2_code") String target_level2_code, @Param(value = "iscity") String iscity);

	// 本部门前十二个月数据
	// 获取月份、部门、一级指标、二级指标获取三级指标名和数据
	List<Map<String, Object>> getDataEvery(@Param(value = "month") String month,
			@Param(value = "dept_id") String dept_id, @Param(value = "target_level1_code") String target_level1_code,
			@Param(value = "target_level2_code") String target_level2_code);

	// 所有部门数据
	// 根据月份、部门、一级指标、二级指标、获取部门，指标值
	List<Map<String, Object>> getLinebData(@Param(value = "month") String month,
			@Param(value = "target_level1_code") String target_level1_code,
			@Param(value = "target_level2_code") String target_level2_code, @Param(value = "iscity") String iscity);

	// 本部门数据前十二个月数据
	// 根据月份、部门、一级指标、二级指标、获取部门，指标值
	List<Map<String, Object>> getLinebDataEvery(@Param(value = "month") String month,
			@Param(value = "dept_id") String dept_id, @Param(value = "target_level1_code") String target_level1_code,
			@Param(value = "target_level2_code") String target_level2_code);

	// 根据日期获取按排名规则的前五排序的活动
	List<Map<String, Object>> getRepmktSum(@Param(value = "data_time") String data_time,
			@Param(value = ("collation")) String collation);

	// 根据营销活动的id、日期获取活动各渠道按排序规则字段
	List<Map<String, Object>> getChannelSca(@Param(value = "data_time") String data_time,
			@Param(value = "mkt_campaign_id") String mkt_campaign_id, @Param(value = "collation") String collation);

	// // 根据一级指标id、二级指标id获取三级指标名称
	// List<Map<String, Object>> getTargetName(@Param(value =
	// "target_level1_code") String target_level1_code,
	// @Param(value = "target_level2_code") String target_level2_code);

	// 获取活动统计数据四个值
	List<Map<String, Object>> getSumMkt(@Param(value = "data_time") String data_time);

}
