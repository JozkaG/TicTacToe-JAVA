public class LinkedList {
    private Node head;  // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
        initialize();

    }

    private void initialize() {
        for (int i = 0; i < 9; i++) { // Create the nodes for tictactoe
            insertAtEnd(""); //
        }
    }

    // Method to insert a new node at the end
    public void insertAtEnd(String data) {
        // To be implemented
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        // To be implemented
        Node current = head;
        int index = 1;
        while(current != null){
            if(index == position){
                current.data = data;
                break;
            }
            current = current.next;
            index++;
        }
    }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        // To be implemented
        Node current = head;
        int index =1;
        while(current != null){
            if (index == position){
                return current.data;
            }
            current = current.next;
            index++;
        }
        return "";
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        Node current = head;
        for (int i = 0; i < 3; i++) { // Display 3 rows
            for (int j = 0; j < 3; j++) {
                System.out.print(current.data.isEmpty() ? "_" : current.data);
                if (j < 2) System.out.print("|"); // Print column separator
                current = current.next;
            }
            System.out.println(); // New line
            if (i < 2) System.out.println(""); // separate the rows
        }
    }

    // Method to check for a win
    public boolean checkWinCondition() {
        //FIRST CHECKING ROWS
        Node current = head;
        for(int i=0; i<3; i++){
            String c = current.data;
            if (!c.isEmpty() &&c.equals(current.next.data) && c.equals(current.next.next.data)) {
                return true;
            }
        }
        current = current.next.next.next; //move to next rows

        //CHECK FOR COLUMNS
        current = head;
        for(int i=0; i<3; i++){
            String c = current.data;
            if (!c.isEmpty() && c.equals(current.next.data) && c.equals(current.next.next.data)) {
                return true;
            }
            current = current.next; //moves to next columns
        }

        return false;

    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        // To be implemented
        Node current = head;
        while(current != null){
            if (current.data.isEmpty()){
                return false;
            }
            current = current.next;
        }
        return true;
    }

    // Method to reset the board
    public void resetBoard() {
        // To be implemented
        Node current = head;
        while(current != null){
            current.data = "";
            current = current.next;
        }
    }


}
