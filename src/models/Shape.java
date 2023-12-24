package models;

import java.util.ArrayList;
import java.util.List;

public class Shape {

    private List<Points> validShape;
    private List<Points> points = new ArrayList<>();

    public void addPoint(Points point){
        points.add(point);
    }

    public static List<List<Points>> getAllValidShapes(List<Points> points) {
        List<List<Points>> validShapes = new ArrayList<>();
        generateValidShapes(validShapes, new ArrayList<>(), points);
        return validShapes;
    }

    private static void generateValidShapes(List<List<Points>> validShapes, List<Points> currentShape, List<Points> remainingPoints) {
        if (remainingPoints.isEmpty()) {
            validShapes.add(new ArrayList<>(currentShape));
            return;
        }

        Points lastPoint = currentShape.isEmpty() ? null : currentShape.get(currentShape.size() - 1);

        for (int i = 0; i < remainingPoints.size(); i++) {
            Points currentPoint = remainingPoints.get(i);

            if (lastPoint == null || !lastPoint.equals(currentPoint)) {
                List<Points> newShape = new ArrayList<>(currentShape);
                newShape.add(currentPoint);

                List<Points> newRemainingPoints = new ArrayList<>(remainingPoints);
                newRemainingPoints.remove(i);

                generateValidShapes(validShapes, newShape, newRemainingPoints);
            }
        }
    }

    public void buildShape() {
        List<List<Points>> validShapes = getAllValidShapes(points);
        validShape = validShapes.get(0);
    }

    public double calculatePerimeter() {
        double perimeter = 0.0;
        List<Points> points = validShape;
        for (int i = 0; i < points.size(); i++) {
            Points currentPoint = points.get(i);
            Points nextPoint = points.get((i + 1) % points.size());

            double distance = currentPoint.getDistance(nextPoint);
            perimeter += distance;
        }

        return perimeter;
    }

    public double getLongestSide() {
        double longestSide = 0.0;
        List<Points> points = validShape;
        for (int i = 0; i < points.size(); i++) {
            Points currentPoint = points.get(i);
            Points nextPoints = points.get((i + 1) % points.size());

            double distance = currentPoint.getDistance(nextPoints);
            longestSide = Math.max(longestSide, distance);
        }

        return longestSide;
    }

    public double getAverageSide() {
        double totalDistance = 0.0;
        List<Points> points = validShape;
        for (int i = 0; i < points.size(); i++) {
            Points currentPoint = points.get(i);
            Points nextPoint = points.get((i + 1) % points.size());

            double distance = currentPoint.getDistance(nextPoint);
            totalDistance += distance;
        }

        return totalDistance / points.size();
    }
}