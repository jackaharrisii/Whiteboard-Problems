
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

*note that there is no situation where more robots than required crops saves us a day, because math

d1 + d1 = (d2)(r*2^d1)

 */

public class CloningRobots {

    Integer numberOfRobots = 1;
    Integer numberOfCrops = 0;

    public Integer findFewestDays(Integer cropGoal){
        Integer days = Integer.MAX_VALUE;
        Integer counter = 0;
        for (int i = 1; numberOfRobots > cropGoal; i++){
            for (int d = 1; numberOfCrops > cropGoal; d++) {

            }
        }
        return days;
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
