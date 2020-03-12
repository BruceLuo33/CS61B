import examples.StdDraw;

public class Planet {

    public double xxPos; /*Its current x position*/
    public double yyPos; /*Its current y position*/
    public double xxVel; /*Its current velocity in the x direction*/
    public double yyVel; /*Its current velocity in the y direction*/
    public double mass; /*Its mass*/
    public String imgFileName; /*The name of the file that corresponds to the image that depicts the planet*/

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass =  m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }


    public double calcDistance(Planet p) {
        Planet tmp = this;
        double xDis;
        double yDis;
        xDis = tmp.xxPos - p.xxPos;
        yDis = tmp.yyPos - p.yyPos;
        return Math.sqrt(xDis*xDis + yDis*yDis);
    }

    public double calcForceExertedBy(Planet p) {
        Planet force_tmp = this;
        final  double g_constant;
        g_constant = 6.67e-11;
        double dis = force_tmp.calcDistance(p);
        double force = g_constant*force_tmp.mass*p.mass/(dis*dis);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        Planet tmp_byX = this;
        double dis_byX = tmp_byX.calcDistance(p);
        double force_byX = tmp_byX.calcForceExertedBy(p);
        double x_dis = p.xxPos - tmp_byX.xxPos;
        double x_cos = x_dis / dis_byX;
        double force_x = force_byX*x_cos;
        return force_x;
    }


    public double calcForceExertedByY(Planet p) {
        Planet tmp_byY = this;
        double dis_byY = tmp_byY.calcDistance(p);
        double force_byY = tmp_byY.calcForceExertedBy(p);
        double y_dis = p.yyPos - tmp_byY.yyPos;
        double y_sin = y_dis / dis_byY;
        double force_y = force_byY*y_sin;
        return force_y;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        Planet calc_Net_X = this;
        int num_PlanetsX = allPlanets.length;
        double force_x_allPlanets = 0;
        for (int i = 0; i<num_PlanetsX; i++) {
            if (calc_Net_X != allPlanets[i]) {
                force_x_allPlanets = force_x_allPlanets + calc_Net_X.calcForceExertedByX(allPlanets[i]);
            }
        }
        return force_x_allPlanets;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        Planet calc_Net_Y = this;
        int num_PlanetsY = allPlanets.length;
        double force_y_allPlanets = 0;
        for (int i = 0; i<num_PlanetsY; i++) {
            if (calc_Net_Y != allPlanets[i]) {
                force_y_allPlanets = force_y_allPlanets + calc_Net_Y.calcForceExertedByY(allPlanets[i]);
            }
        }
        return force_y_allPlanets;
    }


    public void update(double dt, double fX, double fY) {
        // index[1] is the x-direction force, index[2] is the y-direction force
        Planet updateIndex = this;
        double ax = fX / updateIndex.mass;
        double ay = fY / updateIndex.mass;
        updateIndex.xxVel = updateIndex.xxVel  + ax*dt;
        updateIndex.yyVel = updateIndex.yyVel + ay*dt;
        updateIndex.xxPos = updateIndex.xxPos + updateIndex.xxVel*dt;
        updateIndex.yyPos = updateIndex.yyPos + updateIndex.yyVel*dt;
    }

    public static void draw(Planet starName) {
        String tmpName = "images/";
        tmpName = tmpName + starName.imgFileName;
        StdDraw.picture(starName.xxPos,starName.yyPos, tmpName);
//        StdDraw.enableDoubleBuffering();
//        StdDraw.show();
    }


}
