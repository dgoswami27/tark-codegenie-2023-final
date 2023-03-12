import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Coaches {
    int sl = 0;
    int b1 = 0;
    int a1 = 0;
    int h1 = 0;
}

class Train {
    int trainNo;
    String trainOrigin;
    String trainStop;
    String trainRoute;
    int totalFar;
}

class ReservationRequest {
    String origin;
    String departure;
    String route;
    String date;
    String coach;
    int noOfPassengers;
}

class AvailableSeats {
    Coaches c = new Coaches();
    int sl = c.sl;
    int b1 = c.b1;
    int a1 = c.a1;
    int h1 = c.h1;
}

class TotalFar {
    int sl = 1;
    int b1 = 2;
    int a1 = 3;
    int h1 = 4;
}

public class Milestone1 {
    static List<Train> trainList = new ArrayList<Train>();
    static List<ReservationRequest> bookingList = new ArrayList<ReservationRequest>();
    static List<AvailableSeats> availableSeats = new ArrayList<AvailableSeats>();
    static int pnrNo = 100000001;

    public static void bookTicket(String origin, String destination,String route, String date, String coach, int noOfPassengers) {
        TotalFar t = new TotalFar();
        for (Train train : trainList) {
            if (train.trainRoute == route) 
            {
                for (ReservationRequest r : bookingList) 
                {
                    for (AvailableSeats a : availableSeats) 
                    {
                        if (coach == "SL") {
                            if (a.sl != 0) {
                                bookingList.add(r);
                                a.sl -= 1;
                                int totalFar = t.sl * train.totalFar * noOfPassengers;
                                System.out.println(pnrNo + " " + totalFar);
                                pnrNo++;
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
                                pnrNo++;
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
                                pnrNo++;
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
                                pnrNo++;
                            }
                            else 
                                System.out.println("No Seats Available");
                        }
                    }
                }
            }
            else
                System.out.println("No Trains Available");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTrains = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < noOfTrains; i++) {
            Train train = new Train();
            Coaches coach = new Coaches();

            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            String str1[] = s1.split(" ");
            train.trainNo = Integer.parseInt(str1[0]);
            train.trainOrigin = str1[1].substring(0, str1[1].length() - 2);
            int j = 0;
            while (str1[2].charAt(j) != '-') {
                j++;
            }
            train.trainStop = str1[2].substring(0, j);
            train.trainRoute = train.trainOrigin + train.trainStop;
            train.totalFar = Integer.parseInt(str1[2].substring(j + 2, str1[2].length()));

            String str2[] = s2.split(" ");
            int n = str2[1].length();
            for(int k=1; k<=n; k++)
            {
                if(str2[k].charAt(0) == 'S')
                coach.sl += Integer.parseInt(str2[k].substring(n-2));

                if(str2[k].charAt(0) == 'B')
                coach.b1 += Integer.parseInt(str2[k].substring(n-2));

                if(str2[k].charAt(0) == 'A')
                coach.a1 += Integer.parseInt(str2[k].substring(n-2));

                if(str2[k].charAt(0) == 'H')
                coach.h1 += Integer.parseInt(str2[k].substring(n-2));
            }

            trainList.add(train);
        }

        while (true) {
            String str = sc.nextLine();
            String s[] = str.split(" ");
            ReservationRequest r = new ReservationRequest();
            r.origin = s[0];
            r.departure = s[1];
            r.route = r.origin + r.departure;
            r.date = s[2];
            r.coach = s[3];
            r.noOfPassengers = Integer.parseInt(s[4]);
            bookTicket(r.origin, r.departure,r.route, r.date, r.coach, r.noOfPassengers);
        }
    }
}
