package com.tj_JavaEE.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class pst {
    private int id;
    private String title;
    private String content;
    private int authorId;
    private String authorName;
    private String authorAvatar;
    private String createTime;
    private int likes;
    private int dislikes;
}
