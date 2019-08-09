import model.TodoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TodoItemTest {

    TodoItem todoItem;

    @BeforeEach
    public void setUp() {
        todoItem = new TodoItem("Dummy Text", "08-15-2019");
    }

    @Test
    public void testSetters() {
        String textString = "New Text";
        todoItem.setTodoPosting(textString);
        assertEquals(true, todoItem.getTodoPosting().equals(textString));

        String newDueDate = "Today";
        todoItem.setDueDate(newDueDate);
        assertEquals(true, todoItem.getDueDate().equals(newDueDate));
    }

    @Test
    public void testGetters() {
        String differentText = "New Text";
        assertFalse(differentText.equals(todoItem.getTodoPosting()));

        String differentDate = "Today";
        assertFalse(differentDate.equals(todoItem.getDueDate()));
    }


}
