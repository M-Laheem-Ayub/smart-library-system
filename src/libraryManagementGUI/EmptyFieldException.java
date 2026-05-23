package libraryManagementGUI;

// "extends Exception" likhna zaroori hai taake yeh custom exception ban jaye
public class EmptyFieldException extends Exception { 
    
    // Yeh constructor String message receive karta hai (jo error me aa raha tha)
    public EmptyFieldException(String message) {
        super(message); 
    }
}