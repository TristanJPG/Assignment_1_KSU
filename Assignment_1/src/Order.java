public class Order {
    private int orderID;
    private static int nextID = 1;
    public boolean ready;
    public String[] items;

    public Order() {
        nextID = this.orderID;
        this.ready = false;
        this.items = new String[3];
    }
    public Order(String[] strArr ){
        this.orderID = nextID;
        nextID += 1;
        this.ready = false;
        this.items = strArr;
    }
    public int getId(){
        return this.orderID;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(this.orderID).append("\n");
        if (this.ready) {
            sb.append("Ready \n");
        } else {
            sb.append("Not Ready \n ");
        }
        for (String item:this.items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}

