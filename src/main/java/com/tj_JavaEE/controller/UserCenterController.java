package com.tj_JavaEE.controller;

import com.tj_JavaEE.entity.User;
import com.tj_JavaEE.service.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userCenter")
public class UserCenterController {

    @Autowired
    private UserCenterService userCenterService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userCenterService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Integer userId, @RequestBody User user) {
        // 校验用户 ID
        if (user.getUserId() == null || !user.getUserId().equals(userId)) {
            return ResponseEntity.badRequest().body("Invalid user ID");
        }

        try {
            // 调用服务层方法更新用户信息
            userCenterService.updateUser(user);
            return ResponseEntity.ok("User information updated successfully");
        } catch (Exception e) {
            // 捕获服务层抛出的异常
            return ResponseEntity.status(400).body("Operation failed: " + e.getMessage());
        }
    }

    @PostMapping("/avatar")
    public ResponseEntity<String> uploadAvatar(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("文件为空");
        }
        if (!Arrays.asList("image/jpeg", "image/png").contains(file.getContentType())) {
            return ResponseEntity.badRequest().body("不允许的文件类型");
        }
        if (file.getSize() > 1024 * 1024 * 5) { // 5MB
            return ResponseEntity.badRequest().body("文件大小超过限制");
        }
        String filePath = saveFile(file);
        return ResponseEntity.ok(filePath);
    }

    private String saveFile(MultipartFile file) {
        String fileName = UUID.randomUUID().toString() + "." + getExtension(file.getOriginalFilename());
        String uploadPath = "/opt/uploads/";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        try {
            file.transferTo(new File(uploadPath + fileName));
        } catch (IOException e) {
            throw new RuntimeException("上传文件失败", e);
        }
        String fileUrl = "http://example.com/uploads/" + fileName;
        return fileUrl;
    }

    private String getExtension(String filename) {
        if (filename == null) {
            return "tmp";
        }
        int dotIndex = filename.lastIndexOf(".");
        if (dotIndex == -1) {
            return "tmp";
        }
        return filename.substring(dotIndex + 1);
    }
}
