import models.Points;
import models.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C://Users//yksli//IdeaProjects//assignment1//src//source");

        Scanner sc = new Scanner(file);
        Shape shape = new Shape();

        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Points point = new Points(x, y);
            shape.addPoint(point);
        }
        shape.buildShape();
        System.out.println(shape.calculatePerimeter());
        System.out.println(shape.getLongestSide());
        System.out.println(shape.getAverageSide());
        sc.close();
    }
}