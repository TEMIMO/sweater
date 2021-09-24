package com.example.sweater.domain;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

// Пакет домен для того, чтобы не искать сущности по всему исходному коду

@Entity // Сущность, которую нам необходимо сохранять в базе данных
@Table(name ="MESSAGE", schema = "PUBLIC")
public class Message {
    @Id // Создаем первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native") // Чтобы идентификаторы генерировались
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @NotBlank(message = "Please fill the message")
    @Length(max = 255, message = "Message too long")
    private String text;
    @Length(max = 255, message = "Tag too long")
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER) // Устанавливаем для каждого сообщения одного автора
    @JoinColumn(name = "user_id") // В базе данных author будет указан как user_id
    private User author;

    private String filename;

    public Message(){
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public String getAuthorName(){      // Чтобы взять имя автора, main.ftlh обращается именно сюда
        return author != null ? author.getUsername() : "<none>" ;
    }
    // До этого добавляли без автора, поэтому чтобы не было ошибок, будем проверять

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
