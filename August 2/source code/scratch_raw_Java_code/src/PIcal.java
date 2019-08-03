import java.util.Scanner;

public class PIcal {

    public double jishuPI() {
        double sum = 2, z = 1e-15;
        int n = 1;
        int m = 3;
        double t = 2;
        while (t > z) {
            t = t * n / m;
            sum = sum + t;
            n++;
            m += 2;
        }
        return sum;
    }

    // calculate PI by arcsinx expression of Maclaurin's series
    // π=2*(1+1/3+2/(3*5)+（3*2）/（3*5*7）...
    public double jishuPI(double z) {
        double sum = 2;
        int n = 1;
        int m = 3;
        double t = 2;
        while (t > z) {
            t = t * n / m;
            sum = sum + t;
            n++;
            m += 2;
        }
        return sum;
    }

    // calculate circular circumference by PI and the given radius
    public double circularCircumference(double r, double z) {
        double ccf = 2 * z * r;
        return ccf;
    }

    // calculate circular area by PI and the given radius
    public double circularArea(double r, double z) {
        double area = z * r * r;
        return area;
    }
}
