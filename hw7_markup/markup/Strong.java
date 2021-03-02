package markup;

import java.util.List;

public class Strong extends AbstractElement implements InParagraph {
    public Strong(List<InParagraph> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder result) {
        toMarkdown(result, "__");
    }

    @Override
    public void toBBCode(StringBuilder result) {
        toBBCode(result, "[b]", "[/b]");
    }
}
