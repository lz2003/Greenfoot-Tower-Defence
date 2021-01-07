/**
 * Class to represent a point in two dimensional space
 */
public class Point {
    public float x, y;

    /**
     * Creates a point
     *
     * @param x Location in x-axis
     * @param y Location in y-axis
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a point
     *
     * @param x Location in x-axis
     * @param y Location in y-axis
     */
    public Point(int x, int y) {
        this.x = (float) x;
        this.y = (float) y;
    }

    /**
     * Translates the point
     * @param x X-axis translation
     * @param y Y-axis translation
     */
    public void translate(float x, float y) {
        this.x += x; this.y += y;
    }

    /**
     * Rotate point around another point
     * @param point Point to rotate around
     * @param radians Degree to rotate
     */
    public void rotate(Point point, float radians) {
        clone(Point.rotate(point, this, radians), this);
    }

    /**
     * Scale point relative to another point
     *
     * @param point Relative point to scale from
     * @param scale Amount to scale by
     */
    public void scale(Point point, float scale) {
        clone(Point.scale(point, this, scale), this);
    }

    /**
     * Distance from other point
     *
     * @param b Other point
     * @return Distance
     */
    public float distance(Point b) {
        return Point.distance(this, b);
    }

    /**
     * Squared distance from other point
     *
     * @param b Other point
     * @return Squared distance
     */
    public float distanceSquared(Point b) {
        return Point.distanceSquared(this, b);
    }

    /**
     * Distance from other point
     * @param a Point a
     * @param b Point b
     * @return Distance
     */
    public static float distance(Point a, Point b) {
        return Math2D.distance(a.x, b.x, a.y, b.y);
    }

    /**
     * Square of the distance from other point
     *
     * @param a Point a
     * @param b Point b
     * @return Squared distance
     */
    public static float distanceSquared(Point a, Point b) {
        return Math2D.distanceSquared(a.x, b.x, a.y, b.y);
    }

    // Rotate point around other point
    private static Point rotate(Point point, Point vector, float radians) {
        float ox = point.x, oy = point.y;
        float px = vector.x, py = vector.y;

        // Get x and y components of angle
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);

        // Translate to origin
        px -= ox;
        py -= oy;

        // Perform rotation, then translate back from origin
        return new Point(
                px * cos - py * sin + ox,
                px * sin + py * cos + oy
        );
    }

    // Scale point relative to other point
    private static Point scale(Point point, Point vector, float scale) {
        float ox = point.x, oy = point.y;
        float px = vector.x, py = vector.y;

        // Translate to origin
        px -= ox;
        py -= oy;

        // Scale and translate back from origin
        return new Point(
                px * scale + ox,
                py * scale + oy
        );
    }

    // Clone point
    private static void clone(Point original, Point cloned) {
        cloned.x = original.x;
        cloned.y = original.y;
    }
}