import java.util.List;
import java.util.Scanner;

class Coaches {
    int s1;
    int s2;
    int b1;
    int a1;
    int h1;
}

class Train {
    int trainNo;
    String trainOrigin;
    String trainStop;
    int totalFar;
}

class ReservationRequest {
    String origin;
    String departure;
    String date;
    String coach;
    int noOfPassengers;
}

class AvailableSeats {
    Coaches c = new Coaches();
    int s1 = c.s1;
    int s2 = c.s2;
    int b1 = c.b1;
    int a1 = c.a1;
    int h1 = c.h1;
}

class TotalFar {
    int s1 = 1;
    int s2 = 1;
    int b1 = 2;
    int a1 = 3;
    int h1 = 4;
}

public class Milestone1 {
    static List<Train> trainList;
    static List<ReservationRequest> bookingList;
    static List<AvailableSeats> availableSeats;
    int pnrNo = 100000001;

    public void bookTicket(String origin, String destination, String date, String coach, int noOfPassengers) {
        TotalFar t = new TotalFar();
        for (Train train : trainList) {
            if (train.trainOrigin.equals(origin) && train.trainStop.equals(destination)) 
            {
                for (ReservationRequest r : bookingList) 
                {
                    for (AvailableSeats a : availableSeats) 
                    {
                        if (coach == "SL") {
                            if (a.s1 != 0 || a.s2 != 0) {
                                bookingList.add(r);
                                if (a.s1 != 0)
                                    a.s1 -= 1;
                                else
                                    a.s2 -= 1;
                                int totalFar = t.s1 * train.totalFar * noOfPassengers;
                                System.out.println(pnrNo + " " + totalFar);
                            }
                            else 
                                System.out.println("No Seats Available");
                        }
                        if (coach == "3A") {
                            if (a.b1 != 0) {
                                bookingList.add(r);
                                a.b1 -= 1;
                                int totalFar = t.b1 * train.totalFar * noOfPassengers;
                                System.out.println(pnrNo + " " + totalFar);
                            }
                            else 
                                System.out.println("No Seats Available");
                        }
                        if (coach == "2A") {
                            if (a.a1 != 0) {
                                bookingList.add(r);
                                a.a1 -= 1;
                                int totalFar = t.a1 * train.totalFar * noOfPassengers;
                                System.out.println(pnrNo + " " + totalFar);
                            }
                            else 
                                System.out.println("No Seats Available");
                        }
                        if (coach == "1A") {
                            if (a.h1 != 0) {
                                bookingList.add(r);
                                a.h1 -= 1;
                                int totalFar = t.h1 * train.totalFar * noOfPassengers;
                                System.out.println(pnrNo + " " + totalFar);
                            }
                            else 
                                System.out.println("No Seats Available");
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTrains = sc.nextInt();
        for (int i = 0; i < noOfTrains; i++) {
            Train train = new Train();
            Coaches coach = new Coaches();

            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            String str1[] = s1.split("\\s");
            train.trainNo = Integer.parseInt(str1[0]);
            train.trainOrigin = str1[1].substring(0, str1[1].length() - 3);
            int j = 0;
            while (str1[2].charAt(j) != '-') {
                j++;
            }
            train.trainStop = str1[2].substring(0, j);
            train.totalFar = Integer.parseInt(str1[2].substring(j + 2, str1[2].length()));

            String str2[] = s2.split("\\s");
            int n = str2[1].length();
            coach.s1 = Integer.parseInt(str2[1].substring(n - 3));
            n = str2[2].length();
            coach.s2 = Integer.parseInt(str2[2].substring(n - 3));
            n = str2[3].length();
            coach.b1 = Integer.parseInt(str2[3].substring(n - 3));
            n = str2[4].length();
            coach.a1 = Integer.parseInt(str2[4].substring(n - 3));
            n = str2[5].length();
            coach.h1 = Integer.parseInt(str2[5].substring(n - 3));

            trainList.add(train);
        }

        while (true) {
            String str = sc.nextLine();
            String s[] = str.split("\\s");
            ReservationRequest r = new ReservationRequest();
            r.origin = s[0];
            r.departure = s[1];
            r.date = s[2];
            r.coach = s[3];
            r.noOfPassengers = Integer.parseInt(s[4]);
            bookTicket(s[0], s[1], s[2], s[3], s[4]);
        }
    }
}
