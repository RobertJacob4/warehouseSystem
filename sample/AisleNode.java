package sample;

/**
 * AisleNode is responsible for each node in the linkedList and
 * declaring the list of shelves in an aisle.
 *
 */

public class AisleNode {


    ShelfList shelfLinkList = new ShelfList();//linked list of shelves

    public AisleNode next;//marker for cycling through list
    private Aisle contents;

    /**
     * fields of aisle.
     * @return contents
     */
    public Aisle getContents() {
        return contents;
    }

    public void setContents(Aisle contents) {
        this.contents = contents;
    }

    /**
     * adds a shelf to list of shelves
     * @param s shelf
     */
    public void addShelfAisle(Shelf s){
        shelfLinkList.addShelf(s);
    }
}
