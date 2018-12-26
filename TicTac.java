import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TicTac extends JFrame
{	JFrame f=new JFrame("Tic Tac");
	JButton b[]=new JButton[9];
	JPanel p;
	JPanel clc;
	int clicking=0;
	int[] fillup = new int[9];	
	JButton sta=new JButton("START");
	boolean won = false;
	int turn=1;
	public TicTac()
	{	for(int n=0;n<9;++n)
		{
			fillup[n]=33;
		}
		p=new JPanel(new  GridLayout(3,3,0,0));
		clc=new JPanel(new BorderLayout());
		String s1[]={"","","","","","","","","",""};

		for(int i=0;i<b.length;i++)
		{
			b[i]=new JButton(s1[i]);
			p.add(b[i]);
			b[i].addActionListener(new myActionListener());
		}
		sta.addActionListener(new myActionListener());
		clc.add(sta);
		f.add(p);
		f.add(clc, BorderLayout.NORTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		f.setVisible(true);
	}
	public static void main(String... s)
	{
		TicTac d=new TicTac();
	}
	


class myActionListener implements ActionListener
{      
 public void actionPerformed(ActionEvent a) 
  {
	if((won == false)&&(turn==2))
	{
		for(int j=0;j<9;++j)
		{
			if(a.getSource()==b[j])
			{
				b[j].setText("O");
				b[j].setEnabled(false);
				turn=1;
				clicking++;
				fillup[j]=0;
				check(fillup);
				
				
			}
		}
	}
   else if((won == false)&&(turn==1))
   {	
		for(int j=0;j<9;++j)
		{
			if(a.getSource()==b[j])
			{
				b[j].setText("X");
				b[j].setEnabled(false);
				turn=2;
				clicking++;
				fillup[j]=1;
				check(fillup);
			}
		}
	   
   }
   if(a.getSource()==sta)
   {
	        for(int i = 0; i < 9; i++)
            {	fillup[i]=33;
				clicking=0;
               won = false;
               b[i].setText(""); 
               b[i].setEnabled(true);
               
            }
         
   }
  }
}
	void check(int k[])
	{
		if( (k[0]==1 && k[1]==1 && k[2]==1) ||
			(k[3]==1 && k[4]==1 && k[5]==1) ||
			(k[6]==1 && k[7]==1 && k[8]==1) ||
			(k[0]==1 && k[3]==1 && k[6]==1) ||
			(k[1]==1 && k[4]==1 && k[7]==1) ||
			(k[2]==1 && k[5]==1 && k[8]==1) ||
			(k[0]==1 && k[4]==1 && k[8]==1) ||
			(k[2]==1 && k[4]==1 && k[6]==1) )
	       

		   {
				System.out.println("X wins");
				won=true;
			}
	
		else if( (k[0]==0 && k[1]==0 && k[2]==0) ||
				 (k[3]==0 && k[4]==0 && k[5]==0) ||
				 (k[6]==0 && k[7]==0 && k[8]==0) ||
				 (k[0]==0 && k[3]==0 && k[6]==0) ||
				 (k[1]==0 && k[4]==0 && k[7]==0) ||
				 (k[2]==0 && k[5]==0 && k[8]==0) ||
				 (k[0]==0 && k[4]==0 && k[8]==0) ||
			     (k[2]==0 && k[4]==0 && k[6]==0) )
	       
	        {
				System.out.println("O wins");
				won=true;
			}
			
		else if(clicking==9)
		{
			System.out.println("Match Drawn");
		}
	}
}