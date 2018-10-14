package seedu.inventory.logic.parser;

import static seedu.inventory.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.inventory.logic.parser.CliSyntax.PREFIX_QUANTITY;
import static seedu.inventory.logic.parser.CliSyntax.PREFIX_SKU;
import static seedu.inventory.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;
import java.util.stream.Stream;

import seedu.inventory.logic.commands.CreateSaleCommand;
import seedu.inventory.logic.parser.exceptions.ParseException;
import seedu.inventory.model.item.Image;
import seedu.inventory.model.item.Item;
import seedu.inventory.model.item.Name;
import seedu.inventory.model.item.Quantity;
import seedu.inventory.model.item.Sku;
import seedu.inventory.model.tag.Tag;

/**
 * Parses input arguments and creates a new CreateSaleCommand object
 */
public class CreateSaleCommandParser implements Parser<CreateSaleCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the CreateSaleCommand
     * and returns an CreateSaleCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public CreateSaleCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_SKU, PREFIX_QUANTITY);

        if (!arePrefixesPresent(argMultimap, PREFIX_SKU, PREFIX_QUANTITY)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CreateSaleCommand.MESSAGE_USAGE));
        }

        Quantity quantity = ParserUtil.parseQuantity(argMultimap.getValue(PREFIX_QUANTITY).get());
        Sku sku = ParserUtil.parseSku(argMultimap.getValue(PREFIX_SKU).get());
        Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));

        // TODO: Find item by SKU then add item
        Item item = new Item(new Name("TEST"), quantity, sku, new Image(""), tagList);

        return new CreateSaleCommand(item, quantity);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
