package MainPackage;

import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class Frame extends JFrame{

	/* Credits for the idea go to Richard Najorka
	 * 
	 */

	//TODO: Debug the problem that the size of the actual painting is not large enough
	// This might have something to do with the fact that the background of the frame is not white
	
	public Frame(int width, int height, int num_colours, double frac_painted, boolean circles, int pixelsize, double stdev) throws Exception{
		
		super("Random Dot Painting");
		setSize(3*width, 3*height);
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Painting panel = new Painting(width, height, num_colours, frac_painted, circles, pixelsize, stdev);
		
		add(panel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		System.out.println("To create your painting, we need your format.");
		System.out.println("Please enter your preferred height in pixels and confirm with ENTER: ");
		
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		while (height <= 0){
			System.out.println("Please enter a value greater than 0. Confirm with ENTER. ");
			height = sc.nextInt();
		}
		
		System.out.println("Please enter your preferred width in pixels and confirm with ENTER: ");
		int width = sc.nextInt();
		while (width <= 0){
			System.out.println("Please enter a value greater than 0. Confirm with ENTER. ");
			width = sc.nextInt();
		}
		
		System.out.println("How many colours would you want us to choose from? The maximum number is 16,581,375. Confirm with ENTER.");
		int num_colours = sc.nextInt(); 
		while (num_colours <= 0 || num_colours > 255*255*255){
			System.out.println("Please enter a value greater in the valid range. Confirm with ENTER. ");
			num_colours = sc.nextInt();
		} 
		boolean circles = false;
		System.out.println("Should the pixels be circles or squares? For circles enter circles, for squares enter squares. Confirm with ENTER.");
		
		String input = sc.nextLine();
		while(true){
			if (input.equalsIgnoreCase("circles")){
				circles = true;
				break;
			}
			else if (input.equalsIgnoreCase("squares")){
				circles = false;
				break;
			}

			System.out.println("Please enter 'circles' or 'squares'. Confirm with ENTER. ");
			input = sc.nextLine();

			
		}
		
		System.out.println("What fraction of pixels should be coloured in? (Enter a number between 0.0 and 1.0");
		double frac_painted = sc.nextDouble();
		while(frac_painted < 0 || frac_painted > 1.0){
			System.out.println("Please enter a value between 0.0 and 1.0. ");
			frac_painted = sc.nextDouble();
		}
		
		System.out.println("How large should the average individual dot be? Give your answer in the number of pixels across. ");
		int pixelsize = sc.nextInt();
		while (pixelsize <= 0){
			System.out.println("Please enter a value greater than 0. Confirm with ENTER. ");
			pixelsize = sc.nextInt();
		}
		
		System.out.println("How large in pixels should the standard deviation of the pixelsize be? ");
		double stdev = sc.nextDouble();
		while (stdev < 0){
			System.out.println("Please enter a value greater than 0. Confirm with ENTER. ");
			stdev = sc.nextDouble();
		}
		
		System.out.println("Thanks! If you want to view the painting now, press any key and ENTER");
		String dummy = sc.next();
		
		try {
			new Frame(width, height, num_colours, frac_painted, circles, pixelsize, stdev);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
