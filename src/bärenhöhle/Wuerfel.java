package bärenhöhle;

import java.util.Random;

/**
 *
 * @author Gergö Szijarto
 */
public class Wuerfel {

    private int augen;

    public int wuerfle() {
        Random rand = new Random();
        int toReturn = rand.nextInt(6) + 1;
        augen = toReturn;
        return toReturn + 1;
    }

    public int getAugen() {
        return augen;
    }

    public int getAugenOnOtherSide(int num) {
        return 7 - num;
    }

}
