package lab5.models;

public class Coordinates {
    private float x;
    private double y; //Максимальное значение поля: 777

    public Coordinates(float f, double d) throws IllegalArgumentException {
        this.setX(f);
        this.setY(d);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(double y) throws IllegalArgumentException {
        if(y > 777) 
            throw new IllegalArgumentException("Error! the y value cannot be greater than 777");
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "{  x = " + Float.toString(x) + ";  y = " + Double.toString(y) + "  }";
    }

}