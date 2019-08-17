package ysu.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class hello {
    @GetMapping("/getUser")
    public String getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        username = "cc";
        session.setAttribute("username", username);
        session.setAttribute("password","123");
        session.setAttribute("Address","Tianjin");

        System.out.println("访问端口：" + request.getServerPort());
        return username;
    }

}
