package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.nio.channels.Pipe;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Random;
import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends Creature {

    /** Override the name method from the Occupant class*/
    @Override
    public String name() {
        return "clorus";
    }

    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * creates a Clorus with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    public void move() {
        double tmp = energy - 0.03;
        if ( tmp <= 0) {
            energy = 0;
        }
        else energy -= 0.03;
    }


    /**
     * Plips gain 0.2 energy when staying due to photosynthesis.
     */
    public void stay() {
        // TODO
        double tmp = energy - 0.01;
        if ( tmp <= 0) {
            energy = 0;
        }
        else energy -= 0.01;

    }


    /**Cloruses have the exactly same color*/
    private int r;
    private int g;
    private int b;
    public Color color() {
        r = 34;
        b = 231;
        g = 0;
        return color(r, g, b);
    }

    public void attack(Creature c) {
        energy = c.energy();
    }

    public Clorus replicate() {
    // Do nothing.
        Clorus offSpring = new Clorus();
        offSpring.energy = this.energy / 2;
        this.energy = this.energy / 2;
        return offSpring;
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        return new Action(Action.ActionType.STAY);
    }


}
