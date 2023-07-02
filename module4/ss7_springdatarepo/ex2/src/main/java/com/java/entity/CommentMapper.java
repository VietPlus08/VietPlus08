package com.java.entity;

public class CommentMapper {
    public CommentDto toCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setFeedback(comment.getFeedback());
        commentDto.setMark(comment.getMark());
        return commentDto;
    }
}
