package com.example.home_task_2;

public class ToDoItem {
    public ToDoItem(int id, String title, String desc, boolean completed){
        ID= id;
        Title = title;
        Description = desc;
        isCompleted = completed;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;
    private Boolean isCompleted;
    private String Title;
    private String Description;

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



        public Boolean getCompleted() {
            return isCompleted;
        }

        public void setCompleted(Boolean completed) {
            isCompleted = completed;
        }



        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }



        @Override
        public String toString() {
            return Title + "," + Description + "," + isCompleted;
        }

        public ToDoItem(){
            ID = 0;
            Title = "No Title";
            Description = "Nothing.....";
            isCompleted = false;
        }
}
