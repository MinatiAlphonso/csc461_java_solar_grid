/*
 * Author: Minati Alphonso
 * Description:
 * The CheckAdjacent class implements the Visitor interface to check how
 * many solar panels are adjacent to a particular light bulb.
 * */
package alphonso_minati;

public class CheckAdjacent implements Visitor{

    @Override
    public int acceptAdj(LightBulb e) {
        return 0;
    }
    @Override
    public int acceptAdj(Empty e) {
        return 0;
    }
    @Override
    public int acceptAdj(Greenspace e) {
        return 0;
    }
    @Override
    public int acceptAdj(Panel e) { return 1; }

    @Override
    public void accept(Empty e) { }
    @Override
    public void accept(Greenspace e) { }
    @Override
    public void accept(LightBulb e) { }
    @Override
    public void accept(Panel e) { }

    @Override
    public void accept(Empty e, int c) { }
    @Override
    public void accept(Greenspace e, int c) { }
    @Override
    public void accept(LightBulb e, int c) { }
    @Override
    public void accept(Panel e, int c) { }

    @Override
    public void acceptLight(LightBulb e, int x, int y) { }
    @Override
    public void acceptLight(Empty e, int x, int y) { }
    @Override
    public void acceptLight(Greenspace e, int x, int y) { }
    @Override
    public void acceptLight(Panel e, int x, int y) { }

    @Override
    public void printCount() { }
}
