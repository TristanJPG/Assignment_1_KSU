import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class OrderList {
    private Order[] orderList = new Order[0];

    public void addOrder(Order order) {
            boolean added = false;
            if (orderList.length == 0) {
                orderList = new Order[1];
                orderList[0] = order;
                added = true;
            } else {
                for (int i = 0; i < orderList.length; i++) {
                    if (orderList[i] == null) {
                        orderList[i] = order;
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    Order[] newArry = new Order[orderList.length * 2];
                    for (int j = 0; j < orderList.length; j++) {
                        newArry[j] = orderList[j];
                    }
                    orderList = newArry;
                    orderList[orderList.length / 2] = order;
                }
            }
        }

    public void removeOrder(int id) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null && orderList[i].getId() == id) {
                ArrayList<Order> newArr = new ArrayList(Arrays.asList(orderList));
                newArr.remove(i);
                orderList = newArr.toArray(new Order[orderList.length]);
            }
            }
        }

    public void readyOrder(int id) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null) {
                if (orderList[i].getId() == id) {
                    orderList[i].ready = true;
                }
            }
        }
    }

    private void sortOrders() {
        for (int i = 1; i < orderList.length; i++) {
            int j = i - 1;
            Order currentItem = orderList[i];
            if (currentItem != null) {
                while (j >= 0 && (orderList[j] != null && (orderList[j].getId() > currentItem.getId()))) {
                    orderList[j + 1] = orderList[j];
                    j--;
                }
            }
            orderList[j + 1] = currentItem;
        }
        int nonNullCount = 0;
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null) {
                nonNullCount++;
            } else{
                orderList[nonNullCount] = orderList[i];
            }
        }
        for (int i = nonNullCount; i < orderList.length; i++) {
            orderList[i] = null;
        }
    }
    public String printOrder(int id) {
        for (int i = 0; i < orderList.length; i++) {
            if (id == orderList[i].getId() && orderList[i] != null) {
                return orderList[i].toString();
            }
        }
        return "";
    }

    public String printOrders() {
        StringBuilder orders = new StringBuilder();
        sortOrders();
        orders.append("Ready \n");
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null && orderList[i].ready) {
                orders.append(orderList[i].getId()).append("\n");
            }
        }
        orders.append("Preparing \n");
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null && !orderList[i].ready) {
                orders.append(orderList[i].getId()).append("\n");
            }
        }
        return orders.toString();
    }
}




