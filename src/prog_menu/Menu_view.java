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
	Panel cardPanel, card[];

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
		card = new Panel[2];
		for(int i = 0; i < card.length; i++) card[i] = new Panel();
		//データ作成
		DefaultCategoryDataset data[] = new DefaultCategoryDataset[2];
		data[0] = new DefaultCategoryDataset();
		data[0].addValue(300, "USA", "2005");
		data[0].addValue(500, "USA", "2006");
		data[0].addValue(120, "USA", "2007");
		data[0].addValue(200, "China", "2005");
		data[0].addValue(400, "China", "2006");
		data[0].addValue(320, "China", "2007");
		data[1] = new DefaultCategoryDataset();
		data[1].addValue(500, "USA", "2005");
		data[1].addValue(300, "USA", "2006");
		data[1].addValue(620, "USA", "2007");
		data[1].addValue(300, "China", "2005");
		data[1].addValue(200, "China", "2006");
		data[1].addValue(820, "China", "2007");

		JFreeChart chart[] = new JFreeChart[2];
		this.setCard(chart[0], data[0], card[0]);
		this.setCard(chart[1], data[1], card[1]);
		

		cardPanel.add(card[0], "Card1");
	    cardPanel.add(card[1], "Card2");
	    add(cardPanel);
		
		//Listenerの追加
		graph1.addActionListener(this);
		graph2.addActionListener(this);
	}
	
	public void setCard(JFreeChart chart, DefaultCategoryDataset data, Panel card) {
		chart = ChartFactory.createLineChart("Import Volume","Year","Ton",data,PlotOrientation.VERTICAL,true,false,false);
		ChartPanel cpanel = new ChartPanel(chart);
		card.add(cpanel, BorderLayout.CENTER);
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
