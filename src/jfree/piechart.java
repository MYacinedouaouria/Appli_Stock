package jfree;

import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import com.implementation.pack.Role;
import java.awt.Color;

public class piechart  extends JPanel {
	private int bas;
	private int zeros;
	private int eleve;
	Role r=new Role();
	private static final long serialVersionUID=1L;
	public piechart(String chartTitle){
		//on recupere les quantites des differents stocks
		bas=r.quantite_stock("bas");
		zeros=r.quantite_stock("null");
		eleve=r.quantite_stock("eleve");
		//super(applicationTitle);
		//this.setBackground(new Color(82,80,80));
              
		PieDataset dataset=createDataset();
		JFreeChart chart=createChart(dataset,chartTitle);
		ChartPanel chartpanel=new ChartPanel(chart);
		chartpanel.setPreferredSize(new Dimension(400, 450));
                
		this.add(chartpanel);
	}
//nos methodes
	private PieDataset createDataset(){
		DefaultPieDataset result=new DefaultPieDataset();
                
                result.setValue("RUPTURE STOCK", zeros);
		result.setValue("ALERT APPROVISIONNENT", bas);
                result.setValue("STOCK NORMALE", eleve);
		return result;
		
	}
	private JFreeChart createChart(PieDataset dataset,String title){
		JFreeChart chart=ChartFactory.createPieChart3D(title, dataset,true,true,false);
		PiePlot3D plot=(PiePlot3D)chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.ANTICLOCKWISE);
		plot.setForegroundAlpha(0.5f);
               
		return chart;
	}

	//mes setters
	public void setbas(int bas){
		this.bas=bas;
	}
	public void setnull(int zeros){
		this.zeros=zeros;
	}
	public void seteleve(int eleve){
		this.eleve=eleve;
                
	}
	
}
