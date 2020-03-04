package ru.kpfu.itis.demo.web.controller;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.dummycreator.DummyCreator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpCookie;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.demo.web.dto.PostDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/mvc")
public class MvcController {

    @InitBinder
    public void binder(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @GetMapping("/date")
    public Date date(@RequestParam Date time){
        return time;
    }

    @GetMapping("/resp")
    public void resp(HttpServletResponse response, HttpServletRequest request, Cookie cookie){
    }

    @GetMapping("/dto")
    public PostDto postDto(){
        return new DummyCreator().create(PostDto.class);
    }

    @PostMapping("/file")
    public void file(MultipartFile file) throws IOException {
        IOUtils.copyLarge(
                file.getInputStream(),
                new FileOutputStream(Paths.get("./data/file").toFile())
        );
    }

    @GetMapping("/auth")
    public String hello(HttpServletRequest request){
        return "Hello " + request.getParameter("user");
    }

    @PostMapping("/token")
    public String auth(String username, String pass){
        return Base64.encodeBase64String(("username:" + DigestUtils.md5Hex(username + ":" + pass + ":" + "salt")).getBytes());
    }
}
