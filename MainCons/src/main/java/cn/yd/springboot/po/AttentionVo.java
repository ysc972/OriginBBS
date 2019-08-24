package cn.yd.springboot.po;

import ysu.Model.po.Attention;
import ysu.Model.po.User;

public class AttentionVo {
    private ysu.Model.po.User user;
    private ysu.Model.po.Attention attention;

    public ysu.Model.po.User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ysu.Model.po.Attention getAttention() {
        return attention;
    }

    public void setAttention(Attention attention) {
        this.attention = attention;
    }
}
