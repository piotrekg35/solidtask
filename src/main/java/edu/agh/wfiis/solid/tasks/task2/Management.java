package edu.agh.wfiis.solid.tasks.task2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Management {
    List<Order> orders;
    List<UserWithCoding> users;

    Management() {
        this.orders = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    Order addNewOrder(UserWithCoding person, List<String> comments, String username) {
        Order o = new Order(orders.size() + 1, "Review for user " + person.id + ",created at " + Instant.now() + " by " +username, comments, false);
        orders.add(o);
        users.add(person);

        return o;
    }

    void updateUserOrder(UserWithCoding person, List<String> comments) {
        int idx = users.indexOf(person);
        if (idx>-1) {
            Order o = orders.get(idx);
            o.update(comments);
        } else {
            System.out.println("Cannot update");
        }
    }

    String validateUser(UserWithCoding account) {
        StringBuilder err = new StringBuilder();
        if (account.id.isEmpty()) {
            err.append("User key cannot be empty.\n");
        }
        if (!account.email.contains("@")) {
            err.append("Client email is invalid.\n");
        }
        if (account.password.length() < 6) {
            err.append("Pass must be at least 6 characters long.\n");
        }
        for (char c : "!@#$%^&*".toCharArray()) {
            if(account.password.indexOf(c)>-1)
            {
                err.append("Password contains an invalid character: ").append(c).append("\n");
            }
        }
        if (!account.isActive) {
            err.append("Customer is currently inactive.\n");
        }
        return err.toString();
    }

    UserWithCoding getUserWithMorePts(UserWithCoding user1, UserWithCoding user2) {
        System.out.println("Comparing " + user1.id + " with " + user2.id);
        return user1.pts > user2.pts ? user1 : user2;
    }

    Optional<UserWithCoding> getUserById(String id)
    {
        for (UserWithCoding u : users) {
            if (u.id.equals(id)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    Optional<Order> getOrderById(int id)
    {
        for (Order o : orders) {
            if (o.ref == id) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }

    void process(String userId, int reviewId, int score, String feedbackData) {
        Optional<UserWithCoding> user = getUserById(userId);
        Optional<Order> order = getOrderById(reviewId);

        if (order.isEmpty()) {
            System.out.println("Review not found with ID: " + reviewId);
            return;
        }
        if (order.get().isFinished()) {
            System.out.println("Review has already been processed. No points will be awarded.");
        } else if (user.isEmpty()) {
            System.out.println("User not found with handle: " + userId);
        } else {
            order.get().process();
            user.get().updatePoints(score, feedbackData);
            System.out.println("Review completed for " + userId + ". Points awarded: " + score);
        }
    }
}
