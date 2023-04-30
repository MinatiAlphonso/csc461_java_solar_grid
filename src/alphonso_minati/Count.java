/*
 * Author: Minati Alphonso
 * Description:
 * The Count class implements the Visitor interface to count the number of
 * each type of object.
 * */
package alphonso_minati;

public class Count implements Visitor{
    private int eCount = 0, gCount = 0, lCount = 0, pCount = 0;

    @Override
    public void accept(Empty e) { eCount++; }
    @Override
    public void accept(Greenspace e) { gCount++; }
    @Override
    public void accept(LightBulb e) { lCount++; }
    @Override
    public void accept(Panel e) { pCount++; }

    /*
    * printCount prints out the number of each type of object contained
    * in the solar grid.
    * */
    public void printCount()
    {
        System.out.println("Empty: " + eCount);
        System.out.println("Greenspaces: " + gCount);
        System.out.println("Panel: " + pCount);
        System.out.println("Light: " + lCount);

        //resetting the count variables to zero
        eCount = 0;
        gCount = 0;
        pCount = 0;
        lCount = 0;
    }

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
    public int acceptAdj(Panel e) {
        return 0;
    }
}
