// Author: Gines Moratalla
// Student ID: 38879816

// Libraries used for this Calculator Project
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main Class that implements ActionListener to get responses from the keys
public class Calculator extends Operations implements ActionListener {

    // Instances for the calculator
    // Instance Objects from java.swing
    private JFrame calcFrame;
    private JTextField inputText;                                                 // Elements of the calculator
    private JTextArea OperationTracker;
    private JButton[] keys = new JButton[19];                                     // Buttons for the non-numerical keys in the calculator
    private JButton[] numbers = new JButton[10];                                  // Buttons for the numbers [0-9] in the calculator

    private String operationString;                                               // Input for the record TextArea
    private double firstNum = 0;                                                  // Variables for the different operations
    private double secondNum = 0;                                                 // Variables for the different operations

    private char operator;                                                        // Char used to detect symbols for non-unitary operations (two variables)
    private char complex_operator;                                                // Char used to detect symbols for unitary operations (one variable)



    public Calculator() {
        // Constructor for the calculator

        // Main Panel and Frame with all the keys
        calcFrame = new JFrame("Calculator App (Gines Moratalla)");
        calcFrame.setSize(450, 650);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel CalcPanel = new JPanel();                                          // Make the main Panel (where all the elements will be inside the frame)
        CalcPanel.setBackground(Color.DARK_GRAY);
        CalcPanel.setLayout(null);                                            // Not using any layout to manually position elements
        calcFrame.add(CalcPanel);

        // Display operation Tracker Area above
        OperationTracker = new JTextArea(3, 20);
        OperationTracker.setBounds(25, 20, 385, 80);
        OperationTracker.setFont(new Font("Font Name", Font.ITALIC, 24));
        OperationTracker.setEditable(false);
        CalcPanel.add(OperationTracker);

        // Display as a TextField
        inputText = new JTextField();
        inputText.setBounds(25, 100, 385, 50);
        inputText.setHorizontalAlignment(JTextField.RIGHT);                         // Text appears in the right side of the panel
        inputText.setFont(new Font("Font Name", Font.CENTER_BASELINE, 24));
        inputText.setEditable(false);
        CalcPanel.add(inputText);                                                   // Add it to the panel

        // Panel for the buttons of the calculator
        JPanel ButtonPanel = new JPanel();                                          // Initialize second panel (for the keys)
        ButtonPanel.setBackground(Color.DARK_GRAY);
        ButtonPanel.setBounds(10, 165, 415, 480);
        CalcPanel.add(ButtonPanel);                                                 // Add ButtonPanel to the main Panel

        // Add the buttons
        Dimension buttonDim = new Dimension(60, 80);                   // Create dimensions for the size of the buttons
        Dimension zeroButtonDim = new Dimension(125, 80);

        // fonts for the keys and the numbers (Some of them need to be bigger, since the symbols appear too small)
        Font myfont = new Font("myfont", Font.CENTER_BASELINE, 13);
        Font numberfont = new Font("myfont", Font.CENTER_BASELINE, 22);


        // This panel is made so it looks as similar as the example given as possible (order of the keys)
        // First Row create buttons
        keys[0] = new JButton("C");
        keys[1] = new JButton("e^x");
        keys[2] = new JButton("√");
        keys[3] = new JButton("+");
        keys[4] = new JButton("Log");
        keys[5] = new JButton("Sin");

        // Add them to the ButtonPanel with certain characteristics
        for (int i = 0; i < 6; i++) {
            keys[i].setFont(myfont);
            keys[i].setBackground(Color.LIGHT_GRAY);
            keys[i].setPreferredSize(buttonDim);                                    // Set smaller dimension
            keys[i].addActionListener(this);                                        // Set action listener to get as input
            keys[i].setFocusable(false);
            ButtonPanel.add(keys[i]);
        }
        // Set bigger size for some symbol keys that might be to small with buttonDim (first dimension)
        keys[0].setFont(numberfont);
        keys[3].setFont(numberfont);
        keys[2].setFont(numberfont);

        // Second row (first the number buttons)
        numbers[7] = new JButton("7");
        numbers[8] = new JButton("8");
        numbers[9] = new JButton("9");

        // Add buttons to the ButtonPanel
        for (int i = 7; i < 10; i++) {
            numbers[i].setFont(numberfont);
            numbers[i].setBackground(Color.white);
            numbers[i].setPreferredSize(buttonDim);
            numbers[i].addActionListener(this);                                     // Set action listener to get as input
            numbers[i].setFocusable(false);
            ButtonPanel.add(numbers[i]);
        }
        // Second row symbols
        keys[6] = new JButton("-");
        keys[7] = new JButton("In");
        keys[8] = new JButton("Cos");

        // Add them to the ButtonPanel
        for (int i = 6; i < 9; i++) {
            keys[i].setFont(myfont);
            keys[i].setBackground(Color.LIGHT_GRAY);
            keys[i].setPreferredSize(buttonDim);
            keys[i].addActionListener(this);
            keys[i].setFocusable(false);
            ButtonPanel.add(keys[i]);
        }
        // Set key 6 (only this one) to have the bigger font
        keys[6].setFont(numberfont);

        // Third row numbers
        numbers[4] = new JButton("4");
        numbers[5] = new JButton("5");
        numbers[6] = new JButton("6");

        // Add them to the ButtonPanel
        for (int i = 4; i < 7; i++) {
            numbers[i].setFont(numberfont);
            numbers[i].setBackground(Color.white);
            numbers[i].setPreferredSize(buttonDim);
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
            ButtonPanel.add(numbers[i]);
        }

        // Third row keys
        keys[9] = new JButton("*");
        keys[10] = new JButton("x^y");
        keys[11] = new JButton("Tan");

        // Add them to Button Panel
        for (int i = 9; i < 12; i++) {
            keys[i].setFont(myfont);
            keys[i].setBackground(Color.LIGHT_GRAY);
            keys[i].setPreferredSize(buttonDim);
            keys[i].addActionListener(this);
            keys[i].setFocusable(false);
            ButtonPanel.add(keys[i]);
        }
        // Set key 9 (*) to have the bigger font
        keys[9].setFont(numberfont);

        // Fourth row numbers
        numbers[1] = new JButton("1");
        numbers[2] = new JButton("2");
        numbers[3] = new JButton("3");

        // Add them to the ButtonPanel
        for (int i = 1; i < 4; i++) {
            numbers[i].setFont(numberfont);
            numbers[i].setBackground(Color.white);
            numbers[i].setPreferredSize(buttonDim);
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
            ButtonPanel.add(numbers[i]);
        }

        // Fourth row keys
        keys[12] = new JButton("/");
        keys[13] = new JButton("x^2");
        keys[14] = new JButton("Mod");

        // Add them to the table
        for (int i = 12; i < 15; i++) {
            keys[i].setFont(myfont);
            keys[i].setBackground(Color.LIGHT_GRAY);
            keys[i].setPreferredSize(buttonDim);
            keys[i].addActionListener(this);
            keys[i].setFocusable(false);
            ButtonPanel.add(keys[i]);
        }
        // Set key 12 (/) to have the bigger font
        keys[12].setFont(numberfont);

        // Button 0 has its own characteristics
        numbers[0] = new JButton("0");
        numbers[0].setFont(numberfont);
        numbers[0].setBackground(Color.white);
        numbers[0].setPreferredSize(zeroButtonDim);                                 // Set zero dimension (double the width)
        numbers[0].addActionListener(this);
        numbers[0].setFocusable(false);
        ButtonPanel.add(numbers[0]);

        // Fifth row keys
        keys[15] = new JButton(".");
        keys[16] = new JButton("=");
        keys[17] = new JButton("x^3");
        keys[18] = new JButton("x!");

        // Add them to the ButtonPanel
        for (int i = 15; i < 19; i++) {
            keys[i].setFont(myfont);
            keys[i].setBackground(Color.LIGHT_GRAY);
            keys[i].setPreferredSize(buttonDim);
            keys[i].addActionListener(this);
            keys[i].setFocusable(false);
            ButtonPanel.add(keys[i]);
        }
        // Change the fonts for (. and =) and change the colors of some keys to make a more pleasing appearance
        keys[15].setFont(numberfont);
        keys[16].setFont(numberfont);
        keys[16].setForeground(Color.white);
        keys[15].setBackground(Color.white);
        keys[16].setBackground(Color.BLUE);

        inputText.setText("0");                                                   // Initialize calculator input to 0
        calcFrame.setResizable(false);                                    // App not resizable
        calcFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {                                    // Action listener method to work with the user input


        for(int i = 0; i < 10; i++) {                                               // Number keys to display the number you press
            if(e.getSource() == numbers[i]) { 
                inputText.setText(inputText.getText().concat(String.valueOf(i)));   // Add actionperformed so the calculator displays the number you pressed
            }
        }

        // Add the rest of the funcitons for the keys
        if(e.getSource() == keys[0]) {                                              // Clear Function (C)
            if(!inputText.getText().isEmpty()) {                                    // if the display is not clean, clear it
                OperationTracker.setText("");                                     // Clear tracker display
                inputText.setText("");                                            // Clear display after
                firstNum = 0;                                                       // Reset
                secondNum = 0;                                                      // all
                result = 0;                                                         // saved numbers
            }
        }
        if(e.getSource() == keys[1]) {                                              // e^x
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = 'e';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[2]) {                                              // Sqrt function
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = '√';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[3]) {                                              // + function (add)
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            operator = '+';                                                         // set operator character for the switch case later
            complex_operator = '0';                                                 // set complex operator to 0 (to detect non-unitary operation)
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[4]) {                                              // Clear Function
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = 'L';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[5]) {                                              // Clear Function
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = 'S';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[6]) {                                              // - function (substract)
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            operator = '-';                                                         // set operator character for the switch case later
            complex_operator = '0';                                                 // set complex operator to 0 (to detect non-unitary operation)
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[7]) {                                              // Clear Function
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = 'i';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[8]) {                                              // Clear Function
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = 'C';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[9]) {                                              // * function (multiply)
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            operator = '*';                                                         // set operator character for the switch case later
            complex_operator = '0';                                                 // set complex operator to 0 (to detect non-unitary operation)
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[10]) {                                             // Clear Function
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            operator = 'y';                                                         // set operator character for the switch case later
            complex_operator = '0';                                                 // set complex operator to 0 (to detect non-unitary operation)
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[11]) {                                             // Clear Function
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = 'T';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[12]) {                                             // function (division)
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            operator = '/';                                                         // set operator character for the switch case later
            complex_operator = '0';                                                 // set complex operator to 0 (to detect non-unitary operation)
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[13]) {                                             // function (division)
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = '2';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[14]) {                                             // / function (division)
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            operator = 'M';                                                         // set operator character for the switch case later
            complex_operator = '0';                                                 // set complex operator to 0 (to detect non-unitary operation)
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[15]) {                                             // function . (turning into boolean)
            inputText.setText(inputText.getText().concat("."));                 // add a dot to the display to add decimals to the numbers
        }
        if(e.getSource() == keys[17]) {                                             // / function (division)
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = '3';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        if(e.getSource() == keys[18]) {                                             // function (division)
            firstNum = Double.parseDouble(inputText.getText());                     // Pass the current text of the display to the first variable
            complex_operator = '!';                                                 // set operator character for the switch case later
            inputText.setText("");                                                // Clear display after
        }
        // Operation for key "="
        if(e.getSource() == keys[16]) {                                             // = function equals to

            // 2 switch cases
            // a. "complex_operator" case one for unitary operations (one variable) e.g. "x!"
            // b. "operator" case for non-unitary operations (two variables) e.g. "+"

            if(complex_operator == '0') {                                           // if true, enter switch that contains two variables
                secondNum = Double.parseDouble(inputText.getText());                // initialize second variable to the second input of the user


                switch (operator) {                                                 // begin switch a

                    // Each case, according to the char stored in "operator" before, will perform a different operation
                    // Math. library used to perform certain operations

                    case '+':
                        result = sum(firstNum,secondNum);
                        operationString = firstNum + " + " + secondNum ;
                        break;
                    case '-':
                        result = sub(firstNum, secondNum);
                        operationString = firstNum + " - " + secondNum;
                        break;
                    case '*':
                        result = mult(firstNum, secondNum);
                        operationString = firstNum + " * " + secondNum;
                        break;
                    case '/':
                        result = div(firstNum, secondNum);
                        operationString = firstNum + " / " + secondNum;
                        break;
                    case 'M':
                        result = rem(firstNum, secondNum);
                        operationString = firstNum + " % " + secondNum;
                        break;
                    case 'y':
                        result = XtoY(firstNum, secondNum);
                        operationString = firstNum + " ^ " + secondNum;
                        break;
                }
                inputText.setText(String.valueOf(result));                          // Display result
                firstNum = result;                                                  // store result in the fist variable to use for more operations
            }
            switch (complex_operator) {

                // Each case, according to the char stored in "operator" before, will perform a different operation
                // Math. library used to perform certain operations

                case 'e':
                    result = etoX(firstNum);
                    operationString = "e^" + firstNum;
                    break;
                case 'L':
                    result = log(firstNum);
                    operationString = "log10(" + firstNum + ")";
                    break;
                case 'S':
                    result = Sin(firstNum);
                    operationString = "Sin(" + firstNum + ")";
                    break;
                case 'i':
                    result = In(firstNum);
                    operationString = "In(" + firstNum + ")";
                    break;
                case 'C':
                    result = cos(firstNum);
                    operationString = "Cos(" + firstNum + ")";
                    break;
                case 'T':
                    result = Tan(firstNum);
                    operationString = "Tan(" + firstNum + ")";
                    break;
                case '2':
                    result = xto2(firstNum);
                    operationString = firstNum + " ^ 2.0 ";
                    break;
                case '3':
                    result = xto3(firstNum);
                    operationString = firstNum + " ^ 3.0 ";
                    break;
                case '√':
                    result = root(firstNum);
                    operationString = "√ " + firstNum;
                    break;

                case '!':

                    // Special case factorial, checks if the input is less than 0 or if it has decimals
                    // Factorial stands for the product of all positive integers
                    // If the input does not have these characteristics, it will show an error

                    if (firstNum < 0 || firstNum%1 != 0) {
                        inputText.setText(String.valueOf("NaN"));
                        return;
                    }
                    // Calls factorial method declared at the beginning
                    operationString = firstNum + " !";
                    result = factorial(firstNum);
                    break;
            }
            OperationTracker.setText("\n = " + operationString);
            inputText.setText(String.valueOf(result));                          // Display result
            firstNum = result;                                                  // store result in the fist variable to use for more operations
        }
    }
}