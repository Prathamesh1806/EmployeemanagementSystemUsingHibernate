import javax.swing.*;
import java .awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class AddActivity extends JFrame
{
Container c;
JLabel  labId,labName;
JTextField txtId ,txtName;
JButton btnSave,btnBack;

AddActivity()
{
c=getContentPane();
c.setLayout(new FlowLayout());

 labId=new  JLabel("Enter Id");
txtId=new  JTextField(10);
labName=new  JLabel("Enter Name");
txtName=new  JTextField(10);
btnSave=new JButton("Save");
btnBack=new JButton("Back");

Font f=new Font("Arial",Font.BOLD,30);
 
labId.setFont(f);
txtId.setFont(f);
labName.setFont(f);
txtName.setFont(f);
btnSave.setFont(f);
btnBack.setFont(f);

c.add(labId);
c.add(txtId);
c.add(labName);
c.add(txtName);
c.add(btnSave);
c.add(btnBack);

ActionListener a1=(ae)->{
		MainActivity a=new MainActivity();
		dispose();

};

btnBack.addActionListener(a1);

ActionListener  a2=(ae)->{
  
	Configuration cfg=new Configuration(); 	
	cfg.configure("hibernate.cfg.xml");

	SessionFactory sf=cfg.buildSessionFactory(); 
	Session s=null;
	Transaction t=null;
	
	try{
	s=sf.openSession();
	int id=Integer.parseInt(txtId.getText());
	String name=txtName.getText();
	Employee emp=new Employee(id,name);
	 t=s.beginTransaction();
	s.save(emp);
	t.commit();
       JOptionPane.showMessageDialog(c,"record saved");
	txtId.setText("");
	txtName.setText("");
	txtId.requestFocus();
	}
catch(Exception e)
{
	t.rollback();
JOptionPane.showMessageDialog(c,"issues"+e);
}

finally
{
s.close();
System.out.println("disconnected");
}
};
btnSave.addActionListener(a2);

setTitle("Add Page");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

   }
}