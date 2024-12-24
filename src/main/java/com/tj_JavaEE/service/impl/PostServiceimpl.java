package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.dto.AuditPostInfo;
import com.tj_JavaEE.dto.Pst;
import com.tj_JavaEE.mapper.PostMapper;
import com.tj_JavaEE.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    }

    @Override
    public void likePost(int userId, Long postId){
        int categoryId=postMapper.searchCategory(postId);

        postMapper.likePost(userId);
        postMapper.addlike(userId,categoryId);

    }

    @Override
    public void reportPost(Long postId,int userId){
        String rr="违规";
        Date dt=new Date();
        String date=dt.toString();


        postMapper.reportPost(postId,userId,rr,date);

    }

    @Override
    public void deletePost(Long postId){
        postMapper.deletePost(postId);
    }
}
