/* MULTITHREADING <MyClass.java>
 * EE422C Project 6 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * Slip days used: <0>
 * Spring 2019
 */
package assignment6;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    int numRows;
    int seatsPerRow;
    int nextBestSeat;
    String show;
    ArrayList<Seat> totalSeats;
    ArrayList<Ticket> issuedTickets;
    final Object lock = new Object();
    boolean isSoldOutPrint;

    /**
     * the delay time you will use when print tickets
     */
    private int printDelay = 50; // 50 ms.  Use it in your Thread.sleep()

    public void setPrintDelay(int printDelay) {
        this.printDelay = printDelay;
    }

    public int getPrintDelay() {
        return printDelay;
    }

    /**
     * Represents a seat in the theater
     * A1, A2, A3, ... B1, B2, B3 ...
     */
    static class Seat {
        private int rowNum;
        private int seatNum;

        public Seat(int rowNum, int seatNum) {
            this.rowNum = rowNum;
            this.seatNum = seatNum;
        }

        public int getSeatNum() {
            return seatNum;
        }

        public int getRowNum() {
            return rowNum;
        }

        @Override
        public String toString() {
            String result = "";
            int tempRowNumber = rowNum + 1;
            do {
                tempRowNumber--;
                result = ((char) ('A' + tempRowNumber % 26)) + result;
                tempRowNumber = tempRowNumber / 26;
            } while (tempRowNumber > 0);
            result += seatNum;
            return result;
        }
    }

    /**
     * Represents a ticket purchased by a client
     */
    static class Ticket {
        private String show;
        private String boxOfficeId;
        private Seat seat;
        private int client;
        public static final int ticketStringRowLength = 31;


        public Ticket(String show, String boxOfficeId, Seat seat, int client) {
            this.show = show;
            this.boxOfficeId = boxOfficeId;
            this.seat = seat;
            this.client = client;
        }

        public Seat getSeat() {
            return seat;
        }

        public String getShow() {
            return show;
        }

        public String getBoxOfficeId() {
            return boxOfficeId;
        }

        public int getClient() {
            return client;
        }

        @Override
        public String toString() {
            String result, dashLine, showLine, boxLine, seatLine, clientLine, eol;

            eol = System.getProperty("line.separator");

            dashLine = new String(new char[ticketStringRowLength]).replace('\0', '-');

            showLine = "| Show: " + show;
            for (int i = showLine.length(); i < ticketStringRowLength - 1; ++i) {
                showLine += " ";
            }
            showLine += "|";

            boxLine = "| Box Office ID: " + boxOfficeId;
            for (int i = boxLine.length(); i < ticketStringRowLength - 1; ++i) {
                boxLine += " ";
            }
            boxLine += "|";

            seatLine = "| Seat: " + seat.toString();
            for (int i = seatLine.length(); i < ticketStringRowLength - 1; ++i) {
                seatLine += " ";
            }
            seatLine += "|";

            clientLine = "| Client: " + client;
            for (int i = clientLine.length(); i < ticketStringRowLength - 1; ++i) {
                clientLine += " ";
            }
            clientLine += "|";

            result = dashLine + eol +
                    showLine + eol +
                    boxLine + eol +
                    seatLine + eol +
                    clientLine + eol +
                    dashLine;

            return result;
        }
    }

    public Theater(int numRows, int seatsPerRow, String show) {
        // TODO: Implement this constructor
        this.numRows  = numRows;
        this.seatsPerRow = seatsPerRow;
        this.show = show;
        totalSeats = new ArrayList<>(); //ArrayList which holds creates and holds all the seats before hand
        issuedTickets = new ArrayList<>(); //Arraylsit which keeps track of tickets in the order they are issued
        nextBestSeat = 0; //index of the next best seat
        isSoldOutPrint = false; //Boolean used to ensure is sold out is only printed once
        for(int i = 0;i<numRows;i++){
            for(int j = 0;j<seatsPerRow;j++){
                Seat tempSeat = new Seat(i,j+1);  //Creating all the seats
                totalSeats.add(tempSeat);
            }
        }
    }

    /**
     * Calculates the best seat not yet reserved
     *
     * @return the best seat or null if theater is full
     */
    public synchronized Seat bestAvailableSeat() {
        if(nextBestSeat>= numRows*seatsPerRow){
            return null; //if no more seats left
        }
        return totalSeats.get(nextBestSeat++); //Get the next best seat and increment the index
    }

    /**
     * Prints a ticket for the client after they reserve a seat
     * Also prints the ticket to the console
     *
     * @param seat a particular seat in the theater
     * @return a ticket or null if a box office failed to reserve the seat
     */
    public synchronized Ticket printTicket(String boxOfficeId, Seat seat, int client) {
        // TODO: Implement this method
        if(seat == null ){ //if soldout
            if(!isSoldOutPrint)
                System.out.println("Sorry, we are sold out!");
            isSoldOutPrint = true;
            return null;
        }
        if (issuedTickets.size()>= numRows*seatsPerRow) { //if soldout
            return null;
        }

        Ticket newTicket = new Ticket(show,boxOfficeId,seat,client); //Create new ticket
        String toPrint = newTicket.toString();
        System.out.println(toPrint); //print the new ticket

        try{
            Thread.sleep(printDelay); //Sleep
        } catch (Exception e){
            e.printStackTrace(); //try catch block for exceptions thrown by thread.sleep
        }
        issuedTickets.add(newTicket); //add the new ticket to the arraylist
        return newTicket;
    }

    /**
     * Lists all tickets sold for this theater in order of purchase
     *
     * @return list of tickets sold
     */
    public List<Ticket> getTransactionLog() {
        return issuedTickets;
    }
}
