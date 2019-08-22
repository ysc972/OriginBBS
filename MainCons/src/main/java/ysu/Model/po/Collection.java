package ysu.Model.po;

import java.util.Date;

public class Collection {
    private Integer id;

    private Integer userId;

    private Integer collectionPostId;

    private Date collectionTime;

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

    public Integer getCollectionPostId() {
        return collectionPostId;
    }

    public void setCollectionPostId(Integer collectionPostId) {
        this.collectionPostId = collectionPostId;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }
}