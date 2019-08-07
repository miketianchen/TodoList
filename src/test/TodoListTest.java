import model.TodoItem;
import model.TodoList;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TodoListTest {

    TodoList todoList;
    List<TodoItem> list;

    @Before
    public void setup() {
        list = new ArrayList<>();

        TodoItem t1 = new TodoItem("1");
        TodoItem t2 = new TodoItem("2");
        TodoItem t3 = new TodoItem("3");
        TodoItem t4 = new TodoItem("4");

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

        todoList = new TodoList("New TodoList", list);
    }

    public void testGetterAndSetter() {
        String newName = "NEW NAME";
        todoList.setName(newName);
        assertTrue(todoList.getName().equals(newName));
    }

    public void testAddToList() {
        TodoItem newTodoItem = new TodoItem("New Todo");
    }
}
