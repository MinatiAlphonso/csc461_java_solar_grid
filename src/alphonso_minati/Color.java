/*
 * Author: Minati Alphonso
 * Description:
 * The Color class implements the Visitor interface to change the color
 * of a type of object.
 * */
package alphonso_minati;

public class Color implements Visitor {

    @Override
    public void accept(Empty e, int c) { e.setColor(getColor(c)); }
    @Override
    public void accept(Greenspace e, int c) { e.setColor(getColor(c)); }
    @Override
    public void accept(LightBulb e, int c) { e.setColor(getColor(c)); }
    @Override
    public void accept(Panel e, int c) { e.setColor(getColor(c)); }

    /*
    * getColor sets the object color upon the user's request.
    * */
    public ColorText.Color getColor(int c)
    {
        if(c == 1)
            return ColorText.Color.RED;
        if(c == 2)
            return ColorText.Color.YELLOW;
        if(c == 3)
            return ColorText.Color.BLUE;
        if(c == 4)
            return ColorText.Color.GREEN;
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

    @Override
    public void printCount() { }
}
