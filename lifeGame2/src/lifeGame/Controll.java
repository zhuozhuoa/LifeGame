package lifeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Controll {
    Controll() {
    	JFrame jframe=new JFrame();
    	jframe.setSize(375,400);
    	JPanel jpanel=new JPanel();
    	jpanel.setBackground(Color.gray);
    	jpanel.setBounds(0,0,400,400);
    	int count=0;
    	Cell [][]cell=new Cell[36][36];
    	cell=Map.initial();
    	Map.getLiving(cell);
    	jframe.setTitle("这是第"+count+"次演化");
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jframe.setLocationRelativeTo(null);
    	jframe.add(jpanel);
    	jframe.setVisible(true);
    	Graphics g=jpanel.getGraphics();
    	for(int i=0;i<36;i++) {
    		for(int j=0;j<36;j++) {
    			if(cell[i][j].getStatus()==1) {
    				g.fillRect(i*10, j*10, 10, 10);
    			}
    			else {
    				g.drawRect(i*10, j*10, 10, 10);
    			}
    		}
    	}
    	long d1= System.currentTimeMillis();
    	while(true) {
    		long d2= System.currentTimeMillis();
    		if(d2-d1>1000) {
    			int change;
    			d1=d2;
    			jframe.repaint();
    			change=Map.update(cell);
    			Map.getLiving(cell);
    			for(int i=0;i<36;i++) {
    				for(int j=0;j<36;j++) {
    					if(cell[i][j].getStatus()==1) {
    	    				g.fillRect(i*10, j*10, 10, 10);
    	    			}
    	    			else {
    	    				g.drawRect(i*10, j*10, 10, 10);
    				    }
    				}
    			}
    		    count++;
    		    jframe.setTitle("这是第"+count+"次演化");
    	    }	    	
      }
    }
}


