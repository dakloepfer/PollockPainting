package MainPackage;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.lang.Math;
import java.util.*;

public class Painting extends JPanel{
		
	private int fHeight=1029;
	private int fWidth=1029;
	private int fNum_colours=50;
	
	private double fFrac_Painted=0.4;
	private int fPixelsize = 3;
	private double fStdev = 1.0;
	
	private boolean mCircles=true;
	
	
	public Painting(int height, int width, int num_colours, double frac_painted, boolean circles, int pixelsize, double stdev){
		fHeight = height;
		fWidth = width;
		fNum_colours = num_colours;
		fFrac_Painted = frac_painted;
		mCircles = circles;
		fPixelsize = pixelsize;
		fStdev = stdev;
	}

	
	private int[] selectColour(){
		
		if (Math.random() >= fFrac_Painted){
			int[] a = {-1, -1, -1};
			return a;
		}
		
		int num_tones_rgb = (int) Math.floor(Math.cbrt(fNum_colours));
		int step_size = Math.floorDiv(255, num_tones_rgb);
		
		int r = (int) Math.round(Math.random() * num_tones_rgb );
		r *= step_size;
		
		int g = (int) Math.round(Math.random() * num_tones_rgb );
		g *= step_size;
		
		int b = (int) Math.round(Math.random() * num_tones_rgb );
		b *= step_size;
	
		int[] a = {r, g, b};
		return a;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		this.setBackground(Color.WHITE);
		Random randomno = new Random();
		
		if(mCircles){
			for(int i = 0; i<fWidth; i++){
				for (int j = 0; j<fHeight; j++){
					int[] rgb = selectColour();
					if (rgb[0] <0){continue;}
					Color c = new Color(rgb[0], rgb[1], rgb[2], 255); // could do some random stuff with the opacity (alpha) as well
					g.setColor(c);
					int size = (int)Math.round(Math.abs(randomno.nextGaussian()* fStdev + fPixelsize));
					g.fillOval(3*i,  3*j,  size,  size);
				}
			}
		}
		else{
			
			for(int i = 0; i<fWidth; i++){
				for (int j = 0; j<fHeight; j++){
					int[] rgb = selectColour();
					if (rgb[0] <0){continue;}
					Color c = new Color(rgb[0], rgb[1], rgb[2], 255); // could do some random stuff with the opacity (alpha) as well
					g.setColor(c);
					int size = (int)Math.round(Math.abs(randomno.nextGaussian()* fStdev + fPixelsize));
					g.fillRect(3*i, 3*j, size, size);
				}
			}
			
		}
		
	}

	
}
