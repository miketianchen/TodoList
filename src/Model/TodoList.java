package Model;

public class TodoList extends GeneralList{


    public TodoList(){
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
