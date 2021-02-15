package sample;

/**
 * Responsible for object floor and fields
 */
public class Floor {

    private int floorNum;
    private int floorTemp;
    private String securityLevel;

    /**
     * Constructor for floor
     * @param floorNum floor number
     * @param floorTemp floor temperature
     * @param securityLevel security level of floor
     */
    public Floor(int floorNum, int floorTemp, String securityLevel) {
        this.floorNum = floorNum;
        this.floorTemp = floorTemp;
        this.securityLevel = securityLevel;

    }

    /**
     * Getters and Setters for fields of floor including validation of the fields using Utilities class.
     *
     */

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = Utilities.validNonNegative(floorNum);
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public int getFloorTemp() {
        return floorTemp;
    }

    public void setFloorTemp(int floorTemp) {
        this.floorTemp = floorTemp;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorNum=" + floorNum +
                ", floorTemp=" + floorTemp +
                ", securityLevel='" + securityLevel + '\'' +
                '}';
    }
}
