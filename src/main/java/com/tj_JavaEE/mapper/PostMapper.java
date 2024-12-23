package com.tj_JavaEE.mapper;

import com.tj_JavaEE.entity.Post;
import com.tj_JavaEE.dto.AuditPostInfo;
import com.tj_JavaEE.dto.CommentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.tj_JavaEE.dto.Pst;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select p.post_id as postId, p.post_title as postTitle, c.category_name as categoryName, p.publish_time as publishTime, p.post_content as postContent, p.author_id as authorId, u.nickname as authorName from post p inner join category c on p.category_id = c.category_id inner join user u on p.author_id = u.user_id where p.status = 'pending'")
    List<AuditPostInfo> auditPostInfoList();

    @Update("UPDATE post SET status = #{status} WHERE post_id = #{postId}")
    void postStatusChange(@Param("postId") Long postId, @Param("status") String status);

    @Select("select f.post_id as id , f.post_title as title , f.post_content as content , f.author_id as authorId , f.like_count as likes , f.dislike_count as dislikes , t.avatar_url as authorAvatar , t.nickname as authorName  from post f inner join user t on t.user_id=f.author_id where f.post_id = #{postId} and t.status='actice'")
    @Select("SELECT post_id AS postId, post_title AS postTitle, category_id AS categoryId, publish_time AS publishTime, post_content AS postContent, author_id AS authorId, like_count AS likeCount, dislike_count AS dislikeCount, status FROM post WHERE author_id = #{authorId}")
    List<Post> selectPostsByAuthorId(@Param("authorId") long authorId);

    @Select("SELECT p.post_id AS postId, p.post_title AS postTitle, c.category_name AS categoryName, " +
            "p.publish_time AS publishTime, p.post_content AS postContent, p.author_id AS authorId, " +
            "u.nickname AS authorName FROM post p " +
            "INNER JOIN category c ON p.category_id = c.category_id " +
            "INNER JOIN user u ON p.author_id = u.user_id " +
            "INNER JOIN user_favorite uf ON p.post_id = uf.favorite_post_id " +
            "WHERE uf.user_id = #{userId}")
    List<AuditPostInfo> selectFavoritePostsByUserId(@Param("userId") long userId);

    @Select("SELECT c.comment_id AS commentId, c.comment_content AS commentContent, c.commenter_id AS commenterId, p.post_id AS postId, p.post_title AS postTitle, c.publish_time AS commentTime " +
            "FROM comment c " +
            "INNER JOIN post p ON c.post_id = p.post_id " +
            "WHERE c.commenter_id = #{commenterId}")
    List<CommentInfo> selectCommentsByCommenterId(@Param("commenterId") long commenterId);

    @Select("select f.post_id as id , f.post_title as title , f.post_content as content , f.author_id as authorId , f.like_count as likes , f.dislike_count as dislikes , t.avatar_url as authorAvatar , t.nickname as authorName  from post f full outer join user t where f.post_id = #{postId} and t.status='actice'")
    Pst getPst(@Param("postId") Long postId);


    @Insert("insert into post(post_title,post_content,author_id,publish_time,like_count,dislike_count,category_id) values(#{title},#{content},#{authorId},#{releaseTime},#{likes},#{dislikes},#{categoryId})")
    void createPost(Pst pst);
}
