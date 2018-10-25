package util;

import java.util.Iterator;
import java.util.List;

public class CollectionUtil {
    public static List<String> removeItem(List<String> oriList, String item) {
        for (Iterator<String> iter = oriList.listIterator(); iter.hasNext(); ) {
            String tmp = iter.next();
            if (tmp == item) {
                iter.remove();
            }
        }
        return oriList;
    }

    public static List<String> addItem(List<String> oriList, String item) {
        for (Iterator<String> iter = oriList.listIterator(); iter.hasNext(); ) {
            String tmp = iter.next();
            if (tmp == item) {
                return oriList;
            }
        }
        oriList.add(item);
        return oriList;
    }
}
