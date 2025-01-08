package at.htlle.sam.Bibliothek;

public class Library {
    private Item[] items;
    private int itemCount;

    public Library() {
        items = new Item[Constants.MAX_LIBRARY_SIZE];
        itemCount = 0;
    }



    public boolean addItem(Item item) {
        if (itemCount >= Constants.MAX_LIBRARY_SIZE) {
            return false;
        }
        else {
            items[itemCount] = item;
            itemCount++;
            return true;
        }
    }
    public boolean removeItem(Item item) {
        if (itemCount <= 0) {
            return false;
        }
        for (int i = 0; i < itemCount; i++) {
            if (items[i] == item) {
                items[i] = items[itemCount - 1];
                items[itemCount - 1] = null;
                itemCount--;
                return true;
            }
        }
        return false;
    }


    public String getItems(){
        for(int i = 0; i < itemCount; i++){
            if(items[i] != null){
                System.out.println(items[i].getDescription());
                System.out.println("----------------------------------------------------");
            }
        }

        return "";
    }

}
