package sample;

/**
 * AisleList class is responsible for linked list of aisle nodes.
 */

public class AisleList {

    /**
     * default constructor initialises list at head.
     */
    public AisleList() {
        head = null;
    }

    public AisleNode head; //head node

    /**
     * adds a node to the list with the filled out fields from the GUI.
     * @param a aisle to be added
     */
   public void addAisle(Aisle a) {
       AisleNode nn = new AisleNode();
        nn.setContents(a);
       nn.next = head;
        head = nn; //adds to head
    }

}
