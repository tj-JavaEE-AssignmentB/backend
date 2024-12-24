package com.tj_JavaEE.mapper;


import com.tj_JavaEE.dto.pst;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeMapper {


    @Select("select distinct p.category_id FROM user_preference p where p.user_id= ${userId}")
    public List<Long> getUserLike(@Param("userId") Long userId);


    @Select("select t.post_id as id , t.post_title as title , t.post_content as content , t.author_id as authorId , t.publish_time as createTime , t.like_count as likes , t.dislike_count as dislikes , u.nickname as authorName ,u.avatar_url as authorAvatar from post t inner join user u on t.author_id = u.user_id where t.category_id in #{categories} order by t.publish_time Desc #{limit} ")
    public List<pst> getPostsByCategories(@Param("categories")List<Long> categories,@Param("limit")int limit);


    @Select("select t.post_id as id , t.post_title as title , t.post_content as content , t.author_id as authorId , t.publish_time as createTime , t.like_count as likes , t.dislike_count as dislikes , u.nickname as authorName ,u.avatar_url as authorAvatar from post t inner join user u on t.author_id = u.user_id ORDER by rand() #{limit} ")
    public List<pst> getRandomPosts(@Param("limit")int limit);
}
