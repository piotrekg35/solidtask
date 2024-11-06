package edu.agh.wfiis.solid.tasks.task2;

import java.util.ArrayList;
import java.util.List;

class Application {
    public static void main(String[] args) {
        Management management = new Management();
        UserWithCoding u1 = new UserWithCoding("JohnDoe", "john.doe@example.com", "password123", 100, true);
        UserWithCoding jane = new UserWithCoding("jane", "jane.smith@example.com", "pass", 50, false);

        String errors = management.validateUser(u1);
        if (errors.length() > 0) {
            System.out.println("Validation errors: " + errors);
        }
        String errors2 = management.validateUser(jane);
        if (errors2.length() > 0) {
            System.out.println("Validation errors: " + errors2);
        }

        List<String> comments = new ArrayList<>();
        comments.add("SOLID rules preserved");
        comments.add("Good naming");
        comments.add("Readable code");

        Order review = management.addNewOrder(u1, comments, "Bob");
        management.process(u1.id, review.ref, 10, "Great job, keep it up!");

        comments.add("LSP violated");
        comments.add("Good naming");
        Order review2 = management.addNewOrder(jane, comments, "Bob");
        management.updateUserOrder(jane, new ArrayList<>(){{this.add("I forgot that ISP violation should be fixed too");}});
        management.process(jane.id, review2.ref, 1, "Need some improvement!");

        UserWithCoding betterUser = management.getUserWithMorePts(u1, jane);
        System.out.println("User with better points: " + betterUser.id);
    }
}
