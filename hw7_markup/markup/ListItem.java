package markup;

import java.util.List;

public class ListItem extends AbstractElement{
    private List<InList> elements;

    public ListItem(List<InList> elements) {
        super(elements);
    }

    public void toMarkdown(StringBuilder result) { //don't use it
        throw new NoSuchMethodError("Don't use ListItem.toMarkdown()");
    }

    public void toBBCode(StringBuilder result) {
        toBBCode(result, "[*]", "");
    }
}
