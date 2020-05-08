package pizza_order_system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Billing_Counter extends JPanel{
    
    private final JTextArea TEXT;
    private final JButton ORDER;
    private final Customer_Panel panel1;
    private final Food_Panel panel2;
    
    public Billing_Counter(Customer_Panel panel1,Food_Panel panel2){
        setLayout(null);
        
        this.panel1 = panel1;
        this.panel2 = panel2;
        
        TEXT = new JTextArea();
        TEXT.setEditable(false);
        TEXT.setBackground(null);
        TEXT.setOpaque(false);
        ORDER = new JButton("Print");
        add(ORDER);
        add(TEXT);
        TEXT.setBounds(0,0,400,400);
        TEXT.setFont(new Font("Arial",Font.PLAIN,20));
        ORDER.setBounds(10,350,70,30);
       
        
        setSize(400,400);
        setOpaque(true);
        setBackground(new Color(215,200,80));
    }
    public void makeRecipt(){
                                        TEXT.setText("               Friends Pizza Hut" + "\n");
                                        TEXT.append("Name: "+panel1.getCustomerName() + "\n");
        if(panel1.getMode() == 0)       TEXT.append("Waiter: "+panel1.getWaiterName() + "\n");
                                        TEXT.append("               ORDER: \n");
                                        TEXT.append("Pizza: "+panel2.getPizzaSize() + "\n");
                                        TEXT.append("Flavour: "+panel2.getFlavour() + "\n");
        if(panel2.getDrink()!= null)    TEXT.append("Drink: "+panel2.getDrink() + "\n");
        if(panel2.getSalad())           TEXT.append("Salad"+"\n");
                                        TEXT.append("--------------------------------------------------------\n");
                                        TEXT.append("Price: "+price() + "\n");
        if(panel1.getMode() == 0)       TEXT.append("Service Charges: "+ ((price()/100)*2) + "\n");
                                        TEXT.append("GST: "+gst() + "\n");
                                        TEXT.append("Total: "+ (price()+gst()+((price()/100)*2)) + "\n");
    }
    public int price(){
        int price=0;
        price += panel2.getPizzaPrice();
        price += panel2.getDrinkPrice();
        if(panel2.getSalad()) price += 110;
        return price;
    }
    public int gst(){
        return ((price()/100)*7);
    }
}