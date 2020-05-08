package pizza_order_system;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Food_Panel extends JLayeredPane{
    
    private final JComboBox PIZZA;
    private final JComboBox FLAVOURS;
    private final JComboBox DRINK;
    private final JCheckBox SALAD;
    private final String[] PIZZA_CHOICE;
    private final String[] DRINK_CHOICE;
    private final String[] FLAVOUR_CHOICE;
    
    public Food_Panel(){
        PIZZA_CHOICE = new String[]{"Regular", "Large", "Small"};
        DRINK_CHOICE = new String[]{"Select Drink", "Coca Cola", "7up", "Pepsi", "Mrinda"};
        FLAVOUR_CHOICE = new String[]{"Chicken Tikka", "Chicken Fajita", "Meat Lover", "Chicken Supreme", "Vegi"};
        PIZZA = new JComboBox(PIZZA_CHOICE);
        DRINK = new JComboBox(DRINK_CHOICE);
        FLAVOURS =  new JComboBox(FLAVOUR_CHOICE);
        SALAD = new JCheckBox("Salad");
        JLabel background = new JLabel(new ImageIcon("images/img2.jpg"));
        
        setLayout(null);
        
        add(background,JLayeredPane.DEFAULT_LAYER);
        add(PIZZA,JLayeredPane.DRAG_LAYER);
        add(DRINK,JLayeredPane.DRAG_LAYER);
        add(FLAVOURS,JLayeredPane.DRAG_LAYER);
        add(SALAD,JLayeredPane.DRAG_LAYER);
        
        background.setBounds(0,0,400,400);
        PIZZA.setBounds(10,10,100,30);
        FLAVOURS.setBounds(120,10,150,30);
        DRINK.setBounds(10,50,100,30);
        SALAD.setBounds(10,90,70,30);
        
        setSize(400,400);
        setOpaque(false);
    }
    public String getPizzaSize(){
        switch(PIZZA.getSelectedIndex()){
            case 0:
                return "Regular";
            case 1:
                return "Large";
            default:
                return "Small";
        }
    }
    public int getPizzaPrice(){
        switch(PIZZA.getSelectedIndex()){
            case 0:
                return 500;
            case 1:
                return 800;
            default:
                return 300;
        }
    }
    public String getFlavour(){
        switch(FLAVOURS.getSelectedIndex()){
            case 0:
                return "Chicken Tikka";
            case 1:
                return "Chicken Fajita";
            case 2:
                return "Meat Lover";
            case 3:
                return "Chicken Supreme";
            default:
                return "Vegi";
        }
    }
    public String getDrink(){
        switch(DRINK.getSelectedIndex()){
            case 0:
                return null;
            case 1:
                return "Coca Cola";
            case 2:
                return "7up";
            case 3:
                return "Pepsi";
            default:
                return "Mrinda";
        }
    }
    public int getDrinkPrice(){
        switch(DRINK.getSelectedIndex()){
            case 0:
                return 0;
            default:
                return 50;
        }
    }
    public boolean getSalad(){
        return SALAD.isSelected() == true;
    }
}
