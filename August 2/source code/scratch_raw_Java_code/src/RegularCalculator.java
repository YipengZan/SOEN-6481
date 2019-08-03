import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;

class MyException extends Exception{
    public MyException() {
        super();
    }
    public MyException(String message) {
        super(message);
    }
}

class SwingConsole{
    public static void run(final JFrame f,final int width,final int height){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width,height);
                f.setVisible(true);
            }
        });
    }
}

public class RegularCalculator extends JFrame{
    /*
     *
     */
    private JTextField textField;
    private String input;
    private String operator;

    public RegularCalculator() {
        input = "";
        operator = "";

        Container container = this.getContentPane();
        JPanel panel = new JPanel();
        textField = new JTextField(30);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.LEFT);
        //textField.setBounds(100, 100, 20, 20);
        textField.setPreferredSize(new Dimension(200,30));
        container.add(textField, BorderLayout.NORTH);

        String[] name= {"7","8","9","+","4","5","6","-","1","2","3","*","0","C","=","/"};

        panel.setLayout(new GridLayout(4,4,1,1));

        for(int i=0;i<name.length;i++) {
            JButton button = new JButton(name[i]);
            button.addActionListener(new MyActionListener());
            panel.add(button);
        }
        container.add(panel,BorderLayout.CENTER);
    }

    class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int cnt=0;
            String actionCommand = e.getActionCommand();
            if(actionCommand.equals("+") || actionCommand.equals("-") || actionCommand.equals("*")
                    || actionCommand.equals("/")) {
                input += " " + actionCommand + " ";
            }
            else if(actionCommand.equals("C")) {
                input = "";
            }
            else if(actionCommand.equals("=")) {
                try {
                    input+= "="+calculate(input);
                } catch (MyException e1) {
                    if(e1.getMessage().equals("Infinity"))
                        input+= "=" + e1.getMessage();
                    else
                        input = e1.getMessage();
                }
                textField.setText(input);
                input="";
                cnt = 1;
            }
            else
                input += actionCommand;

            if(cnt == 0)
                textField.setText(input);
        }
    }

    private String calculate(String input) throws MyException{
        String[] comput = input.split(" ");
        Stack<Double> stack = new Stack<>();
        Double m = Double.parseDouble(comput[0]);
        stack.push(m);

        for(int i = 1; i < comput.length; i++) {
            if(i%2==1) {
                if(comput[i].equals("+"))
                    stack.push(Double.parseDouble(comput[i+1]));
                if(comput[i].equals("-"))
                    stack.push(-Double.parseDouble(comput[i+1]));
                if(comput[i].equals("*")) {
                    Double d = stack.peek();
                    stack.pop();
                    stack.push(d*Double.parseDouble(comput[i+1]));
                }
                if(comput[i].equals("/")) {
                    double help = Double.parseDouble(comput[i+1]);
                    if(help == 0)
                        throw new MyException("Infinity");
                    double d = stack.peek();
                    stack.pop();
                    stack.push(d/help);
                }
            }
        }

        double d = 0d;

        while(!stack.isEmpty()) {
            d += stack.peek();
            stack.pop();
        }

        String result = String.valueOf(d);
        return result;
    }

//    public static void main(String[] args) {
//        SwingConsole.run(new RegularCalculator(), 250, 300);
//    }
}
