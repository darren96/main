package seedu.inventory.logic.parser.csv;

import static seedu.inventory.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.inventory.logic.parser.CliSyntax.PREFIX_FILEPATH;

import java.nio.file.Path;
import java.util.stream.Stream;

import seedu.inventory.logic.commands.csv.ImportCsvCommand;
import seedu.inventory.logic.parser.ArgumentMultimap;
import seedu.inventory.logic.parser.ArgumentTokenizer;
import seedu.inventory.logic.parser.Parser;
import seedu.inventory.logic.parser.ParserUtil;
import seedu.inventory.logic.parser.Prefix;
import seedu.inventory.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ImportCsvCommand object
 */
public class ImportCsvCommandParser implements Parser<ImportCsvCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ImportCsvCommand
     * and returns an ImportCsvCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ImportCsvCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_FILEPATH);

        if (!arePrefixesPresent(argMultimap, PREFIX_FILEPATH)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ImportCsvCommand.MESSAGE_USAGE));
        }

        Path filePath = ParserUtil.parsePath(argMultimap.getValue(PREFIX_FILEPATH).get());

        return new ImportCsvCommand(filePath);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
