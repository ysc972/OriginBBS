package cn.yd.springboot.po;

import org.springframework.web.multipart.MultipartFile;

public class UserVo {
    private User user;
    private MultipartFile file;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
