package builders;

import model.WorkoutModel;

public class WorkoutBuilder {

    WorkoutModel workoutModel = new WorkoutModel();
    
    public WorkoutBuilder(WorkoutModel workoutModel){
        this.workoutModel=workoutModel;
    }

    public static WorkoutBuilder buildDefault() {
        WorkoutModel workoutModel = new WorkoutModel();
        workoutModel.setCaloriesBurned("300 kCal");
        workoutModel.setDistance("3.00 mi ~ 0:01.30");
        workoutModel.setHowIFelt("Great");
        workoutModel.setMinHR("32 bpm");
        workoutModel.setPerceivedEffort("2 (Light)");
        workoutModel.setAgeGroupPlace("21");
        workoutModel.setOverallPlace("345");
        workoutModel.setRun("Running");
        return new WorkoutBuilder(workoutModel);

    }
    public WorkoutBuilder(){
        workoutModel = new WorkoutModel();

    }
    public static WorkoutBuilder newValues() {
        return new WorkoutBuilder();
    }

    public WorkoutBuilder setCaloriesBurned(String caloriesBurned) {
        this.workoutModel.setCaloriesBurned(caloriesBurned);
        return this;
    }

    public WorkoutBuilder setRun(String run) {
        this.workoutModel.setRun(run);
        return this;
    }
    public WorkoutBuilder setDistance(String distance) {
        this.workoutModel.setDistance(distance);
        return this;
    }

    public WorkoutBuilder setHowIFelt(String howIFelt) {
        this.workoutModel.setHowIFelt(howIFelt);
        return this;
    }

    public WorkoutBuilder setMinHR(String minHR) {
        this.workoutModel.setMinHR(minHR);
        return this;
    }
    public WorkoutBuilder setPerceivedEffort(String perceivedEffort) {
        this.workoutModel.setPerceivedEffort(perceivedEffort);
        return this;
    }
    public WorkoutBuilder setAgeGroupPlace(String ageGroupPlace) {
        this.workoutModel.setAgeGroupPlace(ageGroupPlace);
        return this;
    }
    public WorkoutBuilder setOverallPlace(String overallPlace) {
        this.workoutModel.setOverallPlace(overallPlace);
        return this;}

    public WorkoutModel build() {
        return workoutModel;
    }
}
