package edu.agh.wfiis.solid.tasks.task2;

import java.util.List;

class Order {
    int ref;
    boolean status;
    String data;
    List<String> dataExt;

    Order(int ref, String data, List<String> dataExt, boolean status) {
        this.ref = ref;
        this.data = data;
        this.dataExt = dataExt;
        this.status = status;
    }

    void process() {
        if (status) {
            System.out.println("Order with ID " + ref + " has already been processed. Cannot process again.");
        } else {
            status = true;
            System.out.println("Order with ID " + ref + " has been processed.");
        }
    }

    void update(List<String> list) {
        for (String data : list) {
            System.out.println("Comment: " + data);
            if (data.length() > 100) {
                System.out.println("too long!");
            } else {
                dataExt.add(data);
            }
        }
    }

    boolean isFinished() {
        return status;
    }
}
