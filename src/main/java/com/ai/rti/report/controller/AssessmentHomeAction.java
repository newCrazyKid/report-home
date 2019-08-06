/**
 * 
 */
package com.ai.rti.report.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.rti.report.service.AssessmentService;
import com.ai.rti.svc.privilege.IUserSession;
import com.ai.rti.svc.privilege.PrivilegeManager;

/**
 * 
 *
 * @param request
 * @param response
 * @return
 */
@Controller
@RequestMapping("/assessment")
@CrossOrigin
public class AssessmentHomeAction {

	@Autowired
	private AssessmentService assessmentService;

	@RequestMapping(value = "/whatDep", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> whatDep(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			String dept_id = String.valueOf(getDepTd());
			// String dept_id = "2500000000";
			retMap.put("dept_id", dept_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retMap;
	}

	@RequestMapping(value = "/getSumMkt", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSumMkt(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Calendar y = Calendar.getInstance();
			y.add(Calendar.DATE, -1);
			Date day = y.getTime();
			String data_time = format.format(day);
			List<Map<String, Object>> summkt = (List<Map<String, Object>>) assessmentService.getSumMkt(data_time);
			retMap.put("summkt", summkt);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retMap;
	}

	@RequestMapping(value = "/getEchartsPieData", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getEchartsPieData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			String dept_id = String.valueOf(getDepTd());
			// String dept_id = "2500000000";
			String month = request.getParameter("opTime");
			String target_level1_code = request.getParameter("target_level1_code");
			String target_level2_code = request.getParameter("target_level2_code");
			String iscity = request.getParameter("iscity");
			List<Map<String, Object>> data = (List<Map<String, Object>>) assessmentService.getInfo(month, dept_id,
					target_level1_code, target_level2_code, iscity);
			retMap.put("data", data);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retMap;
	}

	@RequestMapping(value = "/getEchartsLineData", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getEchartsLineData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			String dept_id = String.valueOf(getDepTd());
			// String dept_id = "2500000000";
			String month = request.getParameter("opTime");
			String target_level1_code = request.getParameter("target_level1_code");
			String target_level2_code = request.getParameter("target_level2_code");
			String iscity = request.getParameter("iscity");
			List<Map<String, Object>> data = (List<Map<String, Object>>) assessmentService.getLineInfo(month, dept_id,
					target_level1_code, target_level2_code, iscity);
			retMap.put("data", data);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retMap;
	}

	@RequestMapping(value = "/getActivityData", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getActivityData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			// String dept_id = String.valueOf(getDepTd());
			// String dept_id = "2500000000";
			String collation = request.getParameter("collation");
			String data_time = request.getParameter("data_time");
			if ("".equals(data_time) || data_time == null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DATE, -1);
				Date day = c.getTime();
				data_time = format.format(day);
			}
			// String data_time = "20190722";
			System.out.println(data_time + "===" + collation);
			List<Map<String, Object>> mktData = (List<Map<String, Object>>) assessmentService.getRepmktSum(data_time,
					collation);
			String mkt_campaign_id = "";
			if (mktData.size() != 0) {
				mkt_campaign_id = String.valueOf(mktData.get(0).get("MKT_CAMPAIGN_ID"));
			}
			List<Map<String, Object>> channelData = (List<Map<String, Object>>) assessmentService
					.getChannelSca(data_time, collation, mkt_campaign_id);
			retMap.put("mktData", mktData);
			retMap.put("channelData", channelData);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retMap;
	}

	@RequestMapping(value = "/getChannelData", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getChannelData(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			// String dept_id = String.valueOf(getDepTd());
			// String dept_id = "2500000000";
			String data_time = request.getParameter("data_time");
			// String data_time = "20190722";
			String collation = request.getParameter("collation");
			String mkt_id = request.getParameter("mkt_id");
			System.out.println(data_time + "===" + mkt_id);
			List<Map<String, Object>> channelData = (List<Map<String, Object>>) assessmentService
					.getChannelSca(data_time, collation, mkt_id);
			retMap.put("data", channelData);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retMap;
	}

	protected Long getDepTd() {
		IUserSession userSession = PrivilegeManager.getInstance().getUserSession();
		return userSession.getOrgId();
	}

}
