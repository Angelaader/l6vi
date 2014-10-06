package ee.ut.math.tvt.l6vi;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.swing.*;


public class IntroUI extends JFrame{
	
	
	public IntroUI(){
		
		setTitle("Introduction");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension realSize = getContentPane().getSize();
		
		setLocation((screen.width - realSize.height) / 2,
				(screen.height - realSize.height) / 2);
		
		Container introduction = getContentPane();
		introduction.setLayout(new BoxLayout(introduction, BoxLayout.Y_AXIS));
		introduction.setBackground(new Color(255, 255, 255));
		
		Properties applicationProp = new Properties();
		Properties versionProp = new Properties();
		
		try{
			applicationProp.load(new FileInputStream("application.properties"));
			versionProp.load(new FileInputStream("version.properties"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		JLabel team_name = new JLabel("Team name: " 
				+ applicationProp.getProperty("team_name"));
		JLabel team_leader = new JLabel("Team leader: " 
				+ applicationProp.getProperty("team_leader"));
		JLabel leader_email = new JLabel("Leader e-mail: " 
				+ applicationProp.getProperty("leader_email"));
		JLabel team_members = new JLabel("Team members: " 
				+ applicationProp.getProperty("team_members"));
		
		introduction.add(team_name);
		introduction.add(team_leader);
		introduction.add(leader_email);
		introduction.add(team_members);
		
		pack();
		
	}
	
	public static void main (String[] args){
		IntroUI ui = new IntroUI();
		ui.setVisible(true);
	}

}
