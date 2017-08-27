package leetCode;

import java.util.*;

public class xx {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		List<Integer> result = new LinkedList<>();
		result.add(0);
		
		for(int i = 1; i < n; i++) {
			boolean isMax = true;
			//boolean temp = false;
			for(int j : result) {
				int xx = x[j], yy = y[j];
				
				if(xx > x[i] || yy > y[i])
					isMax = false;
				
				if(x[i] > xx && y[i] > yy)
					result.remove(new Integer(j));
				
			}
			
			if(isMax)
				result.add(i);
		}
		
		//int count = 0;
		List<Point> temp = new ArrayList<>();
		for(int i : result) {
			temp.add(new Point(x[i], y[i]));
		}
		Collections.sort(temp);
		for(int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i).x + " " + temp.get(i).y);
			if(i != temp.size() - 1)
				System.out.println();
		}
	}

	private static class Point implements Comparable<Point> {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			if(this.x > o.x)
				return 1;
			
			if(this.x < o.x)
				return -1;
			
			return 0;
		}
	}
	
}
