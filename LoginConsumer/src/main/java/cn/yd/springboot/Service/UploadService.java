package cn.yd.springboot.Service;


import cn.yd.springboot.po.User;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "LoginProvider", configuration = UploadService.MultipartSupportConfig.class)
@Service
public interface UploadService {
    @PostMapping(value = "/privde_update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String  update(@RequestParam("userJSON") String userJSON, @RequestPart(value = "file") MultipartFile file);

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public SpringFormEncoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
