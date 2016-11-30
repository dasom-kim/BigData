package lab02;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ClosestPair {
	public static float brutedot1;
	public static float brutedot2;
	public static float divandcondot1;
	public static float divandcondot2;
	public static double tempdistance;
	public static int count = 0;

	public static void main(String[] args) throws Exception {
		double answer;

		String fileaddress = "/home/hadoop/Documents/test/10000.dat"; // file

		String[] file = fileaddress.split("/");
		int filesize1 = file.length;
		String filename = file[filesize1 - 1];
		int filesizes = filename.length();
		String files = filename.substring(0, filesizes - 4);
		int filesize2 = Integer.parseInt(files);

		System.setIn(new FileInputStream(fileaddress));

		float[][] p = new float[filesize2][3];
		Scanner sc = new Scanner(System.in);
		long t1, t2, t3, t4;

		for (int i = 0; i < filesize2; i++) {
			p[i][0] = sc.nextFloat(); // name
			p[i][1] = sc.nextFloat(); // x
			p[i][2] = sc.nextFloat(); // y
		}

		t1 = System.currentTimeMillis();
		answer = BruteForce(p);
		t2 = System.currentTimeMillis();
		System.out.println("Bruteforce-> (" + (int) brutedot1 + ","
				+ (int) brutedot2 + ") distance: " + answer + " (" + (t2 - t1)
				+ " milliseconds)");

		t3 = System.currentTimeMillis();
		answer = DivideandConquer(p);
		t4 = System.currentTimeMillis();
		System.out.println("Divide and Conquer-> (" + (int) divandcondot1 + ","
				+ (int) divandcondot2 + ") distance: " + answer + " ("
				+ (t4 - t3) + " milliseconds)");

		sc.close();
	}

	static class Point {
		float index;
		float x, y;

		public Point(float p1, float p2, float p3) {
			this.index = p1;
			this.x = p2;
			this.y = p3;
		}
	}

	private static double distance(Point a, Point b) {
		return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow(a.y - b.y, 2));
	}

	private static double BruteForce(float[][] p) {
		double min = Double.POSITIVE_INFINITY;
		int n = p.length;
		double d;
		Point[] points = new Point[n];

		for (int i = 0; i < n; i++) {
			points[i] = new Point(p[i][0], p[i][1], p[i][2]);
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				d = distance(points[i], points[j]);

				if (d < min) {
					brutedot1 = points[i].index;
					brutedot2 = points[j].index;
					min = d;
				}
			}
		}

		return min;
	}

	private static double DivideandConquer(float[][] p) {
		int n = p.length;
		Point[] points = new Point[n];
		double d;

		for (int i = 0; i < n; i++) {
			points[i] = new Point(p[i][0], p[i][1], p[i][2]);
		}

		Point[] xPoints = new Point[n];

		System.arraycopy(points, 0, xPoints, 0, n);

		Arrays.sort(xPoints, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if (p1.x > p2.x) {
					return 1;
				} else if (p1.x < p2.x) {
					return -1;
				}
				return 0;
			}
		});

		d = closest(xPoints, 0, n - 1);
		return d;
	}

	private static double closest(Point[] xPoints, int s, int e) {
		if ((e - s) == 0) {
			return Double.POSITIVE_INFINITY;
		}

		int m = (s + e) / 2;

		double d1 = closest(xPoints, s, m);
		double d2 = closest(xPoints, m + 1, e);
		double d, d3;

		if (d1 < d2) {
			d = d1;
		} else {
			d = d2;
		}

		Point[] bPoints = new Point[e - s + 1];
		Point midPoint = xPoints[m];

		int k = 0;

		for (int i = s; i <= e; i++) {
			if (Math.abs(xPoints[i].x - midPoint.x) <= d) {
				bPoints[k++] = xPoints[i];
			}
		}

		d3 = RedBox(bPoints, k, d);
		return d3;
	}

	private static double RedBox(Point[] bPoints, int size, double minDist) {
		Arrays.sort(bPoints, 0, size, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if (p1.y > p2.y) {
					return 1;
				} else if (p1.y < p2.y) {
					return -1;
				}
				return 0;
			}
		});

		double d;
		count++;

		if (count == 1) {
			tempdistance = minDist;
		}

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size
					&& ((bPoints[j].y - bPoints[i].y) < minDist); j++) {
				d = distance(bPoints[i], bPoints[j]);
				if (d < minDist) {
					minDist = d;

					if (minDist < tempdistance) {
						tempdistance = minDist;
						divandcondot1 = bPoints[i].index;
						divandcondot2 = bPoints[j].index;
					}
				}
			}
		}
		return minDist;
	}

}