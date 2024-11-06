package edu.agh.wfiis.solid.tasks.task1;

public final class SolidPointsApplication {
    public static void main(String[] args) {
        User alice = new User("Alice");
        CodeReviewer bob = new CodeReviewer("Bob");
        PointsViewer charlie = new PointsViewer("Charlie");
        
        alice.earnPoints(10);
        System.out.println("Alice's points: " + alice.getSolidPoints());
        alice.earnPoints(20);
        System.out.println("Alice's points: " + alice.getSolidPoints());

        bob.reviewCode(alice, "excellent");
        System.out.println("Alice's points after review: " + alice.getSolidPoints());

        charlie.viewPoints(alice);

        bob.reviewCode(alice, "bad");
        System.out.println("Alice's points after bad review: " + alice.getSolidPoints());
    }
}

