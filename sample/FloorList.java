package sample;

/**
 * FloorList class is responsible for linked list of floor nodes.
 */
public class FloorList {

    public FloorNode floorHead; //head of list

    /**
     * adds floorNode to linked list
     * @param f floor
     */
    public void addFloor(Floor f) {
        FloorNode nn = new FloorNode();
        nn.setContents(f);
        nn.next = floorHead;
        floorHead = nn;

    }
}
