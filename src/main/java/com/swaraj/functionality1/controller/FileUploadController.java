package com.swaraj.functionality1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    @GetMapping("/home")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    //@Hidden
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        Path path = Paths.get("C://Users//LENOVO//Desktop//" + file.getOriginalFilename());
        Files.write(path, file.getBytes());
        model.addAttribute("message", "File has been uploaded successfully");
        return "upload";
    }

}
