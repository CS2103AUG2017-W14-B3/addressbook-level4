package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's display picture path in a addressbook
 */
public class DisplayPic {

    public static final String MESSAGE_DISPLAYPIC_CONSTRAINTS = "Person's display pic choice should be dp/Y or dp/N";

    public final String displayPicPath;

    public DisplayPic(String displayPicPath) {
        requireNonNull(displayPicPath);
        String trimmedDisplayPicPath = displayPicPath.trim();
        this.displayPicPath = trimmedDisplayPicPath;
    }

    @Override
    public String toString() {
        return this.displayPicPath;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DisplayPic // instanceof handles nulls
                && this.displayPicPath.equals(((DisplayPic) other).displayPicPath)); // state check
    }

    @Override
    public int hashCode() {
        return displayPicPath.hashCode();
    }
}
