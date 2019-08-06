package com.ai.rti.report.entity;

import java.math.BigInteger;

/**
 * 服务事件报表显示字段
 * created by xiejialin
 */
public class CampTable {
    private String gateway_cycle;
    private BigInteger mkt_campaign_id;
    private String mkt_campaign_name;
    private String content_tpl_id;
    private String script_name;
    private String event_code;
    private String send_sms_total;
    private String gateway_succ_commit;
    private String success_send;
    private String success_send_ratio;

    public String getGateway_cycle() {
        return gateway_cycle;
    }

    public void setGateway_cycle(String gateway_cycle) {
        this.gateway_cycle = gateway_cycle;
    }

    public BigInteger getMkt_campaign_id() {
        return mkt_campaign_id;
    }

    public void setMkt_campaign_id(BigInteger mkt_campaign_id) {
        this.mkt_campaign_id = mkt_campaign_id;
    }

    public String getMkt_campaign_name() {
        return mkt_campaign_name;
    }

    public void setMkt_campaign_name(String mkt_campaign_name) {
        this.mkt_campaign_name = mkt_campaign_name;
    }

    public String getContent_tpl_id() {
        return content_tpl_id;
    }

    public void setContent_tpl_id(String content_tpl_id) {
        this.content_tpl_id = content_tpl_id;
    }

    public String getScript_name() {
        return script_name;
    }

    public void setScript_name(String script_name) {
        this.script_name = script_name;
    }

    public String getEvent_code() {
        return event_code;
    }

    public void setEvent_code(String event_code) {
        this.event_code = event_code;
    }

    public String getSend_sms_total() {
        return send_sms_total;
    }

    public void setSend_sms_total(String send_sms_total) {
        this.send_sms_total = send_sms_total;
    }

    public String getGateway_succ_commit() {
        return gateway_succ_commit;
    }

    public void setGateway_succ_commit(String gateway_succ_commit) {
        this.gateway_succ_commit = gateway_succ_commit;
    }

    public String getSuccess_send() {
        return success_send;
    }

    public void setSuccess_send(String success_send) {
        this.success_send = success_send;
    }

    public String getSuccess_send_ratio() {
        return success_send_ratio;
    }

    public void setSuccess_send_ratio(String success_send_ratio) {
        this.success_send_ratio = success_send_ratio;
    }

    @Override
    public String toString() {
        return "CampTable{" +
                "gateway_cycle='" + gateway_cycle + '\'' +
                ", mkt_campaign_id=" + mkt_campaign_id +
                ", mkt_campaign_name='" + mkt_campaign_name + '\'' +
                ", content_tpl_id='" + content_tpl_id + '\'' +
                ", script_name='" + script_name + '\'' +
                ", event_code='" + event_code + '\'' +
                ", send_sms_total='" + send_sms_total + '\'' +
                ", gateway_succ_commit='" + gateway_succ_commit + '\'' +
                ", success_send='" + success_send + '\'' +
                ", success_send_ratio='" + success_send_ratio + '\'' +
                '}';
    }
}
