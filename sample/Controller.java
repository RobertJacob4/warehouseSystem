package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class interacts with GUI I/O
 */
public class Controller implements Initializable {

    FloorList floorList = new FloorList();  //linked list of floors

    /**
     * FXML components from scene builder GUI
     */
    @FXML
    public TextField shelfAisleID;
    @FXML
    public TextField floorNum;
    @FXML
    public ChoiceBox<String> securityLevel;
    @FXML
    public TextField aisleFloorNum;
    @FXML
    public ChoiceBox<String> floorTemp;
    @FXML
    public TextField shelfNum;
    @FXML
    public TextField palletFloorNum;
    @FXML
    public TextField palletAisleId;
    @FXML
    public TextField palletShelfNum;
    @FXML
    public TextField palletDescription;
    @FXML
    public TextField palletQuantity;
    @FXML
    public TextField palletMinTemp;
    @FXML
    public TextField palletMaxTemp;
    @FXML
    public Button smartAddPallet;
    @FXML
    public ChoiceBox<String> palletValue;
    @FXML
    public TextField deletePalletFloorNum;
    @FXML
    public TextField deletePalletShelfNum;
    @FXML
    public TextField deletePalletAisleId;
    @FXML
    public TextField deletePalletDescription;
    @FXML
    public TextField aisleWidth;
    @FXML
    public TextField aisleDepth;
    @FXML
    public TextField aisleID;
    @FXML
    public Button addFloor;
    @FXML
    public Button addAisle;
    @FXML
    public Button addShelf;
    @FXML
    public Button addPallet;
    @FXML
    public Button removePallet;
    @FXML
    public Button save;
    @FXML
    public Button load;
    @FXML
    public TextField aisleId;
    @FXML
    public Button load1;
    @FXML
    public Button save1;
    @FXML
    public Button viewAllButton;
    @FXML
    public ListView viewAll;
    @FXML
    public TreeView treeView;
    @FXML
    public Button search;
    @FXML
    public TextField searchForGoods;
    @FXML
    public Button reset;


    /**
     * Populates choiceBoxes.
     * @param location
     * @param resources
     */
    public void initialize(URL location, ResourceBundle resources) {
        securityLevel.getItems().addAll("LOW", "MODERATE", "HIGH");
        palletValue.getItems().addAll("<$1000", "$1000-$10,000", ">$10,0000");
        floorTemp.getItems().addAll("25", "5", "0");
    }

    /**
     * Resets system by creating new floorList and saving XML of system
     * @param actionEvent
     * @throws Exception
     */
    public void reset(ActionEvent actionEvent) throws Exception {
        floorList = new FloorList();
        saveFile(actionEvent);
    }

    /**
     * adds floor with user input read in from GUI
     * @param actionEvent
     */
    public void addFloor(ActionEvent actionEvent) {
        floorList.addFloor(addFloorRead());
    }

    /**
     * adds aisle to linked list
     * @param actionEvent
     */
    public void addAisle(ActionEvent actionEvent) {
        FloorNode floorTemp = floorList.floorHead; //temp = head for cycling

        while (floorTemp != null) { //check exists
            System.out.print("FloorTempID" + floorTemp.getContents().getFloorNum());
            System.out.print("TextBox" + Integer.parseInt(addAisleFloorNumRead()));
            if (floorTemp.getContents().getFloorNum() == Integer.parseInt(addAisleFloorNumRead())) {  //if user entered floor matches existing floor
                floorTemp.aisleLinkList.addAisle(addAisleRead()); //adds aisle to list with values read from GUI
            }
            floorTemp = floorTemp.next; //cycle
        }
    }

    /** adds shelf to linked list
     *
     * @param actionEvent
     */
    public void addShelf(ActionEvent actionEvent) {
        FloorNode floorTemp = floorList.floorHead; //for cycling
        AisleNode aisleTemp;
        while (floorTemp != null) { //if exists
            aisleTemp = floorTemp.aisleLinkList.head; //for cycling
            while (aisleTemp != null) {
                if (aisleTemp.getContents().getAisleID().equals(addShelfAisleRead())) {
                    aisleTemp.addShelfAisle(addShelfRead()); //adds shelf with values from user
                    System.out.println(addShelfRead().toString());
                }
                aisleTemp = aisleTemp.next;//cycle
            }
            floorTemp = floorTemp.next;
        }
    }

    /**
     * adds pallet to shelf
     * @param actionEvent
     */
    public void addPallet(ActionEvent actionEvent) {

        FloorNode floorTemp = floorList.floorHead;
        AisleNode aisleTemp;
        ShelfNode shelfTemp;

        while (floorTemp != null) { //floor exist at head
            aisleTemp = floorList.floorHead.aisleLinkList.head;
            while (aisleTemp != null) { //aisle exists at head
                shelfTemp = floorList.floorHead.aisleLinkList.head.shelfLinkList.head;
                while (shelfTemp != null) { //shelf exists at head
                    if (shelfTemp.getContents().getShelfNum().equals(addPalletShelf()) && (aisleTemp.getContents().getAisleID().equals(addPalletAisleIDRead()))) {
                        shelfTemp.addPalletShelf(addPalletRead());
                    }
                    shelfTemp = shelfTemp.next; //cycle through nodes
                }
                aisleTemp = aisleTemp.next;
            }
            floorTemp = floorTemp.next;
        }
    }

