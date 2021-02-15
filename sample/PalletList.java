package sample;

/**
 * responsible for linked list of pallet nodes
 */
public class PalletList {

    public PalletNode head;//head of list

    /**
     * adds node to list
     * @param p
     */
    public void addPallet(Pallet p) {
        PalletNode nn = new PalletNode();
        nn.setContents(p);
        nn.next = head;
        head = nn;
    }

    public String printList() {

        PalletNode temp = head;
        String fullList = "LinkedList: ";

        while (temp != null) {
            fullList += temp.getContents().getDescription();

            temp = temp.next;
        }
        return fullList;
    }

    public PalletNode searchPallet(String soughtDescription) {
        PalletNode soughtPallet = head;
        PalletNode temp = head;
        while (temp != null && !temp.getContents().getDescription().equals(soughtDescription))
            temp = temp.next;
        if (temp != null) {
            return soughtPallet;
        }
        return null;
    }
}
