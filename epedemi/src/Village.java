public class Village {
    private final int SIZE = 1000;
    private Person[] population;
    // Constructor
    public Village() {
        population = new Person[SIZE];
        for (int i = 0; i < SIZE; i++) {
            this.population[i] = new Person();
        }
    }
    public int countSick() {
        int count = 0;
        for (Person p : this.population) {
            if (p.getIsSick()) {
                count++;
            }
        } return count;
    }
    public int countDead() {
        int count = 0;
        for (Person p : this.population) {
            if (p.getIsDead()) {
                count++;
            }
        } return count;
    }
    public void dayPassesAll(){
        for (Person p : this.population) {
            p.dayPasses(this.population);
        }
    }

}
