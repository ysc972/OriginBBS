package ysu.Model.po;

import java.util.Date;

public class Message {
    private Integer id;

    private Integer sendUserId;

    private Integer reciveUserId;

    private String content;

    private Date creatTime;

    private Integer isRead;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getReciveUserId() {
        return reciveUserId;
    }

    public void setReciveUserId(Integer reciveUserId) {
        this.reciveUserId = reciveUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}