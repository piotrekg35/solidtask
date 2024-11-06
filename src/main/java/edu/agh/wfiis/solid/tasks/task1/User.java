package edu.agh.wfiis.solid.tasks.task1;

public final class User {
    final private String name;
    private SolidPoints solidPoints;

    public User(String name) {
        this.name = name;
        this.solidPoints = new SolidPoints();
    }

    public String getName(){
        return this.name;
    }

    public int getSolidPoints(){
        return this.solidPoints.getTotalPoints();
    }

    public void earnPoints(int points){
        this.solidPoints.earnPoints(points);
    }

    public void subtractPoints(int points){
        this.solidPoints.subtractPoints(points);
    }
}
