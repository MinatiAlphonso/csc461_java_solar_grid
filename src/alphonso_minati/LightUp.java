/*
 * Author: Minati Alphonso
 * Description:
 * The LightUp class implements the Visitor interface to light up bulbs
 * in the solar grid according to the number of adjacent panels (which
 * contributes to the brightness). If no adjacent panels, then the light
 * is BLACK, if 1 panel, then it is GREY, if 2 panels, then it is ORANGE,
 * if 3 panels, it is YELLOW, and if 4 panels, it is LIGHT_YELLOW.
 * */
package alphonso_minati;

public class LightUp implements Visitor{
    private Empty[][] c;
    private int total = 0;
    public LightUp(Empty[][] cells)
    {
        this.c = cells;
    }

    /*
    * acceptLight calls the visitAdj method to find the correct
    * object class where the acceptAdj method is invoked and the flow
    * of control is vectored to the correct Visitor subclass (CheckAdjacent).
    * */
    @Override
    public void acceptLight(LightBulb e, int x, int y) {
        Visitor av = new CheckAdjacent();

        if(x > 0)
            total += c[x-1][y].visitAdj(av);
        if(x < 4)
            total += c[x+1][y].visitAdj(av);
        if(y > 0)
            total += c[x][y-1].visitAdj(av);
        if(y < 4)
            total += c[x][y+1].visitAdj(av);
        e.setColor(getColor(total));
        total = 0;
    }
    @Override
    public void acceptLight(Empty e, int x, int y) { }
    @Override
    public void acceptLight(Greenspace e, int x, int y) { }
    @Override
    public void acceptLight(Panel e, int x, int y) { }

    /*
    * getColor sets the object's (light bulb) color according to number
    * of adjacent panels passed in.
    * */
    public ColorText.Color getColor(int c)
    {
        //c is the number of adjacent panels to a particular light bulb
        if(c == 1)
            return ColorText.Color.GRAY;
        if(c == 2)
            return ColorText.Color.ORANGE;
        if(c == 3)
            return ColorText.Color.YELLOW;
        if(c == 4)
            return ColorText.Color.LIGHT_YELLOW;
        return ColorText.Color.BLACK;
    }

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
    public int acceptAdj(LightBulb e) { return 0; }
    @Override
    public int acceptAdj(Empty e) { return 0; }
    @Override
    public int acceptAdj(Greenspace e) { return 0; }
    @Override
    public int acceptAdj(Panel e) { return 0; }

    @Override
    public void printCount() { }
}
