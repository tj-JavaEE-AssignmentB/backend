package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.dto.AuditPostInfo;
import com.tj_JavaEE.mapper.PostMapper;
import com.tj_JavaEE.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
