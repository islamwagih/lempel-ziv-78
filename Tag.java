public class Tag {
    private int index;
    private char next;

    public Tag(int index, char next) {
        this.index = index;
        this.next = next;
    }

    public int getIndex() {
        return index;
    }

    public char getNext() {
        return next;
    }

    @Override
    public String toString() {
        String last = (next == '#') ? "Null":next+"";
        if(next == ' ') last = "Space";
        return "<" + index + ", " + last + ">";
    }

}
