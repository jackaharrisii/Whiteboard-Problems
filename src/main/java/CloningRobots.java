
/*
Given: a single robot
the robot can perform one of two actions: clone itself or plant a crop
all robots must do the same task each day and each of the two actions take an entire day

Task: plant a given number of crops in the fewest number of days

Example: Plant 10 crops
1 robot plants all the crops: 10 days, 10 crops
2 robots: 6 days, 10 crops
4 robots: 5 days, 12 crops
8 robots: 5 days, 16 crops
16 robots: 5 days, 16 crops*
Answer: 5 days

Example: Plant 20 crops
1 robot   : 20 days : 20 crops
2 robots  : 11 days : 20 crops
4 robots  : 7 days  : 20 crops
8 robots  : 6 days  : 24 crops
16 robots : 6 days  : 32 crops
32 robots : 6 days  : 32 crops

Example: Plant 30 crops
1 robot   : 30 days : 30 crops
2 robots  : 16 days : 30 crops
4 robots  : 10 days : 32 crops
8 robots  : 7 days  : 32 crops
16 robots : 6 days  : 32 crops
32 robots : 6 days  : 32 crops

Example: Plant 50 crops
1 robot   : 50 days : 50 crops
2 robots  : 26 days : 50 crops
4 robots  : 15 days : 52 crops
8 robots  : 10 days : 56 crops
16 robots : 8 days  : 64 crops
32 robots : 7 days  : 64 crops
64 robots : 7 days  : 64 crops

*note that there is no situation where more robots than required crops saves us a day, because math
that said, there is also no situation where simply making more robots than the required number of crops and planting once is beaten

STRETCH GOAL: FIND THE FEWEST NUMBER OF ROBOTS THAT CAN DO THE TASK IN THE FEWEST NUMBER OF DAYS

 */

public class CloningRobots {

    Integer numberOfRobots = 1;
    Integer numberOfCrops = 0;

    public Integer findFewestDays(Integer cropGoal){
        Integer days = 0;
        for (int i = 1; numberOfRobots < cropGoal; i++){
            goForthAndMultiply();
            days++;
        }
        return days + 1;
    }

    public Integer[] findFewestRobots(Integer cropGoal){
        Integer days = cropGoal;  // if the single robot does all the work
        Integer lowestNumberOfRobots = 1;
        for (int i = 1; numberOfRobots * 2 < cropGoal; i++){
            goForthAndMultiply();
            Integer count = i + (int)Math.ceil((cropGoal/numberOfRobots) + 0.5);
            if (count < days){
                days = count;
                lowestNumberOfRobots = numberOfRobots;
            }
        }
        return new Integer[] { lowestNumberOfRobots, days };
    }

    public void goForthAndMultiply(){
        this.numberOfRobots *= 2;
    }

    public void sowTheSeeds(){
        this.numberOfCrops += numberOfRobots;
    }


    public Integer getNumberOfRobots() {
        return numberOfRobots;
    }

    public void setNumberOfRobots(Integer numberOfRobots) {
        this.numberOfRobots = numberOfRobots;
    }

    public Integer getNumberOfCrops() {
        return numberOfCrops;
    }

    public void setNumberOfCrops(Integer numberOfCrops) {
        this.numberOfCrops = numberOfCrops;
    }

}
