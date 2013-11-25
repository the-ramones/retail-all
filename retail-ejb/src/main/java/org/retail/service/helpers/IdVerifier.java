package org.retail.service.helpers;

/**
 *
 * @author the-ramones
 */
public class IdVerifier {

    public IdVerifier() {
    }

    public boolean validate(String id) {
        try {
            Integer intId = Integer.parseInt(id);
            if (intId.compareTo(0) < 0 && intId.compareTo(99999) > 0) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
