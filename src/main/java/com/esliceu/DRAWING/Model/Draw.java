package com.esliceu.DRAWING.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class Draw {
    private int id;
    private String name;
    private User user;

    private String shapesJSON;

    private LocalDateTime creationDate;

    private Date lastModificationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getShapesJSON() {
        return shapesJSON;
    }

    public void setShapesJSON(String shapesJSON) {
        this.shapesJSON = shapesJSON;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }
}
