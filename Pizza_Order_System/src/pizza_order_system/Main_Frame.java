package pizza_order_system;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main_Frame extends JFrame implements ActionListener{
    
    private final JButton NEW_ORDER;
    private final JButton RESET;
    private final JButton NEXT;
    
    private final Customer_Panel panel1;
    private final Food_Panel panel2;
    private final Billing_Counter panel3;
    private int STATE = 1;
    
    public Main_Frame(){
        super("Foods");
        Container container;
        container = getContentPane();
        setLayout(null);
        
        NEW_ORDER = new JButton("New Order");
        RESET = new JButton("Reset");
        NEXT = new JButton("Next");
        panel1 = new Customer_Panel();
        panel2 = new Food_Panel();
        panel3 = new Billing_Counter(panel1,panel2);
        
        NEW_ORDER.setBounds(10,10,170,50);
        NEW_ORDER.setBorder(null);
        NEW_ORDER.setIcon(new ImageIcon("images/new_order.png"));
        NEW_ORDER.addActionListener(this);
        
        RESET.setBounds(210,10,170,50);
        RESET.setBorder(null);
        RESET.addActionListener(this);
        
        NEXT.setBounds(0,510,400,45);
        NEXT.setBorder(null);
        NEXT.addActionListener(this);
        
        panel1.setLocation(0,70);
        panel2.setLocation(0,70);
        panel3.setLocation(0,70);
        
        container.add(NEW_ORDER);
        container.add(RESET);
        container.add(NEXT);
        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setMinimumSize(new Dimension(400,600));
        setVisible(true);
        start();
    }
    
    public void start(){
        switch(STATE){
            case 1:
                panel1.setVisible(true);
                panel2.setVisible(false);
                panel3.setVisible(false);
                NEXT.setEnabled(true);
                RESET.setEnabled(false);
                NEW_ORDER.setEnabled(false);
                break;
            case 2:
                panel1.setVisible(false);
                panel2.setVisible(true);
                panel3.setVisible(false);
                NEXT.setEnabled(true);
                RESET.setEnabled(true);
                NEW_ORDER.setEnabled(false);
                break;
            case 3:
                panel3.makeRecipt();
                panel1.setVisible(false);
                panel2.setVisible(false);
                panel3.setVisible(true);
                NEXT.setEnabled(false);
                RESET.setEnabled(false);
                NEW_ORDER.setEnabled(true);
                break;
        }
    }
    public void makeRecipt(){
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == NEXT){
            STATE++;
            start();
        }
        if(e.getSource() == NEW_ORDER){
            STATE = 1;
            start();
        }
        if(e.getSource() == RESET){
            STATE = 1;
            start();
        }
    }
}
