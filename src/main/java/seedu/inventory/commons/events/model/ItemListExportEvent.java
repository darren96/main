package seedu.inventory.commons.events.model;

import java.nio.file.Path;

import seedu.inventory.commons.events.BaseEvent;
import seedu.inventory.model.ReadOnlyItemList;

/**
 * Indicates the item list in the model need to be imported
 */
public class ItemListExportEvent extends BaseEvent {
    public final ReadOnlyItemList data;
    public final Path filePath;

    public ItemListExportEvent(ReadOnlyItemList data, Path filePath) {
        this.data = data;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "number of items " + data.getItemList().size() + " to file:" + filePath.toString();
    }
}
