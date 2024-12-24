package com.tj_JavaEE.controller;


import com.tj_JavaEE.entity.Post;
import com.tj_JavaEE.dto.AuditPostInfo;
import com.tj_JavaEE.dto.PostId;
import com.tj_JavaEE.dto.Pst;
import com.tj_JavaEE.entity.Result;
import com.tj_JavaEE.service.PostService;
import com.tj_JavaEE.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tj_JavaEE.dto.CommentInfo;
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

<<<<<<< HEAD
    @GetMapping("/author/{authorId}")
    public List<Post> getPostsByAuthorId(@PathVariable Long authorId) {
        return postService.getPostsByAuthorId(authorId);
    }

    @GetMapping("/favorites/{userId}")
    public ResponseEntity<List<AuditPostInfo>> getFavoritePostsByUserId(@PathVariable Long userId) {
        List<AuditPostInfo> favoritePosts = postService.getFavoritePostsByUserId(userId);
        return ResponseEntity.ok(favoritePosts);
    }

    @GetMapping("/comments/{commenterId}")
    public ResponseEntity<List<CommentInfo>> getCommentsByCommenterId(@PathVariable Long commenterId) {
        List<CommentInfo> comments = postService.getCommentsByCommenterId(commenterId);
        return ResponseEntity.ok(comments);
=======
    @GetMapping("/{postId}")
    public Result getPost(@PathVariable long postId){
        Result result = Result.success(postService.getPostById(postId));
        return result;
    }


    @PostMapping
    public void createPost(@RequestBody Pst pst,@RequestHeader("Authorization") String token){
        token = token.substring(7);
        Claims claims = JwtUtils.parseJwt(token);
        int userId = claims.get("userId",Integer.class);
        pst.setAuthorId(userId);

        postService.createPost(pst);
    }

    @GetMapping
    public Result getPostList(@RequestParam String keyword){
        return Result.success(postService.search(keyword));
>>>>>>> 1dd3f0e4f0e11269eddaf56f9b219a369dc198c6
    }
}
