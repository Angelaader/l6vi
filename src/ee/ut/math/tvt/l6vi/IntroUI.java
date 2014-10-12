package ee.ut.math.tvt.l6vi;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class IntroUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
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
		String members[] = applicationProp.getProperty("team_members").split(",");
		String intro = 
				"<html>"
						+	"<table>"
						+	"<tr>"
						+	"<td>Team name</td>"
						+	"<td>"+applicationProp.getProperty("team_name")+"</td>"
						+	"<td rowspan=5><img height=128 width=128 src='file:" + applicationProp.getProperty("logo") + "'/></td>"
						+	"</tr>"
						+	"<tr>"
						+	"<td>Team leader</td>"
						+	"<td>"+applicationProp.getProperty("team_leader")+"</td>"
						+	"</tr>"
						+	"<tr>"
						+	"<td>Team leader email</td>"
						+	"<td>"+applicationProp.getProperty("leader_email")+"</td>"
						+	"</tr>"
						+	"<tr>"
						+	"<td>Members</td>"
						+	"<td>"+members[0]+"<br>"+members[1]+"<br>"+members[2]+"</td>"
						+	"</tr>"
						+	"<tr>"
						+	"<td>Version</td>"
						+	"<td>"+versionProp.getProperty("build.number")+"</td>"
						+	"</tr>"
						+	"</table>"
						+	"</html>";
				
		add(new JLabel(intro));
		pack();
		
	}
	


}
