/*
 * Author: Minati Alphonso
 * Description:
 * This is the Visitor Interface.
 * */
package alphonso_minati;

public interface Visitor {
    void accept(Empty e);
    void accept(Greenspace e);
    void accept(LightBulb e);
    void accept(Panel e);

    void accept(Empty e, int c);
    void accept(Greenspace e, int c);
    void accept(LightBulb e, int c);
    void accept(Panel e, int c);

    void acceptLight(LightBulb e, int x, int y);
    void acceptLight(Empty e, int x, int y);
    void acceptLight(Greenspace e, int x, int y);
    void acceptLight(Panel e, int x, int y);

    int acceptAdj(LightBulb e);
    int acceptAdj(Empty e);
    int acceptAdj(Greenspace e);
    int acceptAdj(Panel e);

    void printCount();
}


