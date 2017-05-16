import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Eventrica {
 public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
   public void run() { 
    new SwingDemoGUI();

   }
  });
 }
}
class SwingDemoGUI {
 public SwingDemoGUI() {
  SimpleFrameDemo frame = new SimpleFrameDemo();
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  frame.setTitle("EVENTRICA");
  frame.setSize(470, 590);
 }
}
class SimpleFrameDemo extends JFrame implements ActionListener {
 public Event e[] = new Event[10];
 public int c = 0;
 JPanel pData,pTab,pTitle,pFrame;
 JPanel p, p1, p2, p3, p4, p5, p6, p7, p3btn, p3lst, p2result;
 JButton btn1, btn2, btn3, btn4, btn5, btnViewAll;
 JTextField txtEvent_Name, txtDescription, txtDate, txtVenue, txtSearch;
 JLabel lblEvent_Name, lblDesciption, lblDate, lblVenue, lbl, lbl2, lbl3, noti,jLabel1;
 JList < String > jlst;
 JComboBox < String > jComboMake;

 public SimpleFrameDemo() {
	 pFrame= new JPanel(new BorderLayout());
	 jLabel1= new JLabel();
	 pTab=new JPanel();
	 pTitle=new JPanel();
	 pTitle.setBackground(new Color(102, 0, 102));
	 pTab.setBackground(new Color(102, 0, 102));
	 jLabel1.setFont(new Font("Source Han Sans TW Heavy", 1, 18)); // NOI18N
     jLabel1.setForeground(Color.white);
     jLabel1.setText("Eventrica");
     pTitle.add(jLabel1); 
	 
	 
  ImageIcon icon = new ImageIcon(getClass().getResource("icon.jpg"));
  this.setIconImage(icon.getImage());
  p = new JPanel();
  this.setLayout(new FlowLayout(FlowLayout.LEFT));
  JLabel lbl = new JLabel(icon);
  JLabel lbl2 = new JLabel("Welcome to Eventrica.\n");
  JLabel lbl3 = new JLabel("A Event Record System.");
  lbl2.setFont(new Font("Source Han Sans TW Heavy", 1, 18));
  //  this.add(p);
  p4 = new JPanel();
  p5 = new JPanel();
  p6 = new JPanel();
  p3btn = new JPanel();
  p3lst = new JPanel();

  p1 = new JPanel();
  noti = new JLabel("");
  lblEvent_Name = new JLabel(" Event_Name");
  txtEvent_Name = new JTextField(10);
  lblDesciption = new JLabel(" Desciption");
  txtDescription = new JTextField(10);
  lblDate = new JLabel(" Date");
  txtDate = new JTextField("", 10);
  lblVenue = new JLabel(" Venue");
  txtVenue = new JTextField(10);
  p1.add(lblEvent_Name);
  p1.add(txtEvent_Name);
  p1.add(lblDesciption);
  p1.add(txtDescription);
  p1.add(lblDate);
  p1.add(txtDate);
  p1.add(lblVenue);
  p1.add(txtVenue);
  p1.add(noti);

  btn1 = new JButton("Add_Event");
  btn1.addActionListener(this);


  p6.add(btn1);
  p1.add(p6);
  p6.setLayout(new FlowLayout(FlowLayout.RIGHT));
  p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
  //  btn1.addActionListener(new ActionListener(){
  //    @Override
  //    public void actionPerformed(ActionEvent ae){
  //
  //  }

  ///});




  p2 = new JPanel();
  txtSearch = new JTextField(30);
  p2.add(txtSearch);
  p2.setLayout(new FlowLayout(FlowLayout.LEFT));




  p3 = new JPanel();

  btnViewAll = new JButton("View All");
  p3btn.add(btnViewAll);
  JPanel borderPnl = new JPanel(new BorderLayout());
  borderPnl.add(p3btn, BorderLayout.NORTH);
  borderPnl.add(p3lst, BorderLayout.SOUTH);
  p3.add(borderPnl);

  JPanel p2box = new JPanel();
  p2result = new JPanel();

  btn2 = new JButton("Search");
  p2box.add(btn2);
  btn2.addActionListener(this);

  JPanel p2b = new JPanel(new BorderLayout());
  p2b.add(p2box, BorderLayout.NORTH);
  p2b.add(p2result, BorderLayout.SOUTH);
  p2.add(p2b);


  btnViewAll.addActionListener(this);


  pData = new JPanel();
  pData.setLayout(new GridLayout(5, 1));
  pData.add(p);
  pData.add(p1);
  pData.add(p2);

  p4.add(lbl);
  p5.add(lbl2);
  p5.add(lbl3);
  p.add(p4);
  p.add(p5);
  p4.setBackground(Color.white);
  p5.setBackground(Color.white);

  p.setLayout(new GridLayout(2, 1));
  p1.setLayout(new GridLayout(5, 1));
  p2.setLayout(new FlowLayout(FlowLayout.LEFT));

  p5.setLayout(new GridLayout(4, 1));
  lbl2.setHorizontalAlignment(JLabel.CENTER);
  lbl3.setHorizontalAlignment(JLabel.CENTER);


  JTabbedPane jtp = new JTabbedPane();
  jtp.addTab("HOME", p);
  jtp.addTab("ADD EVENT", p1);
  jtp.addTab("SEARCH EVENT", p2);
  jtp.addTab("VIEW ALL", p3);
  pTab.add(jtp);

  pFrame.add(pTitle, BorderLayout.NORTH);
  pFrame.add(pTab, BorderLayout.SOUTH);
  add(pFrame);
 }

