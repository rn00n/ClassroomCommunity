package com.team3.board.model;

import com.team3.user.model.UserDTO;

import java.time.LocalDateTime;

public class BoardDTO {
    private long id;
    private String title;
    private String content;
    private UserDTO user;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private int category; //카테고리
    private int group; //게시글 그룹
    private int depth; //계층형 게시글 깊이
    private int sort; //게시글 순서

    public BoardDTO() {}

    public BoardDTO(long id, String title, String content, UserDTO user, LocalDateTime createdTime, LocalDateTime updatedTime, int category, int group, int depth, int sort) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.category = category;
        this.group = group;
        this.depth = depth;
        this.sort = sort;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", category=" + category +
                ", group=" + group +
                ", depth=" + depth +
                ", sort=" + sort +
                '}';
    }
}
