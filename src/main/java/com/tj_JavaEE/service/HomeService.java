package com.tj_JavaEE.service;

import com.tj_JavaEE.dto.pst;

import java.util.List;

public interface HomeService {
    // 获取用户喜欢的帖子类别
    List<Long> getUserLikedCategories(long userId);
    
    // 根据类别获取帖子
    List<pst> getPostsByCategories(List<Long> categories, int limit);
    
    // 获取随机帖子
    List<pst> getRandomPosts(int limit, List<Long> excludePostIds);
}
