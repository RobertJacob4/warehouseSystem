package sample;
/**
 * Responsible for object shelf and fields
 */
public class Shelf{

    private String shelfNum;

    /**
     * constructor for class
     * @param shelfNum
     */
    public Shelf(String shelfNum) {
        this.shelfNum = shelfNum;
    }

    /**
     * getter and setter with validation
     * @return
     */
    public String getShelfNum() {
        return shelfNum;
    }

    public void setShelfNum(String shelfNum) {
        this.shelfNum = Utilities.validShelfNum(shelfNum);
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "shelfNum=" + shelfNum +
                '}';
    }
}
