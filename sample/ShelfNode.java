package sample;
/**
 * ShelfNode is responsible for each node in the linkedList and
 * declaring the list of pallets on shelves.
 *
 */
public class ShelfNode {

    PalletList palletLinkList = new PalletList();
    public ShelfNode next;
    private Shelf contents;


    /**
     * contents of a shelf
     * @return
     */
    public Shelf getContents() {
        return contents;
    }

    /**
     * setter for contents
     * @param contents
     */
    public void setContents(Shelf contents) {
        this.contents = contents;
    }

    /**
     * calls method in pallet to add pallet p to linked list of nodes
     * @param p
     */
    public void addPalletShelf(Pallet p){
        palletLinkList.addPallet(p);
    }
}
