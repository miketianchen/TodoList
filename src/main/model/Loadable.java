package model;

import java.io.FileNotFoundException;
import java.util.List;

public interface Loadable {
    List<ListItem> load(String listName) throws FileNotFoundException;
}
