package sample;

/**
 * PalletNode is responsible for each node in the linkedList.
 *
 */
public class PalletNode {

        public PalletNode next;
        private Pallet contents;

    /**
     * fields of pallet
     * @return
     */
    public Pallet getContents() {
            return contents;
        }

    /**
     * setter of field
     * @param contents
     */
    public void setContents(Pallet contents) {
            this.contents = contents;
        }
    }
