package com.example.sweater.domain.dto;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.domain.util.MessageHelper;

public class MessageDto {
    private Long id;

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", author=" + author +
                ", likes=" + likes +
                ", meLiked=" + meLiked +
                '}';
    }

    private String text;
    private String tag;
    private User author;
    private String filename;
    private Long likes;
    private Boolean meLiked;

    public String getAuthorName(){
        return MessageHelper.getAuthorName(author);
    }

    public Long getId() {
        return id;
    }

    public MessageDto(Message message, Long likes, Boolean meLiked) {
        this.id = message.getId();
        this.author = message.getAuthor();
        this.tag = message.getTag();
        this.filename = message.getFilename();
        this.text = message.getText();
        this.likes = likes;
        this.meLiked = meLiked;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public User getAuthor() {
        return author;
    }

    public String getFilename() {
        return filename;
    }

    public Long getLikes() {
        return likes;
    }

    public Boolean getMeLiked() {
        return meLiked;
    }
}
