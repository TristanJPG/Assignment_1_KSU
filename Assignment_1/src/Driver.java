import java.util.Scanner;

public class Driver {
    static OrderList restaurantOrders = new OrderList();
    static Scanner scr = new Scanner(System.in);
    public static Order order;

    public static void main (String[] args) {
        boolean opp = true;
        StringBuilder quest = new StringBuilder();

        quest.append("1- Create order \n").append("2- Delete order\n").append("3- Ready order\n").append("4- Print order\n").append("5- Print all orders\n").append("6- Exit\n");
        while(opp) {

            System.out.print(quest);
            String ans = scr.nextLine();

            if(ans.equals("1")) {
                String[] orderArr = new String[3];
                System.out.println("Enter 3 Orders");
                String order1 = scr.nextLine();
                orderArr[0] = order1;
                String order2 = scr.nextLine();
                orderArr[1] = order2;
                String order3 = scr.nextLine();
                orderArr[2] = order3;
                 order = new Order(orderArr);
                 restaurantOrders.addOrder(order);
                 System.out.println("Order has been added.");
            }
            if (ans.equals("2")){
                System.out.println("Enter Order ID");
                String orderID = scr.nextLine();
                restaurantOrders.removeOrder(Integer.parseInt(orderID));
                System.out.println("Order has been removed");
            }
            if(ans.equals("3")){
                System.out.println("Enter Order ID");
                String orderID = scr.nextLine();
                restaurantOrders.readyOrder(Integer.parseInt(orderID));
                System.out.println("Order has been set to 'Ready'");
            }
            if(ans.equals("4")) {
                System.out.println("Enter Order ID");
                String orderID = scr.nextLine();
                if(restaurantOrders.printOrder(Integer.parseInt(orderID)).equals("")){
                    System.out.println("There is no Order with that ID");
                }
                else {
                    System.out.println(restaurantOrders.printOrder(Integer.parseInt(orderID)));
                }
            }
            if(ans.equals("5")) {
                System.out.println(restaurantOrders.printOrders());
            }
            if (ans.equals("6")) {
                opp = false;
            }
        }
    }
}
