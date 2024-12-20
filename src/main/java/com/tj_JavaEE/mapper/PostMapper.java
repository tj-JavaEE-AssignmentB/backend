package com.tj_JavaEE.mapper;

import com.tj_JavaEE.dto.AuditPostInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select p.post_id as postId, p.post_title as postTitle, c.category_name as categoryName, p.publish_time as publishTime, p.post_content as postContent, p.author_id as authorId, u.nickname as authorName from post p inner join category c on p.category_id = c.category_id inner join user u on p.author_id = u.user_id where p.status = 'pending'")
    List<AuditPostInfo> auditPostInfoList();

    @Update("UPDATE post SET status = #{status} WHERE post_id = #{postId}")
    void postStatusChange(@Param("postId") Long postId, @Param("status") String status);
}
