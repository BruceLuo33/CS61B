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
/**
 * An implementation of a motile pacifist photosynthesizer.
 *
 * @author Josh Hug
 */
public class Plip extends Creature {

    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * creates plip with energy equal to E.
     */
    public Plip(double e) {
        super("plip");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * creates a plip with energy equal to 1.
     */
    public Plip() {
        this(1);
    }

    /**
     * Should return a color with red = 99, blue = 76, and green that varies
     * linearly based on the energy of the Plip. If the plip has zero energy,
     * it should have a green value of 63. If it has max energy, it should
     * have a green value of 255. The green value should vary with energy
     * linearly in between these two extremes. It's not absolutely vital
     * that you get this exactly correct.
     */
    public Color color() {
        r = 99;
        b = 76;
        g = 96 * (int) energy + 63;
        if (g >= 255) {
            g = 255;
        }
        if (g <= 0) {
            g = 0;
        }
        return color(r, g, b);
    }

    /**
     * Do nothing with C, Plips are pacifists.
     */
    public void attack(Creature c) {
        // do nothing.
    }

    /**
     * Plips should lose 0.15 units of energy when moving. If you want to
     * to avoid the magic number warning, you'll need to make a
     * private static final variable. This is not required for this lab.
     */
    public void move() {
        // TODO
        double tmp = energy - 0.15;
        if ( tmp <= 0) {
            energy = 0;
        }
        else energy -= 0.15;
    }


    /**
     * Plips gain 0.2 energy when staying due to photosynthesis.
     */
    public void stay() {
        // TODO
        double tmp = energy + 0.2;
        if ( tmp >= 2) {
            energy = 2;
        }
        else energy += 0.2;

    }

    /**
     * Plips and their offspring each get 50% of the energy, with none
     * lost to the process. Now that's efficiency! Returns a baby
     * Plip.
     */
    public Plip replicate() {
        Plip offSpring = new Plip();
        offSpring.energy = energy / 2;
        energy = energy / 2;
        return offSpring;
    }

    /**
     * Plips take exactly the following actions based on NEIGHBORS:
     * 1. If no empty adjacent spaces, STAY.
     * 2. Otherwise, if energy >= 1, REPLICATE towards an empty direction
     * chosen at random.
     * 3. Otherwise, if any Cloruses, MOVE with 50% probability,
     * towards an empty direction chosen at random.
     * 4. Otherwise, if nothing else, STAY
     * <p>
     * Returns an object of type Action. See Action.java for the
     * scoop on how Actions work. See SampleCreature.chooseAction()
     * for an example to follow.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        boolean anyClorus = false;
        // TODO
        // (Google: Enhanced for-loop over keys of NEIGHBORS?)
        /** k.name() is not equals to neighbors.get(k).name()
         * 1. k.name() would be BOTTOM/RIGHT/LEFT/TOP
         *    neighbot.get(k).name will be empty/impassible
         * 2. More general, the k.name will be the same as parameters in <Direction>
         *    while the neighbor.get(k).name() will be the same as the main() function given
         * */
        for (Direction k : neighbors.keySet()) {
//            System.out.println("k,name()" + k.name());
//            System.out.println(neighbors.get(k).name());
            if (neighbors.get(k).name().equals("empty")) {
                emptyNeighbors.addLast(k);
            } else if (neighbors.get(k).name().equals("clorus")) {
                anyClorus = true;
            }

        }
//         for ( Map.Entry<Direction, Occupant> entry: neighbors.entrySet()) {
//            Direction d = entry.getKey();
//            Occupant o = entry.getValue();
//         }
        if (emptyNeighbors.size() == 0) { // FIXME
            // TODO
            return new Action(Action.ActionType.STAY);
        } else if (energy >= 1) {
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        } else if (anyClorus && emptyNeighbors.size()>=1 && Math.random() >= 0.5 ) {
            return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
        } else return new Action(Action.ActionType.STAY);


        // Rule 2
//         HINT: randomEntry(emptyNeighbors)
//        if (this.energy >= 1) {
//            Plip tmp = this.replicate();
//            Random generator = new Random();
//            Object[] values = emptyNeighbors.toArray();
//            Direction randomD = (Direction) values[generator.nextInt(values.length)];
//            return new Action(Action.ActionType.MOVE, randomD);
//        }


        // Rule 3


        // Rule 4
    }
}
