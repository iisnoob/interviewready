package designpatterns.prototype.example;

public class Main {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();

        GameBotCharacter gbc1 = new GameBotCharacter("Bot1", 100, 0);
        GameBotCharacter gbc2 = gbc1.customizedClone();
        gbc2.setName("Bot2");
        GameBotCharacter gbc3 = gbc1.customizedClone();
        gbc3.setName("Bot3");
        GameBotCharacter gbc4 = gbc1.customizedClone();
        gbc4.setName("Bot4");
        GameBotCharacter gbc5 = gbc1.customizedClone();
        gbc5.setName("Bot5");

        System.out.println(gbc1);
        System.out.println(gbc2);
        System.out.println(gbc3);
        System.out.println(gbc4);
        System.out.println(gbc5);

        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - starTime) / 1000.0 + " seconds");
    }
}
