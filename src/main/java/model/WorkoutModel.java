package model;

import lombok.Data;

@Data
public class  WorkoutModel {
    String WorkoutName;
    String Distance;
    String Duration;
    int Pace;
    String HowIFelt;
    String MinHR;
    String CaloriesBurned;
    String PerceivedEffort;
    String MarkAsRace;
    String TimeOfDay;
    String OverallPlace;
    String AgeGroupPlace;
    String Run;

    public WorkoutModel() {

    }

}