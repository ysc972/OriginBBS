package ysu.application.po;

public class Viewlike {
    private Integer id;

    private Integer userId;

    private Integer postId;

    private Integer isLike;

    private Integer isDislike;

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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public Integer getIsDislike() {
        return isDislike;
    }

    public void setIsDislike(Integer isDislike) {
        this.isDislike = isDislike;
    }
}