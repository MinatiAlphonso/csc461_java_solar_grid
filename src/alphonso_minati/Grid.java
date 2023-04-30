/*
* Author: Minati Alphonso
* Description:
* The Grid class basically manages the entire solar grid. It is here
* where the visitor is called.
* */
package alphonso_minati;

public class Grid {
    private int x, y;
    private Empty[][] cells = {{new Empty(),new Empty(),new Empty(),new Empty(),new Empty()},
            {new Empty(),new Empty(),new Empty(),new Empty(),new Empty()},
            {new Empty(),new Empty(),new Empty(),new Empty(),new Empty()},
            {new Empty(),new Empty(),new Empty(),new Empty(),new Empty()},
            {new Empty(),new Empty(),new Empty(),new Empty(),new Empty()}};
    private Empty[][] dcells = {{new Panel(),new Panel(),new Panel(),new Empty(),new Greenspace()},
            {new LightBulb(),new LightBulb(),new LightBulb(),new Panel(),new Empty()},
            {new Empty(),new Panel(),new Panel(),new LightBulb(),new Panel()},
            {new Empty(),new Empty(),new Empty(),new Panel(),new Empty()},
            {new Greenspace(),new LightBulb(),new Empty(),new Empty(),new Greenspace()}};

    public Grid(){}

    Visitor cv = new Count();
    Visitor v = new Color();

    //GRADING: NESTED
    /*
     * lightItUp calls the visitLight method to find the correct
     * object class where the acceptLight method is invoked and the flow
     * of control is vectored to the correct Visitor subclass (LightUp).
     * Additionally, this has a nested Visitor (CheckAdjacent)
     * */
    public String lightItUp()
    {
        Visitor lv = new LightUp(cells);
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                cells[i][j].visitLight(lv, i, j);
        return solarGrid();
    }

    //GRADING: COLOR
    /*
     * changeColor calls the visit method to find the correct
     * object class where the accept method is invoked and the flow
     * of control is vectored to the correct Visitor subclass (Color).
     * */
    public String changeColor(int c, char t)
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++) {
                if(cells[i][j].getChar() == t)
                    cells[i][j].visit(v, c);
            }
        }
        return solarGrid();
    }

    //GRADING: COUNT
    /*
     * countElements calls the visit method to find the correct
     * object class where the accept method is invoked and the flow
     * of control is vectored to the correct Visitor subclass (Count).
     * */
    public void countElements()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
                cells[i][j].visit(cv);
        }
        cv.printCount();
    }

    /*
    * changeToDef sets the current grid to the default setup.
    * */
    public void changeToDef() { cells = dcells; }

    /*
    * remove removes an object from the specified grid location and
    * inserts an empty space in its place.
    * */
    public String remove(int x, int y)
    {
        cells[y][x] = new Empty();
        return solarGrid();
    }

    /*
    * getType inserts a specified object at the specified grid location.
    * */
    public String getType(String t)
    {
        switch (t) {
            case "e":
                cells[getY()][getX()] = new Empty();
                break;
            case "g":
                cells[getY()][getX()] = new Greenspace();
                break;
            case "l":
                cells[getY()][getX()] = new LightBulb();
                break;
            case "p":
                cells[getY()][getX()] = new Panel();
                break;
        }
        return solarGrid();
    }

    /*
     * solarGrid prints out the entire solar grid.
     */
    public String solarGrid() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
                str.append(ColorText.colorString(cells[i][j].getChar(), cells[i][j].getColor()));
            str.append("\n");
        }
        return str.toString();
    }

    public void setX(int xLoc){x = xLoc;}
    public void setY(int yLoc){y = yLoc;}
    public int getX() {return x;}
    public int getY() {return y;}
}
