package com.tj_JavaEE.mapper;


import com.tj_JavaEE.dto.Cmt;
import com.tj_JavaEE.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {


    @Insert("insert into comment(comment_content,commenter_id,post_id,publish_time,like_count,dislike_count) values (#{content},#{commenterId},#{postId},#{commentTime},#{likeCount},#{dislikeCount})")
    public void addComment(Comment comment);


    @Select("select t.nickname as authorName , t.user_id as authorId , t.avatar_url as authorAvatar , f.comment_id as id, f.publish_time as releasetime, f.comment_content as content , f.like_count as likes , f.dislike_count as dislikes  from comment f inner join user t on f.commenter_id= t.user_id where f.post_id = #{ postId }")
    public List<Cmt> getCommentsByPostId(long postId);

    @Update("update comment set like_count = like_count +1 where comment_id = #{commentId}")
    public void likeComment(@Param("commentId") long commentId);

    @Update("update comment set dislike_count = dislike_count +1 where comment_id = #{commentId}")
    public void dislikeComment(@Param("commentId") long commentId);

    @Delete("delete from comment where comment_id = #{commentId}")
    public void deleteComment(@Param("commentId") long commentId);


}
