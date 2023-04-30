/*
 * Author: Minati Alphonso
 * Description:
 * The LightBulb class handles light bulbs (✦) in the solar grid.
 * */
package alphonso_minati;

public class LightBulb extends Empty{
    private ColorText.Color color;

    public LightBulb(){ this.color = ColorText.Color.BLACK; }

    public void setColor(ColorText.Color color) { this.color = color; }
    public ColorText.Color getColor() { return color; }

    public char getChar() { return '✦'; }

    public void visit(Visitor v) { v.accept(this); } //Count
    public void visit(Visitor v, int c) { v.accept(this, c); } //Color
    public void visitLight(Visitor lv, int x, int y) { lv.acceptLight(this, x, y); } //LightUp
    public int visitAdj(Visitor lv) { return lv.acceptAdj(this); } //CheckAdjacent
}
