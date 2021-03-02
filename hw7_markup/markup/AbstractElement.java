package markup;

import java.util.List;

public abstract class AbstractElement implements Markable{
    private List<? extends Markable> elements;

    AbstractElement(List<? extends Markable> elements) {
        this.elements = elements;
    }

    protected void toMarkdown(StringBuilder result, String border) {
        result.append(border);
        for (Markable cur : elements) {
            cur.toMarkdown(result);
        }
        result.append(border);
    }

    protected void toBBCode(StringBuilder result, String leftBorder, String rightBorder) {
        result.append(leftBorder);
        for (Markable cur : elements) {
            cur.toBBCode(result);
        }
        result.append(rightBorder);
    }
}
