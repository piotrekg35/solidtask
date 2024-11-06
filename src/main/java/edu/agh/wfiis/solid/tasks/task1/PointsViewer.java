package edu.agh.wfiis.solid.tasks.task1;

public final class PointsViewer {
    private final String name;

    public PointsViewer(String name) {
        this.name=name;
    }

    public void viewPoints(User user) {
        System.out.println(user.getName() + " has " + user.getSolidPoints() + " points.");
    }
}

