package sample;

/**
 * FloorNode is responsible for each node in the linkedList and
 * declaring the list of aisles on floors.
 *
 */
public class FloorNode {

    AisleList aisleLinkList = new AisleList();//linked list of aisle
    public FloorNode next;
    private Floor contents;

    /**
     * parameters of floor - floorNum, securityLevel, floorTemp
     * @return
     */
    public Floor getContents() {
        return contents;
    }

    /**
     * setter for contents
     * @param contents
     */
    public void setContents(Floor contents) {
        this.contents = contents;
    }
}
