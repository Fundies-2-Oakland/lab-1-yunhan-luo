public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double X, double Y, double Z) {
        x = X;
        y = Y;
        z = Z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public Vector3D normalize() {
        double mag = getMagnitude();
        try {
            return new Vector3D(x / mag, y / mag, z / mag);
        } catch (ArithmeticException e) {
            throw new IllegalStateException();
        }
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.getX(), y + other.getY(), z + other.getZ());
    }

    public Vector3D multiply(double scalar) {
        return new Vector3D(x * scalar, y * scalar, z * scalar);
    }

    public double dotProduct(Vector3D other) {
        return x * other.getX() + y * other.getY() + z * other.getZ();
    }

    public double angleBetween(Vector3D other) {
        try {
            return Math.acos(dotProduct(other) / (other.getMagnitude() * this.getMagnitude()));
        } catch (ArithmeticException e) {
            throw new IllegalStateException();
        }
    }

    public double crossProduct(Vector3D other) {
        return this.getMagnitude() * other.getMagnitude() * Math.sin(angleBetween(other));
    }
}
