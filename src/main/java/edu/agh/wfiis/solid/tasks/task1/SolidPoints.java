package edu.agh.wfiis.solid.tasks.task1;

public final class SolidPoints {

    protected int solidPoints;

    public SolidPoints() {
        this.solidPoints = 0;
    }

    public void earnPoints(int points) {
            if (points > 0 && points < 100) {
                this.solidPoints += points; 
            } else {
                 System.out.println("Points must be positive and no more than 100.");
            }
    }

    public void subtractPoints(int points) {
            if (points > 0 && points <= this.solidPoints) {
                this.solidPoints -= points; 
            } else {
                System.out.println("Invalid points.");
            }
    }

    public int getTotalPoints() {
        return this.solidPoints; 
    }
}
