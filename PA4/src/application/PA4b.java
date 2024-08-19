package application;

public class PA4b {

    public static void main(String[] args) {
        if (args.length != 7) {
            System.out.println("Please supply correct inputs: color x1 y1 x2 y2 x3 y3");
            return;
        }

        String color = args[0];
        try {
            double x1 = Double.parseDouble(args[1]);
            double y1 = Double.parseDouble(args[2]);
            double x2 = Double.parseDouble(args[3]);
            double y2 = Double.parseDouble(args[4]);
            double x3 = Double.parseDouble(args[5]);
            double y3 = Double.parseDouble(args[6]);

            Point2D p1 = new Point2D(x1, y1);
            Point2D p2 = new Point2D(x2, y2);
            Point2D p3 = new Point2D(x3, y3);
            Triangle triangle = new Triangle(p1, p2, p3);

            String csv = shapeVertices(triangle, color);
            System.out.println(csv);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please provide valid numbers.");
        }
    }

    public static String shapeVertices(Shape2D shape, String color) {
        StringBuilder csv = new StringBuilder();

        if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            for (Point2D vertex : triangle.getVertices()) {
                csv.append(String.format("\"%s\",%.3f,%.3f%n", color, vertex.getX(), vertex.getY()));
            }
            Point2D[] aabb = triangle.getAABB();
            for (Point2D vertex : aabb) {
                csv.append(String.format("\"%s\",%.3f,%.3f%n", color, vertex.getX(), vertex.getY()));
            }
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            for (Point2D vertex : rectangle.getVertices()) {
                csv.append(String.format("\"%s\",%.3f,%.3f%n", color, vertex.getX(), vertex.getY()));
            }
        }

        return csv.toString();
    }
}

