package com.tj_JavaEE.service;

import com.tj_JavaEE.entity.Post;
import com.tj_JavaEE.dto.AuditPostInfo;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;
import com.tj_JavaEE.dto.CommentInfo;
=======
import com.tj_JavaEE.dto.Pst;
>>>>>>> 1dd3f0e4f0e11269eddaf56f9b219a369dc198c6

import java.util.List;

public interface PostService {
    List<AuditPostInfo> auditPostInfoList();

    void postStatusChange(Long postId, String status);
<<<<<<< HEAD
    List<Post> getPostsByAuthorId(@Param("authorId") Long authorId);

    List<AuditPostInfo> getFavoritePostsByUserId(@Param("userId") Long userId);

    List<CommentInfo> getCommentsByCommenterId(Long commenterId);
=======

    Pst getPostById(Long postId);

    void createPost(Pst pst);


    List<Pst> search(String keyword);


>>>>>>> 1dd3f0e4f0e11269eddaf56f9b219a369dc198c6
}
