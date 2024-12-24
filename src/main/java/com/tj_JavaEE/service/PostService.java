package com.tj_JavaEE.service;

import com.tj_JavaEE.dto.AuditPostInfo;
import com.tj_JavaEE.dto.pst;

import java.util.List;

public interface PostService {
    List<AuditPostInfo> auditPostInfoList();

    void postStatusChange(Long postId, String status);

    pst getPostById(Long postId);

}
