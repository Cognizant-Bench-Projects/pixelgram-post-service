package com.cognizant.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String description;

    @NotNull
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "user_like_post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userThatLikes;

    @NotNull
    private String date;

    @OneToMany
    private List<Comment> comments;

    @Transient
    private int numberOfComments;

    @Transient
    private int likes;

    public Post() {
    }

    public Post(int id, String description, String imageUrl, User user, List<User> userThatLikes, String date, List<Comment> comments) {
        this.id = id;
        this.description = description;
        this.imageUrl = imageUrl;
        this.user = user;
        this.userThatLikes = userThatLikes;
        this.date = date;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<User> getUserThatLikes() {
        return userThatLikes;
    }

    public void setUserThatLikes(List<User> userThatLikes) {
        this.userThatLikes = userThatLikes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", user=" + user +
                ", userThatLikes=" + userThatLikes +
                ", date='" + date + '\'' +
                ", comments=" + comments +
                ", numberOfComments=" + numberOfComments +
                ", likes=" + likes +
                '}';
    }
}
