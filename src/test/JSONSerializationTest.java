import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.TodoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONSerializationTest {
    TodoItem t1;
    TodoItem t2;
    TodoItem t3;
    TodoItem t4;

    List<TodoItem> todoList;

    Map<String, List<TodoItem>> todoMap;

    @BeforeEach
    public void setup() {
        t1 = new TodoItem("todo - 1", "Aug-15-2019");
        t2 = new TodoItem("todo - 2", "Aug-16-2019");
        t3 = new TodoItem("todo - 3", "Aug-17-2019");
        t4 = new TodoItem("todo - 4", "Aug-18-2019");

        todoList = new ArrayList<>();

        todoList.add(t1);
        todoList.add(t2);
        todoList.add(t3);
        todoList.add(t4);

        todoMap = new HashMap<>();

        todoMap.put("test", todoList);
    }

    @Test
    public void testSerializatiion() {
        Gson gson = new Gson();
//        String jsonString = gson.toJson(todoList);
//        System.out.println(jsonString);
        Type listType = new TypeToken<ArrayList<TodoItem>>() { }.getType();
        String json = gson.toJson(todoList, listType);
//        System.out.println(json);

        // Test Serialization with Type MAP
        Type mapType = new TypeToken<Map<String,ArrayList<TodoItem>>>() { }.getType();
        String jsonMap = gson.toJson(todoMap,mapType);
        System.out.println(jsonMap);

    }

}
