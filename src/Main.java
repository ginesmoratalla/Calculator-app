// Author: Gines Moratalla
// Student ID: 38879816

public class Main {
    public static void main(String[] args) {
        // Main to initialize the calculator
        // Instance of Calculator
        new Calculator();
    }
}

/* 

DESIGN PATTERNS THAT CAN BE DETTECTED

In my code, we can identify some design patterns that were used to implement this calculator program.

*Factory Method*: We have a class Calculator, which will require the different methods for operations in its 
parent class Operations, encapsulating objects in separate components

*Observer Method*: The Actionlistener itself is already an observer, because it is handling user interactions

*Singleton Method*: the singleton method can be identified because only one instance of Calculator is being used throughout
the program

*Model-View-Controller (MVC)*: The panel, display for output text, textarea and buttons represent the View component that
displays the data to the user. The class Operations represents the Model component that
handles the data and logic of the application. The actionPerformed method represents the Controller component that 
receives input from the user and updates the Model and View accordingly.

 */