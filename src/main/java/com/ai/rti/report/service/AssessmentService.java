/**
 * 
 */
package com.ai.rti.report.service;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @param request
 * @param response
 * @return
 */
public interface AssessmentService {

	List<Map<String, Object>> getInfo(String month, String dept_id, String target_level1_code,
			String target_level2_code, String iscity);

	List<Map<String, Object>> getLineInfo(String month, String dept_id, String target_level1_code,
			String target_level2_code, String iscity);

	List<Map<String, Object>> getRepmktSum(String data_time, String collation);

	List<Map<String, Object>> getChannelSca(String data_time, String collation, String mkt_campaign_id);

	List<Map<String, Object>> getSumMkt(String data_time);
}
