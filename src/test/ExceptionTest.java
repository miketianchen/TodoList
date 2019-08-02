import model.GeneralList;
import model.TodoList;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.fail;

public class ExceptionTest {
    GeneralList list;

    @Before
    public void setUp(){
        list = new TodoList();
    }

    @Test
    public void testPromptForNonExistentSavedFile(){
        try {
            list.load("randomfile");
            fail("TEST FAILS");
        } catch (FileNotFoundException e) {
            // NOT CAUGHT
        }
    }

    @Test
    public void testPromptForExistentSavedFiled(){
        try{
            list.load("todolist");
        } catch (FileNotFoundException e) {
            fail("TEST FAILS");
        }
    }
}
