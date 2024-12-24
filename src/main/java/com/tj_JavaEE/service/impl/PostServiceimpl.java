package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.entity.Post;
import com.tj_JavaEE.dto.AuditPostInfo;
import com.tj_JavaEE.mapper.PostMapper;
import com.tj_JavaEE.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tj_JavaEE.dto.CommentInfo;

import java.util.List;

@Service
public class PostServiceimpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<AuditPostInfo> auditPostInfoList() {
        return postMapper.auditPostInfoList();
    }

    @Override
    public void postStatusChange(Long postId, String status) {
        postMapper.postStatusChange(postId,status);
    }

    @Override
    public List<Post> getPostsByAuthorId(Long authorId) {
        return postMapper.selectPostsByAuthorId(authorId);
    }

    @Override
    public List<AuditPostInfo> getFavoritePostsByUserId(Long userId) {
        return postMapper.selectFavoritePostsByUserId(userId);
    }


    @Override
    public List<CommentInfo> getCommentsByCommenterId(Long commenterId) {
        return postMapper.selectCommentsByCommenterId(commenterId);
    }
}
