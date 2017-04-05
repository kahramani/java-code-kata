package sandpit;

import helper.Chronometer;

/**
 * Created by kahramani on 3/15/2017.
 */
public class ExcessiveGarbageCollectionExample {

    public static void main(String[] args) {
        Chronometer cr = new Chronometer();
        cr.start();
        System.out.println("First started...");
        String oneMillionHello = "";
        for (int i = 0; i < 10000; i++) {
            oneMillionHello = oneMillionHello + "Hello!";
        }
        cr.stop();
        System.out.println("First finished. Took " + cr.getDuration());

        cr.clear();
        cr.start();
        System.out.println("Second started...");
        StringBuilder oneMillionHelloSB = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            oneMillionHelloSB.append("Hello!");
        }
        cr.stop();
        System.out.println("Second finished. Took " + cr.getDuration());
    }
}
