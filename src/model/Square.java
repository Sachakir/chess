package model;

public class Square {
    public int letter;
    public int number;

    public Square(int letter, int number)
    {
        this.number = number;
        this.letter = letter;
    }

    public boolean insideBoard()
    {
        if (letter < 0 || letter > 7 || number < 0 || number > 7)
        {
            return false;
        }
        return true;
    }
}
