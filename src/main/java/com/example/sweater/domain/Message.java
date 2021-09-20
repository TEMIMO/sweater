package com.example.sweater.domain;

import javax.persistence.*;

// Пакет домен для того, чтобы не искать сущности по всему исходному коду

@Entity // Сущность, которую нам необходимо сохранять в базе данных
public class Message {
    @Id // Создаем первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO) // Чтобы идентификаторы генерировались
    private Integer id;

    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER) // Устанавливаем для каждого сообщения одного автора
    @JoinColumn(name = "user_id") // В базе данных author будет указан как user_id
    private User author;

    public Message(){
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public String getAuthorName(){      // Чтобы взять имя автора, main.mustache обращается именно сюда
        return author != null ? author.getUsername() : "<none>" ;
    }
    // До этого добавляли без автора, поэтому чтобы не было ошибок, будем проверять

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
