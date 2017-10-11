package seedu.address.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class AliasCommandTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_addAlias_success() throws Exception {

        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.addAlias("a", "add");

        StringBuilder sb = new StringBuilder();

        sb.append(AliasCommand.MESSAGE_SUCCESS);
        sb.append("a");
        sb.append(" for ");
        sb.append("add");
        assertCommandSuccess(prepareCommand("a", "add"), model, sb.toString(), expectedModel);
    }

    @Test
    public void execute_addAliasForInvalidCommand_throwsException() throws Exception {

        thrown.expect(CommandException.class);
        thrown.expectMessage(AliasCommand.MESSAGE_INVALID_COMMAND);

        prepareCommand("a", "abcde").execute();
    }

    @Test
    public void equals() {
        AliasCommand aliasAddCommand = new AliasCommand("a", "add");
        AliasCommand aliasFindCommand = new AliasCommand("f", "find");

        // same object -> returns true
        assertTrue(aliasAddCommand.equals(aliasAddCommand));

        // same values -> returns true;
        AliasCommand aliasAddCommandCopy = new AliasCommand("a", "add");
        assertTrue(aliasAddCommand.equals(aliasAddCommandCopy));

        // different types -> returns false
        assertFalse(aliasAddCommand.equals(1));

        // null -> returns false
        assertFalse(aliasAddCommand.equals(null));

        // different commands -> returns false
        assertFalse(aliasAddCommand.equals(aliasFindCommand));
    }

    /**
     * Returns an {@code EditCommand} with parameters {@code index} and {@code descriptor}
     */
    private AliasCommand prepareCommand(String alias, String command) {
        AliasCommand aliasCommand = new AliasCommand(alias, command);
        aliasCommand.setData(model, new CommandHistory(), new UndoRedoStack());
        return aliasCommand;
    }
}
