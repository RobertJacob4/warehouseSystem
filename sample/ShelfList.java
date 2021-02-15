package sample;
/**
 * ShelfList class is responsible for linked list of shelf nodes.
 */
public class ShelfList {

    public ShelfNode head = null;//initialise list

    /**
     * adds shelf node to list
     * @param s
     */
    public void addShelf(Shelf s) {
        ShelfNode nn = new ShelfNode();
        nn.setContents(s);
        nn.next = head;
        head = nn;
    }
}
