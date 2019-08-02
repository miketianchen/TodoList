//import model.TodoList;
//import model.Todo;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class TodoListTestFeature {
//    TodoList todoList;
//
//    @Before
//    public void setup(){
//        todoList = new TodoList();
//    }
//
//
//    @Test
//    public void testFileWriter(){
//        String testString1 = "hello";
//        String testString2 = "goodbye";
//        String testString3 = "peace";
//
//        Todo todo1 = new Todo(testString1);
//        Todo todo2 = new Todo(testString2);
//        Todo todo3 = new Todo(testString3);
//
//        List<Todo> todos = new ArrayList<>();
//        todos.add(todo1);
//        todos.add(todo2);
//        todos.add(todo3);
//
//        todoList.save(todos);
//
//        List<Todo> newTodos = new ArrayList<>();
//        newTodos = todoList.load();
//
//        assertEquals(newTodos.get(0).getTodoPosting(), testString1);
//        assertEquals(newTodos.get(1).getTodoPosting(), testString2);
//        assertEquals(newTodos.get(2).getTodoPosting(), testString3);
//    }
//
//}
