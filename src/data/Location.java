package data;

public class Location {
    private long x;
    private double y;
    private float z;
    private String name; //Строка не может быть пустой, Поле не может быть null

    public void setX(long x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public float getZ() {
        return this.z;
    }

    public String getName() {
        return this.name;
    }
}