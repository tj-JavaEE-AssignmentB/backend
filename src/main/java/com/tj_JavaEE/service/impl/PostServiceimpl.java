package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.entity.Post;
import com.tj_JavaEE.dto.AuditPostInfo;
import com.tj_JavaEE.dto.Pst;
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
    @Autowired
    private SearchServiceimpl searchServiceimpl;

    @Override
    public List<AuditPostInfo> auditPostInfoList() {
        return postMapper.auditPostInfoList();
    }

    @Override
    public void postStatusChange(Long postId, String status) {
        postMapper.postStatusChange(postId,status);
    }

    @Override
<<<<<<< HEAD
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
=======
    public Pst getPostById(Long postId) { return postMapper.getPst(postId); }

    @Override
    public void createPost(Pst pst) {
        String userName = searchServiceimpl.searchUserName(pst.getAuthorId());
        pst.setAuthorName(userName);
        pst.setDislikes(0);
        pst.setLikes(0);
        pst.setAuthorAvatar(searchServiceimpl.searchUserAvatar(pst.getAuthorId()));
        postMapper.createPost(pst);

        

    }

    @Override
    public List<Pst> search(String keyword)
    {
        return searchServiceimpl.search(keyword);
>>>>>>> 1dd3f0e4f0e11269eddaf56f9b219a369dc198c6
    }
}
