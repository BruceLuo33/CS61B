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
//        return "clorus";
        return super.name();
    }



    /**Cloruses have the exactly same color*/
    private int r;
    private int g;
    private int b;
    @Override
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return color(r, g, b);
    }

    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    /**
     * creates a Clorus with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    /**The energy of clorus does not need to be greater than zero.
     * Otherwise it will not disappear, but continue to fill in the whole grid.*/
    @Override
    public void move() {
        energy -= 0.03;
//        if ( energy < 0) {
//            energy = 0;
//        }
    }

    /**The energy of clorus does not need to be greater than zero.
     * Otherwise it will not disappear, but continue to fill in the whole grid.*/
    @Override
    public void stay() {
        energy -= 0.01;
//        if ( energy < 0) {
//            energy = 0;
//        }
    }

    /**When Clorus attacks another creature c, it will gain all of the energy of c*/
    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    @Override
    public Clorus replicate() {
        Clorus offSpring = new Clorus();
        offSpring.energy = energy / 2;
        energy = energy / 2;
        return offSpring;
    }

    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();
        boolean anyPlip = false;

        for (Direction k : neighbors.keySet()) {
//            System.out.println("k,name()" + k.name());
//            System.out.println(neighbors.get(k).name());
            if (neighbors.get(k).name().equals("empty")) {
                emptyNeighbors.addLast(k);
            } else if (neighbors.get(k).name().equals("plip")) {
                anyPlip = true;
                plipNeighbors.addLast(k);
            }
        }

        if (emptyNeighbors.size() == 0) {
            return new Action(Action.ActionType.STAY);
        } else if (anyPlip) {
            return new Action(Action.ActionType.ATTACK, randomEntry(plipNeighbors));
        } else if (energy >= 1.0) {
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        }
        return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
    }


}
