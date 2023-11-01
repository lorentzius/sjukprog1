public class Main {
    public static void main(String[] args) {
        Village village = new Village();
        while (true) {
            int sickCount = village.countSick();
            int deadCount = village.countDead();
            System.out.println("Sick people: " + sickCount);
            System.out.println("Dead people: " + deadCount);
            if (sickCount == 0) {
                break;
            }
            village.dayPassesAll();
        }
    }

}