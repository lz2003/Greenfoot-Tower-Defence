public class Math2D {
    public static float PI = 3.141592f;

    /**
     * Calculates the distance of two locations.
     *
     * @param ax        the first x location
     * @param bx        the second x location
     * @param ay        the first y location
     * @param by        the second y location
     * @return int      the distance
     */
    public static float distance(float ax, float bx, float ay, float by) {
        return (float) Math.sqrt(distanceSquared(ax, bx, ay, by));
    }

    /**
     * Calculates the distance of two locations and squares it.
     *
     * @param ax        the first x location
     * @param bx        the second x location
     * @param ay        the first y location
     * @param by        the second y location
     * @return int      the distance
     */
    public static float distanceSquared(float ax, float bx, float ay, float by) {
        return (float) (Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }

    /**
     * Calculates the distance of two locations.
     *
     * @param ax        the first x location
     * @param bx        the second x location
     * @param ay        the first y location
     * @param by        the second y location
     * @return int      the distance
     */
    public static float distance(int ax, int bx, int ay, int by) {
        return (float) Math.sqrt(distanceSquared(ax, bx, ay, by));
    }

    /**
     * Calculates the distance of two locations and squares it.
     *
     * @param ax        the first x location
     * @param bx        the second x location
     * @param ay        the first y location
     * @param by        the second y location
     * @return int      the distance
     */
    public static float distanceSquared(int ax, int bx, int ay, int by) {
        return (float) (Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }

    /**
     * Calculates the distance of two locations.
     *
     * @param fromX       the x location to calculate from
     * @param toX         the x location to calculate the angle to
     * @param fromY       the y location to calculate from
     * @param toX         the y location to calculate the angle to
     * @return float      the angle in radians
     */
    public static float angleTo(float fromX, float toX, float fromY, float toY) {
        return (float) Math.atan2((toY - fromY), (toX - fromX));
    }
    
            /**
     * Clamps a number between two values
     *
     * @param value Number to clamp
     * @param min Minimum value
     * @param max Maximum value
     * @return Clamped value
     */
    public static int clamp(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }

    /**
     * Clamps a number between two values
     *
     * @param value Number to clamp
     * @param min Minimum value
     * @param max Maximum value
     * @return Clamped value
     */
    public static float clamp(float value, float min, float max) {
        return Math.min(Math.max(value, min), max);
    }
}
