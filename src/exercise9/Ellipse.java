package exercise9;

public class Ellipse {
  private Point startPoint;
    private double halbachseA;
    private double halbachseB;

    public Ellipse() {
        startPoint = new Point(0, 0);
        halbachseA = 1;
        halbachseB = 1;
    }

    public Ellipse(Point startPoint, double halbachseA, double halbachseB) {
        this.startPoint = new Point(startPoint);
        this.halbachseA = halbachseA;
        this.halbachseB = halbachseB;
    }

     public Ellipse(Ellipse otherEllipse) {
        startPoint = new Point(otherEllipse.startPoint);
        halbachseA = otherEllipse.halbachseA;
        halbachseB = otherEllipse.halbachseB;
    }

    public boolean isValid() {
        return halbachseA > 0 && halbachseB > 0;
    }

    public void initialize() {
        do {
            System.out.println("Start point: ");
            startPoint.initialize();
            System.out.print("Enter a: ");
            halbachseA = Utils.INPUT.nextDouble();
            System.out.print("Enter b: ");
            halbachseB = Utils.INPUT.nextDouble();
        } while (!isValid());
    }

    public double calculatePerimeter() {
        return Math.PI*(3*(halbachseA+halbachseB) - Math.sqrt((3*halbachseA + halbachseB)*(halbachseA + 3*halbachseB)));
    }

    public double calculateArea() {
        return Math.PI * halbachseA*halbachseB;
    }

     public String getType() {
        return (halbachseA == halbachseB) ? "Cycle" : "Ellipse";
    }

     public String toString() {
        return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, halbachseA, halbachseB, getType(), calculatePerimeter(), calculateArea());
    }

     public boolean equal(Ellipse otherEllipse) {
        boolean sameA = Utils.equals(halbachseA, otherEllipse.halbachseA);
        boolean sameB = Utils.equals(halbachseB, otherEllipse.halbachseB);
        boolean sameAReversed = Utils.equals(halbachseA, otherEllipse.halbachseB);
        boolean sameBReversed = Utils.equals(halbachseB, otherEllipse.halbachseA);

        return (sameA && sameB) || (sameAReversed && sameBReversed);
    }
}
