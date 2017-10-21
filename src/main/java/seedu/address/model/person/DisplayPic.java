package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.io.File;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's display picture path in a addressbook
 */
public class DisplayPic {

    public static final String MESSAGE_DISPLAYPIC_CONSTRAINTS = "Person's display pic choice should be dp/Y or dp/N";

    public final String displayPicPath;

    public DisplayPic(String displayPicPath) throws IllegalValueException {
        requireNonNull(displayPicPath);
        String trimmedDisplayPicPath = displayPicPath.trim();
        if (!validFilePath(displayPicPath)) {
            throw new IllegalValueException(MESSAGE_DISPLAYPIC_CONSTRAINTS);
        }
        this.displayPicPath = trimmedDisplayPicPath;
    }

    /**
     * Check if the path is correct by checking if the file exists
     * @param path is the path to the file
     * @return
     */
    public boolean validFilePath(String path) {
        File displayPic = new File(path);
        return displayPic.exists();
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
