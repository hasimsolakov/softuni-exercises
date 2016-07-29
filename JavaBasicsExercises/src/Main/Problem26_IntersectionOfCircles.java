package Main;

import java.util.Scanner;

public class Problem26_IntersectionOfCircles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstCircleX = scanner.nextInt();
        int firstCircleY = scanner.nextInt();
        int firstCircleRadius = scanner.nextInt();
        int secondCircleX = scanner.nextInt();
        int secondCircleY = scanner.nextInt();
        int secondCircleRadius = scanner.nextInt();
        Point firstCircleCenter = new Point(firstCircleX, firstCircleY);
        Point secondCircleCenter = new Point(secondCircleX, secondCircleY);
        Circle firstCircle = new Circle(firstCircleCenter, firstCircleRadius);
        Circle secondCircle = new Circle(secondCircleCenter, secondCircleRadius);
        boolean circlesIntersect = Circle.intersect(firstCircle, secondCircle);
        System.out.println(circlesIntersect ? "Yes" : "No");
    }
}

final class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int getY() {
        return y;
    }

    private int getX() {
        return x;
    }

    static double getDistance(Point a, Point b){
        double firstVar = Math.pow(a.getX() - b.getX(), 2);
        double secondVar = Math.pow(a.getY() - b.getY(), 2);
       return Math.sqrt(firstVar + secondVar);
    }
}

final class Circle {
    private final Point center;
    private final int radius;

    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public final Point getCenter() {
        return center;
    }

    private int getRadius() {
        return radius;
    }

    static boolean intersect(Circle c1, Circle c2){
        double distanceBetweenCirclesCenters = Point.getDistance(c1.center, c2.center);
        double radiusesSum = c1.getRadius() + c2.getRadius();
        return distanceBetweenCirclesCenters <= radiusesSum;
    }
}

