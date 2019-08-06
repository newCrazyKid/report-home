/**
 * 
 */
package com.ai.rti.report.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.rti.report.mapper.AssessmentMapper;
import com.ai.rti.report.service.AssessmentService;

/**
 * 
 *
 * @param request
 * @param response
 * @return
 */

@Service
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired
	private AssessmentMapper assessmentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ai.rti.report.service.AssessmentService#getInfo(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getInfo(String month, String dept_id, String target_level1_code,
			String target_level2_code, String iscity) {

		if (isAllData(dept_id)) {
			if (month == null || "".equals(month)) {
				month = getLastMonth();
			}
			return assessmentMapper.getData(month, target_level1_code, target_level2_code, iscity);
		} else {
			month = getYearDate();
			return assessmentMapper.getDataEvery(month, dept_id, target_level1_code, target_level2_code);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ai.rti.report.service.AssessmentService#getLineInfo(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getLineInfo(String month, String dept_id, String target_level1_code,
			String target_level2_code, String iscity) {
		if (isAllData(dept_id)) {
			if (month == null || "".equals(month)) {
				month = getLastMonth();
			}
			return assessmentMapper.getLinebData(month, target_level1_code, target_level2_code, iscity);
		} else {
			month = getYearDate();
			return assessmentMapper.getLinebDataEvery(month, dept_id, target_level1_code, target_level2_code);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ai.rti.report.service.AssessmentService#getRepmktSum(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getRepmktSum(String data_time, String collation) {

		return assessmentMapper.getRepmktSum(data_time, collation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ai.rti.report.service.AssessmentService#getChannelSca(java.lang.
	 * String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getChannelSca(String data_time, String collation, String mkt_campaign_id) {
		return assessmentMapper.getChannelSca(data_time, mkt_campaign_id, collation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ai.rti.report.service.AssessmentService#getSumMkt(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getSumMkt(String data_time) {
		// TODO Auto-generated method stub
		return assessmentMapper.getSumMkt(data_time);
	}

	private String getYearDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, -1);
		Date y = c.getTime();
		String year = format.format(y);
		return year;
	}

	private String getLastMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1);
		Date y = c.getTime();
		String date = format.format(y);
		return date;
	}

	private Boolean isAllData(String dept_id) {
		List<String> depList = new ArrayList<String>();
		depList.add("2100000000");
		depList.add("2400000000");
		depList.add("2500000000");
		return depList.contains(dept_id);

	}

}
