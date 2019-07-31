package Model;

public class TodoList extends GeneralList{


    public TodoList(){
    }

    public void removeItem(Todo item){
        if(todoList.contains(item)){
            int index = todoList.indexOf(item);
            todoList.remove(index);
        }
    }

    @Override
    public void extractInfo(Todo item) {
        String posting = item.getTodoPosting();
    }

    @Override
    public void showPostings() {
        for(Todo item : todoList){
            System.out.println(item.getTodoPosting() + "\n");
        }
    }


}
