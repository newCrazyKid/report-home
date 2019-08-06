/**
 * 
 */
package com.ai.rti.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.rti.report.entity.CampTable;

/**
 * 
 *
 * @param request
 * @param response
 * @return
 */
public interface ReportMapper {

	/**
	 * 服务事件报表
	 * created by xiejialin
	 * @param begin_time
	 * @param end_time
	 * @param mkt_campaign_name
	 * @param script_name
	 * @return
	 */
	List<CampTable> getCampDataList(@Param(value="begin_time") String begin_time,
									@Param(value = "end_time") String end_time,
									@Param(value="mkt_campaign_name") String mkt_campaign_name,
									@Param(value="script_name") String script_name);

}
