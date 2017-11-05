//@@author conantteo
package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's birthday in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBirthday(String)}
 */
public class Birthday {

    public static final String MESSAGE_BIRTHDAY_CONSTRAINTS =
            "Birthday format should be 'DD/MM/YYYY', and it should not be blank";

    public static final String BIRTHDAY_VALIDATION_REGEX = "\\d{2}\\/\\d{2}\\/\\d{4}";

    public final String value;
    private String birthdayDay;
    private String birthdayMonth;
    private String birthdayYear;

    /**
     * Validates given birthday.
     *
     * @throws IllegalValueException if given birthday string is invalid.
     */
    public Birthday(String birthday) throws IllegalValueException {
        requireNonNull(birthday);
        String trimmedBirthday = birthday.trim();
        if (birthday.length() != 0 && !isValidBirthday(trimmedBirthday)) {
            throw new IllegalValueException(MESSAGE_BIRTHDAY_CONSTRAINTS);
        }
        this.value = trimmedBirthday;

        if (trimmedBirthday.length() > 0) {
            String[] allValues = this.value.split("/");
            this.birthdayDay = allValues[0];    // get day
            this.birthdayMonth = allValues[1];  // get month
            this.birthdayYear = allValues[2];   // get year
        }
    }

    /**
     * Returns true if a given string is a valid person phone number.
     */
    public static boolean isValidBirthday(String test) {
        return test.matches(BIRTHDAY_VALIDATION_REGEX);
    }

    public String getBirthdayMonth() {
        requireNonNull(birthdayMonth);
        return birthdayMonth;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Birthday // instanceof handles nulls
                && this.value.equals(((Birthday) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
