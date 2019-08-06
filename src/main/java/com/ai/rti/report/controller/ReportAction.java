/**
 * 
 */
package com.ai.rti.report.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.rti.report.entity.CampTable;
import com.ai.rti.report.service.ReportService;

@Controller
@RequestMapping("/report")
@CrossOrigin
public class ReportAction {

	@Autowired
	private ReportService reportService;

	/**
	 * 服务事件报表 created by xjejialin
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCampDataList", produces = "application/json;charset=utf-8", method = {
			RequestMethod.POST, RequestMethod.GET })
	public List<CampTable> getCampDataList(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		String begin_time = request.getParameter("begin_time");
		String end_time = request.getParameter("end_time");
		String mkt_campaign_name = request.getParameter("mkt_campaign_name");
		String script_name = request.getParameter("script_name");

		if (begin_time != null) {
			begin_time = begin_time.length() == 0 ? null : begin_time;
		}
		if(end_time != null) {
			end_time = end_time.length() == 0 ? null : end_time;
		}
		mkt_campaign_name = mkt_campaign_name.length() == 0 ? null : mkt_campaign_name;
		script_name = script_name.length() == 0 ? null : script_name;

		List<CampTable> list = reportService.getCampDataList(begin_time, end_time, mkt_campaign_name, script_name);

		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/exportToExcel", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String exportToExcel(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<CampTable> campDataList = getCampDataList(request, response);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("营服报表");

		String[] headers = { "账期", "服务场景ID", "服务场景名称", "短信模板ID", "短信模板名称", "事件编码", "发送短信数", "提交网关数", "发送成功数", "触达率" };
		HSSFRow row = sheet.createRow(0);
		HSSFCell[] cellArr = new HSSFCell[headers.length];
		for (int i = 0; i < headers.length; i++) {
			cellArr[i] = row.createCell(i);
			cellArr[i].setCellValue(headers[i]);
		}
		int rowNum = 1;
		for (CampTable campTable : campDataList) {
			HSSFRow row1 = sheet.createRow(rowNum);
			row1.createCell(0).setCellValue(campTable.getGateway_cycle());
			row1.createCell(1).setCellValue(campTable.getMkt_campaign_id().toString());
			row1.createCell(2).setCellValue(campTable.getMkt_campaign_name());
			row1.createCell(3).setCellValue(campTable.getContent_tpl_id());
			row1.createCell(4).setCellValue(campTable.getScript_name());
			row1.createCell(5).setCellValue(campTable.getEvent_code());
			row1.createCell(6).setCellValue(campTable.getSend_sms_total());
			row1.createCell(7).setCellValue(campTable.getGateway_succ_commit());
			row1.createCell(8).setCellValue(campTable.getSuccess_send());
			row1.createCell(9).setCellValue(campTable.getSuccess_send_ratio());
			rowNum++;
		}

		response.reset();
		response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("camp_report.xlsx", "utf-8"));
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		ServletOutputStream outputStream = response.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		bufferedOutputStream.flush();
		workbook.write(bufferedOutputStream);
		bufferedOutputStream.close();

		return "Excel导出成功！";
	}

}
