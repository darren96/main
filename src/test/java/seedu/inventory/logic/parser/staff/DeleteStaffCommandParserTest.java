package seedu.inventory.logic.parser.staff;

import static seedu.inventory.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.inventory.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.inventory.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.inventory.testutil.TypicalIndexes.INDEX_FIRST_ITEM;

import org.junit.Test;

import seedu.inventory.logic.commands.staff.DeleteStaffCommand;

public class DeleteStaffCommandParserTest {

    private DeleteStaffCommandParser parser = new DeleteStaffCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteStaffCommand() {
        assertParseSuccess(parser, "1", new DeleteStaffCommand(INDEX_FIRST_ITEM));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteStaffCommand.MESSAGE_USAGE));
    }
}
