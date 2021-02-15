
package sample;

/**
 * Responsible for object pallet and fields.
 */
public class Pallet {

    private String description, palletValue;
    private int minTemp, maxTemp, quantity;

    /**
     * constructor for pallet
     * @param description
     * @param quantity
     * @param minTemp
     * @param maxTemp
     * @param palletValue
     */
    public Pallet(String description, int quantity, int minTemp, int maxTemp, String palletValue) {
        this.description = description;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.quantity = quantity;
        this.palletValue = palletValue;

    }

    /**
     * Getters and setters for all fields including validation
     *
     */

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public String getPalletValue() {
        return palletValue;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setDescription(String description) {
        this.description = Utilities.max100Chars(description);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setPalletValue(String palletValue) {
        this.palletValue = palletValue;
    }

    /**
     * prints fields of class as string
     * @return
     */
    @Override
    public String toString() {
        return "Pallet{" +
                ", description='" + description + '\'' +
                ", palletValue='" + palletValue + '\'' +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", quantity=" + quantity +
                '}';
    }
}




