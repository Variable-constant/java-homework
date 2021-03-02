package markup;

import java.util.List;

public class Strikeout extends AbstractElement implements InParagraph {
    public Strikeout(List<InParagraph> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder result) {
        toMarkdown(result, "~");
    }

    @Override
    public void toBBCode(StringBuilder result) {
        toBBCode(result, "[s]", "[/s]");
    }
}
