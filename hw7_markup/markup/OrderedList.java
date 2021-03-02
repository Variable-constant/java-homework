package markup;

import java.util.List;

public class OrderedList extends AbstractElement implements InList {
    public OrderedList(List<ListItem> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder result) { //don't use it
        throw new UnsupportedOperationException("Don't use ListItem.toMarkdown()");
    }

    @Override
    public void toBBCode(StringBuilder result) {
        toBBCode(result, "[list=1]", "[/list]");
    }
}
