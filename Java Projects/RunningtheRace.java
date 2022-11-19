import java.util.Scanner;

public class RunningtheRace
{
   public static void main (String [] args)
   {
      Scanner keyboard = new Scanner (System.in);
      
      String runnerName1;
      String runnerName2;
      String runnerName3;
      double runnerTime1;
      double runnerTime2;
      double runnerTime3;
      String raceResults = "";
      
      System.out.println ("Enter the name of runner 1");
      runnerName1 = keyboard.nextLine();
      System.out.println ("How many minutes did " + runnerName1 + " took to finish the race?");
      runnerTime1 = keyboard.nextDouble();
      
      keyboard.nextLine();
      
      System.out.println ("Enter the name of runner 2");
      runnerName2 = keyboard.nextLine();
      System.out.println ("How many minutes did " + runnerName2 + " took to finish the race?");
      runnerTime2 = keyboard.nextDouble();
      
      keyboard.nextLine();
      
      System.out.println ("Enter the name of runner 3");
      runnerName3 = keyboard.nextLine();
      System.out.println ("How many minutes did " + runnerName3 + " took to finish the race?");
      runnerTime3 = keyboard.nextDouble();
      
      if (runnerTime1 < runnerTime2 && runnerTime1 < runnerTime3) {
         raceResults += runnerName1 + " finished the race in " + runnerTime1 + " minutes and got 1st place!\n";
         if (runnerTime2 < runnerTime3) {
            raceResults += runnerName2 + " finished the race in " + runnerTime2 + " minutes and got 2nd place!\n";
            raceResults += runnerName3 + " finished the race in " + runnerTime3 + " minutes and got 3rd place!";
         } else {
            raceResults += runnerName3 + " finished the race in " + runnerTime3 + " minutes and got 2nd place!\n";
            raceResults += runnerName2 + " finished the race in " + runnerTime2 + " minutes and got 3rd place!";
         }
      } else if (runnerTime2 < runnerTime1 && runnerTime2 < runnerTime3) {
         raceResults += runnerName2 + " finished the race in " + runnerTime2 + " minutes and got 1st place!\n";
         if (runnerTime1 < runnerTime3) {
            raceResults += runnerName1 + " finished the race in " + runnerTime1 + " minutes and got 2nd place!\n";
            raceResults += runnerName3 + " finished the race in " + runnerTime3 + " minutes and got 3rd place!";
         } else {
            raceResults += runnerName3 + " finished the race in " + runnerTime3 + " minutes and got 2nd place!\n";
            raceResults += runnerName1 + " finished the race in " + runnerTime1 + " minutes and got 3rd place!";
         }
      } else if (runnerTime3 < runnerTime1 && runnerTime3 < runnerTime2) {
         raceResults += runnerName3 + " finished the race in " + runnerTime3 + " minutes and got 1st place!\n";
         if (runnerTime1 < runnerTime2) {
            raceResults += runnerName1 + " finished the race in " + runnerTime1 + " minutes and got 2nd place!\n";
            raceResults += runnerName2 + " finished the race in " + runnerTime2 + " minutes and got 3rd place!";
         } else {
            raceResults += runnerName2 + " finished the race in " + runnerTime2 + " minutes and got 2nd place!\n";
            raceResults += runnerName1 + " finished the race in " + runnerTime1 + " minutes and got 3rd place!";
         }
      }
      System.out.println (raceResults);
   }
}