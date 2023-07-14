import javax.swing.*;
import java .awt.*;
import java.awt.event.*;

class MainActivity extends JFrame
{
Container c;
JButton btnAdd,btnView;

MainActivity()
{
c=getContentPane();
c.setLayout(new FlowLayout());

btnAdd=new JButton("Add Employee");
btnView=new JButton("View Employee");

Font f=new Font("Arial",Font.BOLD,30);

btnAdd.setFont(f);
btnView.setFont(f);

c.add(btnAdd);
c.add(btnView);


ActionListener a1=(ae)->{
		AddActivity a=new AddActivity();
		dispose();
};
ActionListener  a2=(ae)->{
		ViewActivity a=new ViewActivity();
		dispose();
};
btnAdd.addActionListener(a1);
btnView.addActionListener(a2);
setTitle("Main Page");
setSize(500,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

   }
}