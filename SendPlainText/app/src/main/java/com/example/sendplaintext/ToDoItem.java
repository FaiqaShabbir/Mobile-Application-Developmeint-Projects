package com.example.sendplaintext;

public class ToDoItem {
    public ToDoItem(String s) {
        String[] values = s.split(",");
        Title = values[0];
        Description = values[1];
        if(values[2].equals("true"))
            isCompleted = true;
        else
            isCompleted = false;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    private String Title;

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    private Boolean isCompleted;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Description;

    @Override
    public String toString() {
        return "ToDoItem{" +
                "Title='" + Title + '\'' +
                ", isCompleted=" + isCompleted +
                ", Description='" + Description + '\'' +
                '}';
    }

    public ToDoItem(){
        Title = "No Title";
        Description = "Nothing.....";
        isCompleted = false;
    }
}
