package markup;

import java.util.List;

public class Paragraph extends AbstractElement implements InList {
    public Paragraph(List<InParagraph> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder result) {
        toMarkdown(result, "");
    }

    @Override
    public void toBBCode(StringBuilder result) {
        toBBCode(result, "", "");
    }
}
