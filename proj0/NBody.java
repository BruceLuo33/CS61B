public class NBody {
/** This class is aim to simulate the law of Universal Graviation*/
    public static double readRadius(String filename) {
        In in = new In(filename);
        int number = in.readInt();
        double radius_uni = in.readDouble();
        return radius_uni;
    }

    public static Planet[] readPlanets(String filename) {
        if (filename.isEmpty()) {
            System.out.println("Please supply a country as a command line argument.");
            System.out.println("For countries with spaces, use an underscore, e.g. South_Korea");
			/* NOTE: Please don't use System.exit() in your code.
			   It will break the autograder. */
//            System.exit(0);
        }

        In in2 = new In(filename);
        int number2 = in2.readInt();
        Planet[] allstars = new Planet[number2];
        double radius_uni2 = in2.readDouble();
        int count = 0;
        while (count < number2) {
            allstars[count].xxPos = in2.readDouble();
            allstars[count].yyPos = in2.readDouble();
            allstars[count].xxVel = in2.readDouble();
            allstars[count].yyVel = in2.readDouble();
            allstars[count].mass = in2.readDouble();
            allstars[count].imgFileName = in2.readString();
            count++;
        }
        return allstars;
    }

}
