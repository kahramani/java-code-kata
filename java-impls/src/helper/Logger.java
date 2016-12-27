package helper;

/**
 * Created by kahramani on 12/27/2016.
 */
public class Logger {

    Class c;
    Chronometer chronometer;

    public Logger(Class c) {
        this.c = c;
        this.chronometer = new Chronometer();
    }

    public Logger(Class c, Chronometer chronometer) {
        this.c = c;
        this.chronometer = chronometer;
    }

    public void start() {
        if(this.c == null)
            throw new NullPointerException("Solution class must not be null");
        if(this.chronometer == null)
            throw new NullPointerException("Chronometer must not be null");

        System.out.println(this.c.getName() + " started...");
        this.chronometer.start();
    }

    public <T extends CharSequence> void result(T t) {
        System.out.println("Result: " + t);
    }

    public void end() {
        if(this.c == null)
            throw new IllegalArgumentException("Solution name must not be null or empty");
        if(this.chronometer == null)
            throw new NullPointerException("Chronometer must not be null");

        this.chronometer.stop();
        System.out.println(this.c.getName() + " ended... It took " + this.chronometer.getDuration() + ".");
        this.chronometer.clear();
    }
}
