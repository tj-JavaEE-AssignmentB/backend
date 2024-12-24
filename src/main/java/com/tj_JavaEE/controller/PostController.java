package com.tj_JavaEE.controller;

import com.tj_JavaEE.dto.AuditPostInfo;
import com.tj_JavaEE.dto.PostId;
import com.tj_JavaEE.entity.Result;
import com.tj_JavaEE.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/auditPostInfo")
    public ResponseEntity<List<AuditPostInfo>> auditPostInfoList(){
        System.out.println("auditPostInfo");
        return ResponseEntity.ok(postService.auditPostInfoList());
    }

    @PostMapping("/postPass")
    public ResponseEntity<Boolean> postPass(@RequestBody PostId postId){
        System.out.println("postPass");
        postService.postStatusChange(postId.getPostId(),"reviewed");
        return ResponseEntity.ok(true);
    }

    @PostMapping("/postRefund")
    public ResponseEntity<Boolean> postRefund(@RequestBody PostId postId){
        System.out.println("postRefund");
        postService.postStatusChange(postId.getPostId(),"refunded");
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{postId}")
    public Result getPost(@PathVariable long postId){
        Result result = Result.success(postService.getPostById(postId));
        return result;
    }
}
