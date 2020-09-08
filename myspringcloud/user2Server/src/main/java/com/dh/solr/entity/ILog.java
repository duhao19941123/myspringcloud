package com.dh.solr.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ILog {

    private Long LogId ;

    private String content;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss" , timezone = "GMT+8")
    private LocalDateTime createTime ;

    public Long getLogId() {
        return LogId;
    }

    public void setLogId(Long logId) {
        LogId = logId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
