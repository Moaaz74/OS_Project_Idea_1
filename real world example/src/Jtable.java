
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Jtable {
    
    DefaultTableModel tableModel;
    JTable table;
    JFrame f ;
    public Jtable() {
      f = new JFrame();
      f.setSize(700, 500);
      f.setLayout(new GridBagLayout());
      tableModel = new DefaultTableModel();
      table = new JTable(tableModel);
      tableModel.addColumn("Windows");
      tableModel.addColumn("Agent Number");
      table.setRowHeight(30);
      table.setBackground(new Color(255, 153, 51));
      f.add(new JScrollPane(table));
      f.setVisible(true); 
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void insert_table (int window,int agent) {
        tableModel.insertRow(0, new Object[] { window,agent });
    }
    
    
}
