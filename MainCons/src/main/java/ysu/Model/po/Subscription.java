package ysu.Model.po;

import java.util.Date;

public class Subscription {
    private Integer id;

    private Integer userId;

    private Integer sectionId;

    private Date subscriptionTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Date getSubscriptionTime() {
        return subscriptionTime;
    }

    public void setSubscriptionTime(Date subscriptionTime) {
        this.subscriptionTime = subscriptionTime;
    }
}