package markup;

public interface Markable {
    void toMarkdown(StringBuilder result);
    void toBBCode(StringBuilder result);
}
