package Model;

import java.io.FileNotFoundException;
import java.util.List;

public interface Loadable {
    List<Todo> load(String listName) throws FileNotFoundException;
}
