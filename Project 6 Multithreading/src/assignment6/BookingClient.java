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

import java.util.*;
import java.lang.Thread;

public class BookingClient {

    ArrayList<BoxOffice> offices;
    Theater theater;

    /**
     * @param office  maps box office id to number of customers in line
     * @param theater the theater where the show is playing
     */
    public BookingClient(Map<String, Integer> office, Theater theater) {
        // TODO: Implement this constructor
        this.offices = new ArrayList<>(); //Create new Arraylist Which holds BoxOffices
        this.theater = theater;
        //create array list of box offices
        Set<String> b = office.keySet();
        for(String s : b){
            this.offices.add(new BoxOffice(s,office.get(s))); //Add Box offices based on input office Map by iterating through the map
        }
    }

    public class BoxOffice implements Runnable{
        String boxOfficeID;
        int numClients;

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */

        public BoxOffice(String boxOfficeID,int numClients){
            this.boxOfficeID = boxOfficeID;
            this.numClients = numClients;
        }

        @Override
        public void run() {
            for(int i = numClients;i>0;i--){ //For each client get the next best seat and issue that ticket
                Theater.Seat seat = null;
                synchronized (theater.lock) {
                    seat = theater.bestAvailableSeat();
                }
                theater.printTicket(boxOfficeID, seat, theater.nextBestSeat); //Client ID is based on the seat they are given so it is always unique
            }
        }
    }

    /**
     * Starts the box office simulation by creating (and starting) threads
     * for each box office to sell tickets for the given theater
     *
     * @return list of threads used in the simulation,
     * should have as many threads as there are box offices
     */
    public List<Thread> simulate() {
        // TODO: Implement this method

        ArrayList<Thread> threads = new ArrayList<>();

        //Iterate through all the box offices in office and create a new thread for each one
        for(BoxOffice b : offices){
            Thread BX = new Thread(b);
            BX.start();
            threads.add(BX);
        }
        return threads;
    }

    public static void main(String[] args) {
        // TODO: Initialize test data to description
        Map<String, Integer> test_office = new HashMap<String, Integer>();

        test_office.put("BX1", 3);
        test_office.put("BX3", 3);
        test_office.put("BX2", 4);
        test_office.put("BX5", 3);
        test_office.put("BX4", 3);

        Theater test_theater = new Theater(3, 5, "Ouija");
        BookingClient bc = new BookingClient(test_office, test_theater);

        // Create box offices
        List<Thread> BoxOffices = bc.simulate();

        // Join the threads
        for(Thread t : BoxOffices) {
            try {
                t.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
