package at.htlle.pos;

import java.time.LocalDate;

/**
 * The CashRegister can process any instance of the item class
 * items can be added, items can be multiplied, the sub-total of
 * a session can be computed, and the overall total-sum is kept and updated
 * in the background and can be queried as the day-takings.
 */
public class CashRegister {
    private static final String RECEIPT_TITLE = "HTL-Leoben POS-Stüberl Rechnung " + LocalDate.now() + " \n";
    public static final int MAX_SUB_GROUP_ITEMS = 20;

    private Item[] items;
    private int[] multipliers;
    private StringBuilder logOfSubTotalReceipts;
    private long totalSumInCents;


    /**
     * constructor which initializes all fields
     */
    public CashRegister() {
        items = new Item[MAX_SUB_GROUP_ITEMS];
        multipliers = new int[MAX_SUB_GROUP_ITEMS];
        logOfSubTotalReceipts = new StringBuilder();
        totalSumInCents = 0;
    }







    public long getCurrentTotalSumInCent() {
        return totalSumInCents;
    }


    public long getCurrentSubTotalSumInCent() {
        return computeSubTotalSumInCents();// what shall we return here??;
    }


    /**
     * This class concludes a customer session and computes the totalSum
     * and creates the Receipt for the current subTotalSum.
     * It then resets the items and their multipliers
     *
     * @return ... the receipt of the last customer session
     */
    public String newCustomerSession() {
        String receipt = computeSubTotalReceipt();
        totalSumInCents += computeSubTotalSumInCents();// don't we need to add the subTotalSum?
        // we need a receipt before we can append it
        logOfSubTotalReceipts.append(receipt);
        items = new Item[MAX_SUB_GROUP_ITEMS];
        multipliers = new int[MAX_SUB_GROUP_ITEMS];


        // clear the array(s)
        // which arrays make sense to be cleared?
        // wouldn't it be easier to just create new empty arrays?
        return receipt;
    }

    /**
     * Computes the sub-total, adds the number to the totalSum,
     * and adds the subTotalReceipt to the logOfSubtotalReceipts
     * then it clears the items- and multiplier- arrays.
     */
    public String getSubTotalReceipt() {
        // ===
        // HOW to fix this error - come up with something meaningful
        // isn't there a need to compute the subTotalReceipt first before returning it?
        // ====
        return computeSubTotalReceipt();
    }

    /**
     * Adds a single item to the items-array (register) the multiplier is set to 1.
     *
     * @param item ... the item to be added to the items-array
     * @return ... 'true' if the item was successfully added, 'false' otherwise
     */
    public boolean addItem(Item item) {
        // how can we use the more complex version of the method (the one with two parameters)
        return addItem(item, 1);
    }

    /**
     * Adds an item and the passed multiplier to their items- and multiplier-array.
     *
     * @param item       ... the item to be added to the items-array
     * @param multiplier ... the multiplier to be added to the multiplier-array
     * @return ... 'true' if the item was successfully added, 'false' otherwise
     */
    public boolean addItem(Item item, int multiplier) {
        // find a free spot in the items-array
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                multipliers[i] += multiplier;
                return true;
            }
        }



        // ===
        // come up with something meaningful
        // ====

        // if there is none, the max number of allowed items is used
        // and false is returned
        // Please write something meaningful to the console.
        System.out.println("No space anymore");
        return false;
    }

    // ====
    // helper methods

    /**
     * A helper method to compute a receipt for the
     * items and their multiplier in the cash register.
     * This receipt contains all items, the multiplier,
     * the individual and the subtotal
     *
     * @return ... the receipt as a String
     */
    private String computeSubTotalReceipt() {
        StringBuilder sb = new StringBuilder(RECEIPT_TITLE);
        long subTotalInCents = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) break;
            double itemTotal = items[i].getCostsInCent()*multipliers[i];
            subTotalInCents += itemTotal;
            sb.append(items[i].getName()).append("\n").append(multipliers[i]).append("x").append(items[i].getCostsInCent()/100).append(" = ").append(itemTotal / 100).append("\n");

        }
        // ===
        // come up with something meaningful
        // ====
        sb.append("===\nSumme:\t").append(subTotalInCents / 100f).append(" €\n");
        return sb.toString();
    }

    /**
     * A helper method to compute the subTotal of the items in the
     * cash register.
     *
     * @return ... the subtotal of all items * multiplier
     */
    private long computeSubTotalSumInCents() {
        long subTotalInCents = 0;
       for ( int i = 0; i < items.length; i++) {
           if (items[i] == null) break;
           subTotalInCents += items[i].getCostsInCent()*multipliers[i];
       }


        // ====
        // come up with something meaningful
        // ====
        return subTotalInCents;
    }


    public String getCurrentTotalSumInEuro() {
        double totalInEuro = totalSumInCents/100.0;
        return String.valueOf(totalInEuro);
    }

    public Item[] getItems() {
        return items;
    }

    public int[] getMultipliers() {
        return multipliers;
    }

    public String getCurrentSubTotalSumInEuro() {
        double subTotalInEuro = computeSubTotalSumInCents()/100;
        return String.valueOf(subTotalInEuro);


    }
}
