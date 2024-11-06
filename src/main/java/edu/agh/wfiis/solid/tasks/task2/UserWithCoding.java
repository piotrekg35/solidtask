package edu.agh.wfiis.solid.tasks.task2;

class UserWithCoding {
    String id;
    String email;
    String password;
    int pts;
    boolean isActive;

    UserWithCoding(String id, String email, String password, int pts, boolean isActive) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.pts = pts;
        this.isActive = isActive;
    }

    void updatePoints(int score, String info) {
        if (info != null && !info.isEmpty()) {
            pts += score;
            System.out.println(info + " - New points total: " + pts);
        } else {
            System.out.println("No additional information provided. Points not updated.");
        }
    }
}

