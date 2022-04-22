package utils;
import model.WorkoutModel;

public class WorkoutModelUtils {
    public static WorkoutModel getWorkModel() {
        WorkoutModel workoutModel = new WorkoutModel();
        workoutModel.setCaloriesBurned("300");
        workoutModel.setWorkoutName("Running");
        workoutModel.setDistance("3");
        workoutModel.setDuration("1.30");
        workoutModel.setMinHR("32" );
        workoutModel.setPerceivedEffort("2 (Light)");
        workoutModel.setTimeOfDay("06:15 AM");
        workoutModel.setAgeGroupPlace("21");
        workoutModel.setPace(2);
        workoutModel.setOverallPlace("345");
        return workoutModel;
    }

}
