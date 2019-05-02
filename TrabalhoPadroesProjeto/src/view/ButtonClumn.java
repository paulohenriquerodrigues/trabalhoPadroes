import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
//OUR MAIN CLASS
public class ButtonClumn extends JFrame {

   public ButtonClumn(){
//FORM TITLE
super("Button Column Example");
//DATA FOR OUR TABLE
Object[][] data=
{
{"1","Paulo",new Integer(2013),"21"},
{"2","Man City",new Integer(2014),"3"},
{"3","Chelsea",new Integer(2015),"7"},
{"4","Arsenal",new Integer(1999),"10"},
{"5","Liverpool",new Integer(1990),"19"},
{"6","Everton",new Integer(1974),"1"},
};
//COLUMN HEADERS
String columnHeaders[]={"Position","Team","Last Year Won","Trophies"};
//CREATE OUR TABLE AND SET HEADER
JTable table=new JTable(data,columnHeaders);
//SET CUSTOM RENDERER TO TEAMS COLUMN
ButtonColumn b = new ButtonColumn(table, 1);
//SET CUSTOM EDITOR TO TEAMS COLUMN
//SCROLLPANE,SET SZE,SET CLOSE OPERATION
JScrollPane pane=new JScrollPane(table);
getContentPane().add(pane);
setSize(450,100);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public static void main(String[] args) {
ButtonClumn bc=new ButtonClumn();
bc.setVisible(true);
}

class ButtonColumn extends AbstractCellEditor
        implements TableCellRenderer, TableCellEditor, ActionListener
    {
        JTable table;
        JButton renderButton;
        JButton editButton;
        String text;
        public ButtonColumn(JTable table, int column)
        {
            super();
            this.table = table;
            renderButton = new JButton();
            editButton = new JButton();
            editButton.setFocusPainted( false );
            editButton.addActionListener( this );
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer( this );
            columnModel.getColumn(column).setCellEditor( this );
        }
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            if (hasFocus)
            {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(Color.red);
            }
            else if (isSelected)
            {
                renderButton.setForeground(table.getSelectionForeground());
                 renderButton.setBackground(Color.red);
        System.out.println(table.getSelectedRow()+" - "+table.getSelectedColumn());

            }
            else
            {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(Color.red);
            }
            renderButton.setText( (value == null) ? "" : value.toString() );
            return renderButton;
        }
        public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column)
        {
            text = (value == null) ? "" : value.toString();
            editButton.setText( text );
            return editButton;
        }
        public Object getCellEditorValue()
        {
            return text;
        }
        public void actionPerformed(ActionEvent e)
        {
                        fireEditingStopped();

            System.out.println( e.getActionCommand() + " : " + table.getSelectedRow()+" - "+table.getSelectedColumn());
        }
    }
}
