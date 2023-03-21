package seedu.address.model.comparator;

import java.util.Comparator;
import seedu.address.model.listing.Listing;

/**
 * Compares listing according to the title to sort them alphabetically.
 */
public class ListingDescriptionComparator implements Comparator<Listing> {
    @Override
    public int compare(Listing o1, Listing o2) {
        return o1.getDescription().fullDescription.compareTo(o2.getDescription().fullDescription);
    }
}