 @Override
 public void actionPerformed(ActionEvent ae) {
  String cmd = ae.getActionCommand();
  //	switch(cmd){
  //	case "Add_Event":noti.setText("Added.");break;
  //	}

  if ("Add_Event".equals(cmd)) {
   e[c++] = new Event(txtEvent_Name.getText(), txtDescription.getText(), txtDate.getText(), txtVenue.getText());
   noti.setText("     Added.");
   noti.setFont(new Font("Source Han Sans TW Heavy", 1, 14));
   txtVenue.setText(null);
   txtDate.setText(null);
   txtDescription.setText(null);
   txtEvent_Name.setText(null);
  }
  if ("View All".equals(cmd)) {
   p3lst.removeAll();
   //		JPanel borderPnlbN = new JPanel(new BorderLayout());
   p3lst.setLayout(new GridLayout(c, 1, 0, 5));
   JPanel pi[] = new JPanel[100];
   for (int j = 0; j < c; j++) {
    JLabel lbN = new JLabel(" " + e[j].getName() + "  (#" + e[j].getId() + ")                                             ");
    JLabel lbD = new JLabel("  " + e[j].getDetail());
    JLabel lbDt = new JLabel(" Date: " + e[j].getDate());
    JLabel lbV = new JLabel(" Venue: " + e[j].getVenue());
    pi[j] = new JPanel();
    pi[j].setLayout(new GridLayout(4, 1, 0, 2));
    pi[j].setSize(350, 200);
    lbN.setFont(new Font("Source Han Sans TW Heavy", 1, 16));
    pi[j].add(lbN);
    pi[j].add(lbD);
    pi[j].add(lbDt);
    pi[j].add(lbV);
    pi[j].setBackground(Color.white);

    p3lst.add(pi[j]);


   }



   this.pack(); // important line
  }
  if ("Search".equals(cmd)) {
   String s = (txtSearch.getText());
   Event se = Search(s);
   p2result.removeAll();
   JPanel pi1 = new JPanel();
   if (se.getName().equals("")) {
	   JLabel lbN1 = new JLabel("No results for searched keyword!!");
	   pi1.add(lbN1);
   } else {
    JLabel lbN = new JLabel(" " + se.getName() + "  (#" + se.getId() + ")                                             ");
    JLabel lbD = new JLabel("  " + se.getDetail());
    JLabel lbDt = new JLabel(" Date: " + se.getDate());
    JLabel lbV = new JLabel(" Venue: " + se.getVenue());
    
    pi1.setLayout(new GridLayout(4, 1, 0, 2));
    pi1.setSize(350, 200);
    lbN.setFont(new Font("Source Han Sans TW Heavy", 1, 16));
    pi1.add(lbN);
    pi1.add(lbD);
    pi1.add(lbDt);
    pi1.add(lbV);
    
   }
   pi1.setBackground(Color.white);
   p2result.add(pi1);
   this.pack();
  }
 }

Event Search(String n) {
	  Event es = new Event("", "", "", "");
	  if (c != 0) 
	   for (int j = 0; j < c; j++) 
	    if (e[j].getName().equals(n) || Integer.toString(e[j].getId()).equals(n) )
	     es=e[j];
	 return es;
}

}
class Event {
 static int id = 0;
 int Event_id;
 String Event_name;
 String Event_details;
 String Event_date;
 String Event_venue;
 int Timestamp;
 public Event(String Name, String Detail, String Date, String Venue) {
  Event_id = genId();
  Event_name = Name;
  Event_details = Detail;
  Event_date = Date;
  Event_venue = Venue;
  this.Timestamp = (int)(System.nanoTime() / 1000);
 }
 static int genId() {
  return ++id;
 }
 int getId() {
  return Event_id;
 }
 String getName() {
  return Event_name;
 }
 String getDetail() {
  return Event_details;
 }
 String getDate() {
  return Event_date;
 }
 String getVenue() {
  return Event_venue;
 }
 int getTimestamp() {
  return Timestamp;
 }
}