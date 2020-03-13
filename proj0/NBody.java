import examples.StdDraw;

public class NBody {
    /** This class is aim to simulate the law of Universal Graviation*/
    public static double readRadius(String filename) {
        In in = new In(filename);
        int number = in.readInt();
        double radius_uni = in.readDouble();
        return radius_uni;
    }

    public static Planet[] readPlanets(String filename) {
        In in2 = new In(filename);
        int number2 = in2.readInt();
        Planet[] allstars = new Planet[number2];
        in2.readDouble();
        int count = 0;
        while (count < number2) {
            double xP = in2.readDouble();
            double yP = in2.readDouble();
            double xV = in2.readDouble();
            double yV = in2.readDouble();
            double mass = in2.readDouble();
            String name = in2.readString();
            allstars[count] = new Planet(xP, yP, xV, yV, mass, name);
            count++;
        }
        return allstars;
    }

    public static void main(String[] args) {
        // Read the args[] and planets file
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double uniRadius = readRadius(filename);
        Planet[] stars = readPlanets(filename);
//        System.out.println(uniRadius);
//        System.out.println(stars[0].mass);

        // Draw the background of universe
        StdDraw.setScale(-uniRadius, uniRadius);
//        StdDraw.setScale(-100,100);
        StdDraw.clear();
        String imageName = "images/starfield.jpg";
        StdDraw.picture(0,0, imageName);
//        StdDraw.show();
//        StdDraw.pause(2000);
//        int count = 0;
        int number = stars.length;
        for (int count = 0; count < number; count++) {
//            Planet.draw(stars[count]);
            stars[count].draw();
        }


        //Enable double buffering
        StdDraw.enableDoubleBuffering();

        for (double timer = 0; timer < T; timer += dt) {
            double[] xForces = new double[number];
            double[] yForces = new double[number];
//            StdDraw.setScale(-uniRadius, uniRadius);
//            StdDraw.clear();
            StdDraw.picture(0,0, imageName);
//            StdDraw.show();
            for (int count = 0; count < number; count++) {
                xForces[count] = stars[count].calcNetForceExertedByX(stars);
                yForces[count] = stars[count].calcNetForceExertedByY(stars);
                stars[count].update(dt, xForces[count], yForces[count]);
                stars[count].draw();
//                Planet.draw(stars[count]);

//                StdDraw.pause(1000);
//                StdDraw.picture(stars[count].xxPos, stars[count].yyPos, stars[count].imgFileName);
            }
            StdDraw.show();
            StdDraw.pause(10);


        }

        StdOut.printf("%d\n", stars.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < stars.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    stars[i].xxPos, stars[i].yyPos, stars[i].xxVel,
                    stars[i].yyVel, stars[i].mass, stars[i].imgFileName);
        }

    }

}