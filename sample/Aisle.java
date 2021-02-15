package sample;

/**
 * Aisle class is responsible for the object aisle and its various fields.
 */
public class Aisle {

    private String aisleID;
    private int aisleDepth, aisleWidth;

    /**
     * Constructor contains each field of Aisle
     * @param aisleDepth aisle measurement
     * @param aisleID aisle unique id
     * @param aisleWidth aisle measurement
     */
    public Aisle(int aisleDepth, String aisleID, int aisleWidth) {
        this.aisleDepth = aisleDepth;
        this.aisleID = aisleID;
        this.aisleWidth = aisleWidth;
    }

    /**
     * Getters and Setters for aisle fields containing validation methods
     * from Utilities class.
     *
     */

    public String getAisleID() {
        return aisleID;
    }

    public void setAisleID(String aisleID) {
        this.aisleID = Utilities.validAisleID(aisleID);
    }

    public int getAisleDepth() {
        return aisleDepth;
    }

    public void setAisleDepth(int aisleDepth) {
        this.aisleDepth = Utilities.validNonNegative(aisleDepth);
    }

    public int getAisleWidth() {
        return aisleWidth;
    }

    public void setAisleWidth(int aisleWidth) {
        this.aisleWidth = Utilities.validNonNegative(aisleWidth);
    }

    /**
     * Returns fields in class as a string.
     * @return all fields of aisle.
     */
    @Override
    public String toString() {
        return "Aisle{" +
                "aisleID='" + aisleID + '\'' +
                ", aisleDepth=" + aisleDepth +
                ", aisleWidth=" + aisleWidth +
                '}';
    }
}
