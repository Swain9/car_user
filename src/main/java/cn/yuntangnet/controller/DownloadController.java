package cn.yuntangnet.controller;

import cn.yuntangnet.exception.RtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 张茂林
 * @since 2017/12/30 11:57
 */
@Controller
public class DownloadController {

    @RequestMapping("/download/moban")
    public ResponseEntity<byte[]> downloadResource(HttpServletRequest request, HttpServletResponse response) {

        String download = "/home/pro/download/";

        Path file = Paths.get(download, "1.xls");
        if (Files.exists(file)) {
            //String fileName = "sunny.pdf";
            //response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            //如果文件名有中文的话，进行URL编码，让中文正常显示
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", new String("模板.xls".getBytes("UTF-8"), "ISO-8859-1"));
                return new ResponseEntity<byte[]>(Files.readAllBytes(file), headers, HttpStatus.OK);
            } catch (IOException ex) {
                throw new RtException("文件下载失败");
            }
        }
        return null;
    }
}
