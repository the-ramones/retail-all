package org.retail.rs.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author the-ramones
 */
public class PriceSource {

    Map<Long, Price> source;

    private PriceSource() {
        ItemSource itemSource = ItemSource.getInstance();
        source = new HashMap();
        source.put(1L, new Price(1L, BigDecimal.valueOf(500), itemSource.getItem(1L), new Date()));
        source.put(2L, new Price(2L, BigDecimal.valueOf(200), itemSource.getItem(2L), new Date()));
        source.put(3L, new Price(3L, BigDecimal.valueOf(300), itemSource.getItem(3L), new Date()));
        source.put(4L, new Price(4L, BigDecimal.valueOf(400), itemSource.getItem(4L), new Date()));
        source.put(5L, new Price(5L, BigDecimal.valueOf(100), itemSource.getItem(5L), new Date()));
        source.put(6L, new Price(6L, BigDecimal.valueOf(50), itemSource.getItem(6L), new Date()));
    }

    public static PriceSource getInstance() {
        return PriceSourceHolder.INSTANCE;
    }

    private static class PriceSourceHolder {

        private static final PriceSource INSTANCE = new PriceSource();
    }

    public Price getPrice(Long id) {
        return source.get(id);
    }

    public void setPrice(Price price) {
        source.put(price.getId(), price);
    }

    public void deletePrice(Long id) {
        source.remove(id);
    }

    public Price getPriceByItem(Item item) {
        Price result = null;
        for (Long id : source.keySet()) {
            if (source.get(id).getItem().equals(item)) {
                result = source.get(id);
            }
        }
        return result;
    }
}
