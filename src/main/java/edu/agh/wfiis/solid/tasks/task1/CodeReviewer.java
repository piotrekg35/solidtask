package edu.agh.wfiis.solid.tasks.task1;

public final class CodeReviewer {
    final private String name;

    public CodeReviewer(String name) {
        this.name=name;
    }

    public void reviewCode(User user, String codeQuality) {
        if (codeQuality.equals("good")) {
            user.earnPoints(10);
        } else if (codeQuality.equals("excellent")) {
            user.earnPoints(75);
        } else if (codeQuality.equals("fantastic")) {
            user.earnPoints(100);
        }else {
            user.subtractPoints(10);
        }
    }
}

