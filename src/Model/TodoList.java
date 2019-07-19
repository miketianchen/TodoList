package Model;

public class TodoList extends GeneralList{


    public TodoList(){
    }


    @Override
    public void extractInfo(Todo item) {
        String posting = item.getTodoPosting();
    }




}
