/*
 * 	Author: Kellen Moltenbrey
 * 
 * 	Description:
 * 		5 Lines of input, each line gives the starting location of m1 and
 * 		m2 (indexes 0 and 1) and a list of tiles already removed. Each line
 * 		will end in a zero. For each input, m2 can move in a straight line
 * 		in any direction (including diagonally). List the longest move that
 * 		can be made in any direction by m2. The longest move will be unique
 * 		for each input line.
 * 
 * 	ACSL 2014-15 Contest #3 Intermediate Division
 * 	( more info at http://www.acsl.org )
 * 
 */

import java.util.Scanner;


public class Isola {
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		for(int p = 0; p < 5; p++) {
			String input = scan.nextLine();
			
			
			// Starting positions
			String[] in = input.split(", ");
			int m1 = Integer.parseInt(in[0]);
			int m2 = Integer.parseInt(in[1]);
			
			// Removed Pieces
			int[] nums = new int[in.length-2];
			for(int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(in[i+2]);
			}
			
			// Creates the board (numbers)
			int n = 49;
			int[][] numBoard = new int[7][7];
			for(int x = 0; x < 7; x++) {
				for(int y = 6; y >= 0; y--) {
					numBoard[x][y] = n;
					n--;
				}
			}
			
			// Creates the board (1's and 0's)
			int[][] boolMatrix = new int[7][7];
			for(int x = 0; x < 7; x++) {
				for(int y = 6; y >= 0; y--) {
					boolMatrix[x][y] = 0;
				}
			}
			for(int x = 0; x < 7; x++) {
				for(int y = 6; y >= 0; y--) {
					for(int i = 0; i < nums.length; i++) {
						if(numBoard[x][y] == nums[i] || numBoard[x][y] == m1) {
							boolMatrix[x][y] = 1;
						}
					}
				}
			}
			
			// Initializes variables
			String result = "";
			int longest = 0;
			int temp = 0;
			int length = 0;
			int startX = 0;
			int startY = 0;
			for(int x = 0; x < 7; x++) {
				for(int y = 6; y >= 0; y--) {
					if(numBoard[x][y] == m2) {
						startX = x;
						startY = y;
					}
				}
			}
			
			// Test #1 (straight up)
			String result1 = "";
			for(int y = startY + 1; y < 7; y++) {
				if(boolMatrix[startX][y] == 0) {
					temp++;
					result1 += numBoard[startX][y];
					result1 += ", ";
				} else {
					break;
				}
			}
			if(temp > 0) {
				result1 = result1.substring(0, result1.length()-2);
			}
			if(temp > length) {
				length = temp;
				longest = 1;
				result = result1;
			}
			temp = 0;
			
			// Test #2 (up and to the right)
			String result2 = "";
			for(int y = startY + 1, x = startX + 1; y < 7 && x < 7; y++, x++) {
				if(boolMatrix[x][y] == 0) {
					temp++;
					result2 += numBoard[x][y];
					result2 += ", ";
				} else {
					break;
				}
			}
			if(temp > 0) {
				result2 = result2.substring(0, result2.length()-2);
			}
			if(temp > length) {
				length = temp;
				longest = 1;
				result = result2;
			}
			temp = 0;
			
			// Test #3 (straight to the right)
			String result3 = "";
			for(int x = startX + 1; x < 7; x++) {
				if(boolMatrix[x][startY] == 0) {
					temp++;
					result3 += numBoard[x][startY];
					result3 += ", ";
				} else {
					break;
				}
			}
			if(temp > 0) {
				result3 = result3.substring(0, result3.length()-2);
			}
			if(temp > length) {
				length = temp;
				longest = 1;
				result = result3;
			}
			temp = 0;
			
			// Test #4 (down and to the right)
			String result4 = "";
			for(int y = startY - 1, x = startX + 1; y >= 0 && x < 7; y--, x++) {
				if(boolMatrix[x][y] == 0) {
					temp++;
					result4 += numBoard[x][y];
					result4 += ", ";
				} else {
					break;
				}
			}
			if(temp > 0) {
				result4 = result4.substring(0, result4.length()-2);
			}
			if(temp > length) {
				length = temp;
				longest = 1;
				result = result4;
			}
			temp = 0;
			
			// Test #5 (straight down)
			String result5 = "";
			for(int y = startY - 1; y >= 0; y--) {
				if(boolMatrix[startX][y] == 0) {
					temp++;
					result5 += numBoard[startX][y];
					result5 += ", ";
				} else {
					break;
				}
			}
			if(temp > 0) {
				result5 = result5.substring(0, result5.length()-2);
			}
			if(temp > length) {
				length = temp;
				longest = 1;
				result = result5;
			}
			temp = 0;
			
			// Test #6 (down and to the left)
			String result6 = "";
			for(int y = startY - 1, x = startX - 1; y >= 0 && x >= 0; y--, x--) {
				if(boolMatrix[x][y] == 0) {
					temp++;
					result6 += numBoard[x][y];
					result6 += ", ";
				} else {
					break;
				}
			}
			if(temp > 0) {
				result6 = result6.substring(0, result6.length()-2);
			}
			if(temp > length) {
				length = temp;
				longest = 1;
				result = result6;
			}
			temp = 0;
			
			// Test #7 (straight to the left)
			String result7 = "";
			for(int x = startX -1; x >= 0; x--) {
				if(boolMatrix[x][startY] == 0) {
					temp++;
					result7 += numBoard[x][startY];
					result7 += ", ";
				} else {
					break;
				}
			}
			if(temp > 0) {
				result7 = result7.substring(0, result7.length()-2);
			}
			if(temp > length) {
				length = temp;
				longest = 1;
				result = result7;
			}
			temp = 0;
			
			// Test #8 (up and to the left)
			String result8 = "";
			for(int y = startY + 1, x = startX - 1; y < 7 && x >= 0; y++, x--) {
				if(boolMatrix[x][y] == 0) {
					temp++;
					result8 += numBoard[x][y];
					result8 += ", ";
				} else {
					break;
				}
			}
			if(temp > 0) {
				result8 = result8.substring(0, result8.length()-2);
			}
			if(temp > length) {
				length = temp;
				longest = 1;
				result = result8;
			}
			temp = 0;
			
			// Final result
			if(longest == 0) {
				System.out.println("NONE");
			} else {
				System.out.println(result);
			}
		}
		
		scan.close();
	}
}
