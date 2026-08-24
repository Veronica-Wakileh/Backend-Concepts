package org.example;

public class Courses {
    private static Long id;
    private String title;
    private String description;
    private Integer capacity;

    public Courses (String title, String description, Integer capacity){

    }

    public Courses (Long id, String title, String description, Integer capacity){

    }

    public static Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        if (capacity > 0)
            this.capacity = capacity;
        else System.out.println("Insert a Capacity Greater than Zero");
    }

    @Override
    public String toString() {
        return "Courses{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
