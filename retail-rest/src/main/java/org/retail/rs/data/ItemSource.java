package org.retail.rs.data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author the-ramones
 */
public class ItemSource {

    Map<Long, Item> source;

    private ItemSource() {
        source = new HashMap<Long, Item>();
        source.put(1L, new Item(1L, "iPhone"));
        source.put(2L, new Item(2L, "Nokia"));
        source.put(3L, new Item(3L, "Samsung"));
        source.put(4L, new Item(4L, "HTC"));
        source.put(5L, new Item(5L, "Motorolla"));
        source.put(6L, new Item(6L, "Blackberry"));
    }

    public static ItemSource getInstance() {
        return ItemSourceHolder.INSTANCE;
    }

    private static class ItemSourceHolder {

        private static final ItemSource INSTANCE = new ItemSource();
    }
    
    public void addItem(Item item) {
        source.put(item.getId(), item);
    }
    
    public Item getItem(Long id) {
        return source.get(id);
    }
}
