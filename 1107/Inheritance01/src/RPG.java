public class RPG {
    public static void main(String[] args) {
        SwordsMan swordsMan1 = new SwordsMan("Arthur", 100, 20);
        SwordsMan swordsMan2 = new SwordsMan("Lancelot", 90, 18);

        Magican magican1 = new Magican("Merlin", 80, 25, 15);
        Magican magican2 = new Magican("Morgana", 85, 22, 12);

        System.out.println("Fight");
        swordsMan1.attack(swordsMan2);
        magican1.attack(magican2);

        System.out.println("\nAfter Fight:");
        System.out.println(swordsMan1.getName() + " Health: " + swordsMan1.getHealth());
        System.out.println(swordsMan2.getName() + " Health: " + swordsMan2.getHealth());
        System.out.println(magican1.getName() + " Health: " + magican1.getHealth());
        System.out.println(magican2.getName() + " Health: " + magican2.getHealth());

        System.out.println("\nHealing:");


        System.out.println("\nAfter Healing:");
        System.out.println(swordsMan1.getName() + " Health: " + swordsMan1.getHealth());
    }
}
