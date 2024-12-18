package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.mapper.PostMapper;
import com.tj_JavaEE.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceimpl implements PostService {
    @Autowired
    private PostMapper postMapper;
}
