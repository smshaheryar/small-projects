package pizza_order_system;

import java.awt.Color;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Customer_Panel extends JLayeredPane{
    
    private final JComboBox EAT_MODE;
    private final String[] MODES;
    private final JTextField CUSTOMER_NAME;
    private final JTextField WAITER_NAME;
    
    public Customer_Panel(){
        MODES = new String[]{"Dine-In", "Take-Away"};
        EAT_MODE = new JComboBox(MODES);
        CUSTOMER_NAME = new JTextField("customer");
        WAITER_NAME = new JTextField("waiter");
        JLabel background = new JLabel(new ImageIcon("images/img1.jpg"));
        
        setLayout(null);
        
        add(background,JLayeredPane.DEFAULT_LAYER);
        add(EAT_MODE,JLayeredPane.DRAG_LAYER);
        add(CUSTOMER_NAME,JLayeredPane.DRAG_LAYER);
        add(WAITER_NAME,JLayeredPane.DRAG_LAYER);
        
        background.setBounds(0,0,400,400);
        EAT_MODE.setBounds(10,10,100,30);
        CUSTOMER_NAME.setBounds(10,50,150,40);
        WAITER_NAME.setBounds(10,100,150,40);
        
        EAT_MODE.addItemListener(
            (ItemEvent e) -> {
                if(EAT_MODE.getSelectedIndex() == 0){
                    WAITER_NAME.setVisible(true);
                }
                if(EAT_MODE.getSelectedIndex() == 1){
                    WAITER_NAME.setVisible(false);
                }
        });
        
        setSize(400,400);
        setOpaque(false);
    }
    public int getMode(){
        return EAT_MODE.getSelectedIndex();
    }
    public String getCustomerName(){
        return CUSTOMER_NAME.getText();
    }
    public String getWaiterName(){
        return WAITER_NAME.getText();
    }
}
