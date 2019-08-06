/**
 * 
 */
package com.ai.rti.report.service;

import java.util.List;

import com.ai.rti.report.entity.CampTable;

/**
 * 
 *
 * @param request
 * @param response
 * @return
 */
public interface ReportService {

	/**
	 * 服务事件报表
	 * created by xiejialin
	 * @param begin_time
	 * @param end_time
	 * @param mkt_campaign_name
	 * @param script_name
	 * @return
	 */
	List<CampTable> getCampDataList(String begin_time, String end_time, String mkt_campaign_name, String script_name);
}
