import Model.Todo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TodoListTest {
    Todo to;

    @Before
    public void setup(){
        to = new Todo("Dummy Text");
    }

    // Test to ensure setter works
    @Test
    public void testSetTodoPosting(){
        String textString = "New Text";
        to.setTodoPosting(textString);
        assertEquals(true, to.getTodoPosting().equals(textString));
    }



}
