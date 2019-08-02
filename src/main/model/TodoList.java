package model;

public class TodoList extends GeneralList {


    public TodoList(){
    }

    public void removeItem(Todo item) {
        if (todoList.contains(item)) {
            int index = todoList.indexOf(item);
            todoList.remove(index);
        }
    }

    @Override
    public void extractInfo(ListItem item) {
        String posting = item.getPosting();
    }

    @Override
    public void showPostings() {
        for (ListItem item : todoList) {
            System.out.println("=== " + item.getPosting() + "\n");
        }
    }


}