    /**
     * removes a pallet node from list
     * @param actionEvent
     */
    public void removePallet(ActionEvent actionEvent) {
        FloorNode floorTemp = floorList.floorHead;
        AisleNode aisleTemp = floorTemp.aisleLinkList.head;
        ShelfNode shelfTemp = aisleTemp.shelfLinkList.head;
        PalletNode palletTemp = shelfTemp.palletLinkList.head;


        while (floorTemp != null) {
            while (aisleTemp != null) {
                while (shelfTemp != null) {
                    while (palletTemp != null && palletTemp.next != null) {
                        if (palletTemp.getContents().getDescription().equals(removePalletDescriptionRead()) && aisleTemp.getContents().getAisleID().equals(removePalletAisleIDRead())) {
                            shelfTemp.palletLinkList.head = shelfTemp.palletLinkList.head.next; //remove at start by skipping over head
                            System.out.println("Successfully removed Pallet");
                        }
                        if (palletTemp.next.getContents().getDescription().equals(removePalletDescriptionRead()) && aisleTemp.getContents().getAisleID().equals(removePalletAisleIDRead())) {
                            palletTemp.next = palletTemp.next.next; //remove inside list
                            System.out.println("Successfully removed Pallet");
                        } else {
                            palletTemp = palletTemp.next;//cycle
                        }
                    }
                    shelfTemp = shelfTemp.next;
                }
                aisleTemp = aisleTemp.next;
            }
            floorTemp = floorTemp.next;
        }

    }

    /**
     *prints stock in systems to listview in GUI
     * @param actionEvent
     */
    public void viewStock(ActionEvent actionEvent) {
        FloorNode floorTemp = floorList.floorHead;
        AisleNode aisleTemp;
        ShelfNode shelfTemp;
        PalletNode palletTemp;
        String palletList;
        while (floorTemp != null) {
            aisleTemp = floorTemp.aisleLinkList.head;
            while (aisleTemp != null) {
                shelfTemp = aisleTemp.shelfLinkList.head;
                while (shelfTemp != null) {
                    palletTemp = shelfTemp.palletLinkList.head;
                    while (palletTemp != null) {
                        palletList = (" Floor Number : " + floorTemp.getContents().getFloorNum()) + (" , ") + ("Aisle : ") + (aisleTemp.getContents().getAisleID()) + (" , ") + ("Shelf : ") + (shelfTemp.getContents().getShelfNum()) + (" , ") + ("Pallet : ") + palletTemp.getContents().getDescription() + ("\n");
                        palletTemp = palletTemp.next;
                        viewAll.getItems().add(palletList); //populate listview
                    }
                    shelfTemp = shelfTemp.next;//cycle
                }
                aisleTemp = aisleTemp.next;
            }
            floorTemp = floorTemp.next;
        }
    }

    public void handle(ActionEvent event) {

    }

    /**
     * Method reads in fields from the user and creates a pallet with the fields.
     *
     */
    public Pallet addPalletRead() {
        Pallet p = new Pallet(palletDescription.getText(), Integer.parseInt(palletQuantity.getText()), Integer.parseInt(palletMinTemp.getText()), Integer.parseInt(palletMaxTemp.getText()), palletValue.getValue());
        return p;
    }

    /**
     * reads in aisle ID of the aisle that pallet will be added to.
     * @return
     */
    public String addPalletAisleIDRead() {
        return palletAisleId.getText();
    }

    /**
     * Method reads in fields from the user and creates an aisle with the fields.
     *
     */
    public Aisle addAisleRead() {
        Aisle a = new Aisle(Integer.parseInt(aisleDepth.getText()), aisleID.getText(), Integer.parseInt(aisleWidth.getText()));
        return a;
    }

    /**
     * reads in floor number of floor that aisle will be added to.
     * @return
     */
    public String addAisleFloorNumRead() {
        return aisleFloorNum.getText();
    }
    /**
     * reads in shelf number of shelf that pallet will be added to.
     * @return
     */
    public String addPalletShelf() {
        return palletShelfNum.getText();
    }
    /**
     * reads in aisle ID of aisle that shelf will be added to.
     * @return
     */
    public String addShelfAisleRead() {
        return shelfAisleID.getText();
    }

    /**
     * Method reads in fields from the user and creates a floor with the fields.
     *
     */
    public Floor addFloorRead() {
        Floor f = new Floor(Integer.parseInt(floorNum.getText()), Integer.parseInt(floorTemp.getValue()), securityLevel.getValue());
        return f;
    }

    /**
     * Method reads in fields from the user and creates a shelf with the fields.
     *
     */
    public Shelf addShelfRead() {
        Shelf s = new Shelf(shelfNum.getText());
        return s;
    }

    /**
     * reads in description of pallet that will be removed
     * @return
     */
    public String removePalletDescriptionRead() {
        return deletePalletDescription.getText();
    }

    /**
     * reads in aisle id of pallet that will be removed
     * @return
     */
    public String removePalletAisleIDRead() {
        return deletePalletAisleId.getText();
    }

    /**
     * Loads XML files that have been saved using xstream
     * @param actionEvent
     * @throws Exception
     */
    public void loadFile(ActionEvent actionEvent) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("floorList.xml"));
        floorList = (FloorList) is.readObject();
        is.close();
    }

    /**
     * saves XML files using xstream
     * @param actionEvent
     * @throws Exception
     */
    public void saveFile(ActionEvent actionEvent) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("floorList.xml"));
        out.writeObject(floorList);
        out.close();
    }
}
