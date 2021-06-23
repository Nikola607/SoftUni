package WorkingWithAbstraction.PointInRectangle;

import java.awt.*;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public boolean contains(Point point){
        boolean isHorizontal = getBottomLeft().getX() <= point.getX() &&
                getTopRight().getX() >= point.getX();

        boolean isVertical = getBottomLeft().getY() <= point.getY() &&
                getTopRight().getY() >= point.getY();

        return isHorizontal && isVertical;
    }
}
