/**
 * 
 */
package com.ai.rti.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.rti.report.entity.CampTable;
import com.ai.rti.report.mapper.ReportMapper;
import com.ai.rti.report.service.ReportService;

/**
 * 
 *
 * @param request
 * @param response
 * @return
 */
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportMapper reportMapper;

	/**
	 * 服务事件报表
	 * created by xiejialin
	 * @param begin_time
	 * @param end_time
	 * @param mkt_campaign_name
	 * @param script_name
	 * @return
	 */
	@Override
	public List<CampTable> getCampDataList(String begin_time, String end_time, String mkt_campaign_name, String script_name) {
		return reportMapper.getCampDataList(begin_time, end_time, mkt_campaign_name, script_name);
	}

}
