import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import calculate.Calculate;

/*
<applet code="CalGui" width="500" height="600">
</applet>
*/

public class CalGui extends Applet implements ActionListener
{
//Text Field
TextField t1;

//
Panel p,p1,p2,p3;

//Aditional Variabels
int is_eqaulto_pressed =0;

//Buttons
Panel buttons()
{

Panel p = new Panel();
p.setLayout(new GridLayout(4,3,5,5));
for(int i=1;i<=9;i++)
{
Button b = new Button(""+i);
b.setFont(new Font("Arial", Font.BOLD, 25));

b.setForeground(new Color(255, 153, 51));
b.addActionListener(this);
p.add(b);
}
Button b1 = new Button("AC");
b1.addActionListener(this);
p.add(b1);

Button b2 = new Button("0");
b2.addActionListener(this);
p.add(b2);
b2.setForeground(new Color(255, 153, 51));

Button b3 = new Button("%");
b3.addActionListener(this);
p.add(b3);
b1.setFont(new Font("Arial", Font.BOLD, 25));
b2.setFont(new Font("Arial", Font.BOLD, 25));
b3.setFont(new Font("Arial", Font.PLAIN, 25));
return p;
}

Panel buttons2()
{
Panel p = new Panel();
p.setPreferredSize(new Dimension(100, 150));
p.setLayout(new GridLayout(4,1,10,5));

for(int i=42;i<=47;i++)
{
char ch = (char)i;
String str = String.valueOf(ch);
if(i==42 || i==43 || i==45 || i==47)
{
Button b = new Button(""+str);
b.setFont(new Font("Arial", Font.PLAIN, 50));
b.setForeground(new Color(255, 255, 255));
b.setBackground(Color.BLACK);
b.addActionListener(this);
p.add(b);
}
}
return p;
}

Panel buttons3()
{
Panel p = new Panel();
p.setPreferredSize(new Dimension(100,100));
p.setLayout(new GridLayout(2,5,10,5));
Button [] b = new Button[10];
for(int i =0;i<10;i++)
{
b[i] = new Button();
b[i].setFont(new Font("Arial", Font.BOLD, 20));
b[i].setForeground(new Color(0, 0, 0));
b[i].setBackground(new Color(255, 128, 0));
b[i].addActionListener(this);
p.add(b[i]);
}
b[0].setLabel("sin");b[1].setLabel("cos");b[2].setLabel("tan");b[3].setLabel("rad");b[4].setLabel("deg");
b[5].setLabel("!");b[6].setLabel("Sqrt");b[7].setLabel("^");b[8].setLabel("ln");b[9].setLabel("log");
return p;
}

Panel buttons4()
{
Panel p = new Panel();
p.setPreferredSize(new Dimension(100,150));
p.setLayout(new GridLayout(4,1,5,5));
Button [] b1 = new Button[4];
for(int i =0;i<4;i++)
{
b1[i] = new Button();
b1[i].addActionListener(this);
b1[i].setFont(new Font("Arial", Font.BOLD, 35));
b1[i].setForeground(new Color(255, 255, 255));
b1[i].setBackground(Color.BLACK);
p.add(b1[i]);
}
b1[0].setLabel("=");b1[1].setLabel("(");b1[2].setLabel(")");b1[3].setLabel("Del");
return p;
}



public void init()
{
//setLayout
setLayout(new BorderLayout(10,10));

//Add TextField
this.t1 = new TextField();
this.t1.setFont(new Font("Arial",Font.PLAIN,65));

add(t1,BorderLayout.NORTH);

//Add Buttons
this.p = buttons();
add(p,BorderLayout.CENTER);

//Add "+","-","*","-"
this.p1 = buttons2();
add(p1,BorderLayout.EAST);

//Add Additional Buttons Part 1
this.p2 = buttons3();
add(p2,BorderLayout.SOUTH);

//Add Additional Buttons Part 2
this.p3 = buttons4();
add(p3,BorderLayout.WEST);

//setVisible
setVisible(true);

}

public void actionPerformed(ActionEvent e)
{
Button b = (Button)e.getSource();
if(b.getLabel()=="sin")
{
Calculate eval1 = new Calculate(t1.getText());
try
{
double angle = Double.parseDouble(eval1.Evaluate());
double result = Math.sin(Math.toRadians(angle));
result = Math.round(result*100.0)/100.0;
this.t1.setText(String.valueOf(result));
}
catch(Exception a)
{
this.t1.setText("Syntax Error");
this.is_eqaulto_pressed =1;
}
}
else if(b.getLabel()=="cos")
{
Calculate eval1 = new Calculate(t1.getText());
try
{
double angle = Double.parseDouble(eval1.Evaluate());
double result = Math.cos(Math.toRadians(angle));
result = Math.round(result*100.0)/100.0;
this.t1.setText(String.valueOf(result));
}
catch(Exception a)
{
this.t1.setText("Syntax Error");
this.is_eqaulto_pressed =1;
}
}
else if(b.getLabel()=="tan")
{
Calculate eval1 = new Calculate(t1.getText());
try
{
double angle = Double.parseDouble(eval1.Evaluate());
double result = Math.tan(Math.toRadians(angle));
result = Math.round(result*100.0)/100.0;
this.t1.setText(String.valueOf(result));
}
catch(Exception a)
{
this.t1.setText("Syntax Error");
this.is_eqaulto_pressed =1;
}
}

else if(b.getLabel()=="rad")
{
Calculate eval1 = new Calculate(t1.getText());
try
{
double angle = Double.parseDouble(eval1.Evaluate());
double result = Math.toRadians(angle);
result = Math.round(result*100.0)/100.0;
this.t1.setText(String.valueOf(result));
}
catch(Exception a)
{
this.t1.setText("Syntax Error");
this.is_eqaulto_pressed =1;
}
}

else if(b.getLabel()=="deg")
{
Calculate eval1 = new Calculate(t1.getText());
try
{
double angle = Double.parseDouble(eval1.Evaluate());
double result = Math.toDegrees(angle);
result = Math.round(result*100.0)/100.0;
this.t1.setText(String.valueOf(result));
}
catch(Exception a)
{
this.t1.setText("Syntax Error");
this.is_eqaulto_pressed =1;
}
}

else if(b.getLabel()=="ln")
{
Calculate eval1 = new Calculate(t1.getText());
try
{
double result = Math.log(Double.parseDouble(eval1.Evaluate()));
result = Math.round(result*100.0)/100.0;
this.t1.setText(String.valueOf(result));
}
catch(Exception a)
{
this.t1.setText("Syntax Error");
this.is_eqaulto_pressed =1;
}
}

else if(b.getLabel()=="log")
{
Calculate eval1 = new Calculate(t1.getText());
try
{
double result = Math.log10(Double.parseDouble(eval1.Evaluate()));
result = Math.round(result*100.0)/100.0;
this.t1.setText(String.valueOf(result));
}
catch(Exception a)
{
this.t1.setText("Syntax Error");
this.is_eqaulto_pressed =1;
}
}
else if((b.getParent()==p || b.getParent()==p1 || b.getParent()==p2 || b.getParent()==p3) && (b.getLabel() !="AC" && b.getLabel() !="Del" && b.getLabel() !="="))
{
if(this.is_eqaulto_pressed ==0)
this.t1.setText(this.t1.getText()+b.getLabel());
else{
is_eqaulto_pressed =0;
this.t1.setText(b.getLabel());
}
}
else if(b.getLabel() =="AC")
{
this.t1.setText("");
}
else if(b.getLabel() =="Del")
{
String s = this.t1.getText() ;
this.t1.setText(s.substring(0,s.length()-1));
}
else if(b.getLabel() =="=")
{
this.is_eqaulto_pressed =1;
Calculate eval = new Calculate(t1.getText());
try
{
String ans =eval.Evaluate();
this.t1.setText(ans);
}
catch (Exception a){
    this.t1.setText("Syntax Error");

}
}
}
}