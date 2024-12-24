package com.tj_JavaEE.service;

import com.tj_JavaEE.entity.Post;
import com.tj_JavaEE.dto.AuditPostInfo;
import org.apache.ibatis.annotations.Param;
import com.tj_JavaEE.dto.CommentInfo;

import java.util.List;

public interface PostService {
    List<AuditPostInfo> auditPostInfoList();

    void postStatusChange(Long postId, String status);
    List<Post> getPostsByAuthorId(@Param("authorId") Long authorId);

    List<AuditPostInfo> getFavoritePostsByUserId(@Param("userId") Long userId);

    List<CommentInfo> getCommentsByCommenterId(Long commenterId);
}
