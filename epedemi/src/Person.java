import java.util.Random;

public class Person {
    // Constants
    private final double INIT_SICK_PROB = 0.5;
    private final double GET_WELL_PROB = 0.1;
    private final double DIE_PROB = 0.0005;
    private final double INFECT_PROB = 0.05;
    private final double RANGE = 100;
    private final int DAYS_IMMUNE = 5;
    // Instance variables
    private boolean isSick, isDead;

    private double xPos, yPos;
    private int daysLeftImmune;
    // Random object
    private static Random rand = new Random();


    public Person() {
        this.isSick = rand.nextDouble() < this.INIT_SICK_PROB; // nextDouble gives a value between 0.0 and 1.0 (exc)
        this.isDead = false;
        this.xPos = rand.nextDouble(1000 + 1); // +1 if exclusive intervall. Ändra här rick om detta inte är fallet
        this.yPos = rand.nextDouble(1000 + 1);
        this.daysLeftImmune = 0;

    }
    public boolean getIsSick() {
        return this.isSick;
    }
    public boolean getIsDead() {
        return this.isDead;
    }
    public double getXPos() {
        return this.xPos;
    }
    public double getYPos() {
        return this.yPos;
    }
    public void dayPasses(Person[] allPersons) {
        if (this.isDead) {
            return;
        }
        if (this.daysLeftImmune > 0) {
            this.daysLeftImmune--;
        }
        // Infect
        for (Person p : allPersons) {
            if (p == this) {
                continue;
            }
            // Pythagoras
            double xDiff = Math.abs(this.getXPos() - p.getXPos());
            double yDiff = Math.abs(this.getYPos() - p.getYPos());
            double range = Math.sqrt(Math.pow(xDiff,2) + Math.pow(yDiff,2));
            if (range <= this.RANGE) {
                this.infect(p);
            }
        }

        boolean kill = rand.nextDouble() < this.DIE_PROB;
        // Killing a person
        if (kill) {
            this.isDead = true;
            this.isSick = false;
        }

        // Persons can only get well, thay can't get sick again.
        if (this.isSick) {
            this.isSick = rand.nextDouble() >= this.GET_WELL_PROB; // Here its ">=" because we want to assign false with GET_WELL_PROB
            this.daysLeftImmune = this.DAYS_IMMUNE;
        }

    }

    public void becomesInfected() {
        if (!this.isDead && !this.isSick && this.daysLeftImmune == 0) {
            this.isSick = rand.nextDouble() < this.INFECT_PROB;
        }
    }

    public void infect(Person victim) {
        victim.becomesInfected();
    }
}
