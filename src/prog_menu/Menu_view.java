package prog_menu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Menu_view extends Frame implements ActionListener,WindowListener{
	
	MenuBar mb;
	Menu graph;
	MenuItem graph1;
	MenuItem graph2;
	Panel cardPanel, card1, card2;

	public Menu_view()  {
		addWindowListener(this);
		setTitle("Menu");
		
		//メニューの作成
		mb = new MenuBar();
		graph = mb.add(new Menu("Graph"));
		graph1 = graph.add(new MenuItem("Graph1"));
		graph2 = graph.add(new MenuItem("Graph2"));
		setMenuBar(mb);
		
		//カードパネルの作成
		cardPanel = new Panel();
		cardPanel.setLayout(new CardLayout());
		card1 = new Panel();
		//グラフ1をcard1に追加
		DefaultCategoryDataset data1 = new DefaultCategoryDataset();
		data1.addValue(300, "USA", "2005");
		data1.addValue(500, "USA", "2006");
		data1.addValue(120, "USA", "2007");
		data1.addValue(200, "China", "2005");
		data1.addValue(400, "China", "2006");
		data1.addValue(320, "China", "2007");

	    JFreeChart chart1 = 
	      ChartFactory.createLineChart("Import Volume",
	                                   "Year",
	                                   "Ton",
	                                   data1,
	                                   PlotOrientation.VERTICAL,
	                                   true,
	                                   false,
	                                   false);
	    ChartPanel cpanel1 = new ChartPanel(chart1);
	    card1.add(cpanel1, BorderLayout.CENTER);
		//card1.add(new Button("ABC"));
		//card1.add(new Button("XYZ"));
		card2 = new Panel();
		//グラフ1をcard2に追加
		DefaultCategoryDataset data2 = new DefaultCategoryDataset();
		data2.addValue(500, "USA", "2005");
		data2.addValue(300, "USA", "2006");
		data2.addValue(620, "USA", "2007");
		data2.addValue(300, "China", "2005");
		data2.addValue(200, "China", "2006");
		data2.addValue(820, "China", "2007");

		JFreeChart chart2 = ChartFactory.createLineChart("Import Volume",
				"Year",
			    "Ton",
			    data2,
			    PlotOrientation.VERTICAL,
			    true,
			    false,
			    false);
		ChartPanel cpanel2 = new ChartPanel(chart2);
		card2.add(cpanel2, BorderLayout.CENTER);
		//card2.add(new TextField("Test field on Card2"));
		cardPanel.add(card1, "Card1");
	    cardPanel.add(card2, "Card2");
	    add(cardPanel);
		
		//Listenerの追加
		graph1.addActionListener(this);
		graph2.addActionListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CardLayout cardLayout = (CardLayout)(cardPanel.getLayout());
		if (e.getSource() == graph1) {
			setBackground(Color.red);
			cardLayout.show(cardPanel, "Card1");
		}
		//if (e.getActionCommand() == "Graph1") setBackground(Color.red); //graph1がローカル変数の場合、こっちでやる
		if (e.getSource() == graph2) {
			setBackground(Color.blue);
			cardLayout.show(cardPanel, "Card2");
		}
		
	}

}
