package seedu.address.model.listing;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Listing's title in GoodMatch.
 * Guarantees: immutable; is valid as declared in {@link #isValidTitle(String)}
 */
public class JobTitle {

    public static final String MESSAGE_CONSTRAINTS =
            "Titles should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * Validation regex
     */
    public static final String VALIDATION_DISALLOWED_CHARACTERS = ".*[\\n\\r\\f].*";
    public static final String VALIDATION_ALL_CAPS = "^[A-Z]*$";
    public static final String VALIDATION_CONSEC_SPECIAL_CHARACTERS = ".*[!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]{4,}.*";
    public static final String VALIDATION_ALL_NON_ALPHANUM = "^[^a-zA-Z0-9]*$";
    public static final int VALIDATION_CHAR_LIMIT = 100;

    public final String fullTitle;

    /**
     * Constructs a {@code JobTitle}.
     *
     * @param title A valid title.
     */
    public JobTitle(String title) {
        requireNonNull(title);
        title = title.strip();
        checkArgument(isValidTitle(title), MESSAGE_CONSTRAINTS);
        fullTitle = title;
    }

    /**
     * Returns true if a given string is a valid title.
     */
    public static boolean isValidTitle(String test) {
        // Check for disallowed characters
        if (test.matches(VALIDATION_DISALLOWED_CHARACTERS)) {
            return false;
        }

        // Check for maximum length
        if (test.length() > VALIDATION_CHAR_LIMIT) {
            return false;
        }

        // Check for all caps
        if (test.matches(VALIDATION_ALL_CAPS)) {
            return false;
        }

        // Check for all non-alphanumeric characters
        if (test.matches(VALIDATION_ALL_NON_ALPHANUM)) {
            return false;
        }

        // Check for 4 or more consecutive special characters
        if (test.matches(VALIDATION_CONSEC_SPECIAL_CHARACTERS)) {
            return false;
        }

        // All checks passed, title is valid
        return true;
    }


    @Override
    public String toString() {
        return fullTitle;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof JobTitle // instanceof handles nulls
                && fullTitle.equals(((JobTitle) other).fullTitle)); // state check
    }

    @Override
    public int hashCode() {
        return fullTitle.hashCode();
    }

}
