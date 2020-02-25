package com.team3.board.model;

import com.team3.user.model.UserDTO;

import java.sql.Timestamp;

public class BoardDTO {
    private long id;
    private String title;
    private String content;
    private String user_id;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    private int category; //카테고리
    private int groups; //게시글 그룹
    private int depth; //계층형 게시글 깊이
    private int sort; //게시글 순서
    private int hit; //조회수

    public BoardDTO() {}

    public BoardDTO(long id, String title, String content, String user_id, Timestamp createdTime, Timestamp updatedTime, int category, int groups, int depth, int sort, int hit) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;

        this.category = category;
        this.groups = groups;
        this.depth = depth;
        this.sort = sort;

        this.hit = hit;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getGroups() {
        return groups;
    }

    public void setGroups(int groups) {
        this.groups = groups;
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

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user_id=" + user_id + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", category=" + category +
                ", groups=" + groups +
                ", depth=" + depth +
                ", sort=" + sort +
                ", hit=" + hit +
                '}';
    }
}





















