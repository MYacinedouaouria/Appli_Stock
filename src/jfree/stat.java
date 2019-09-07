package jfree;

import javax.swing.JFrame;

public class stat extends JFrame{
	
	piechart demo=new piechart("etat des stocks");
	public stat(String applicationTitle){
		super(applicationTitle);
		this.setContentPane(demo);
		//demo.setSize(this.getWidth(), this.getHeight() );
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//piechart demo=new piechart("statistique", "etat des stocks");
		stat st=new stat("statistique");	
		//demo.pack();
			st.setVisible(true);
	}

}
