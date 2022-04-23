package steps;

import forms.CreatedWorkoutComponent;
import forms.DropdownWorkout;
import forms.InputWorkout;
import io.qameta.allure.Step;
import model.WorkoutModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddWorkoutPage;
import pages.HomePage;

public class AddWorkoutSteps extends AbstractStep {

    public AddWorkoutSteps(WebDriver driver) {
        super(driver);
    }
    private HomePage homePage;

    AddWorkoutPage addWorkoutPage = new AddWorkoutPage(driver);

    @Step(" Adding workout")
    public AddWorkoutSteps addWorkout(){
        homePage = new HomePage(driver);
        homePage.openAddWorkoutButton();
        validatePageIsLoaded(addWorkoutPage);
        return this;
    }

    @Step("Filling and saving the workout")
    public AddWorkoutSteps createNewWorkout(WorkoutModel workoutModel){
        addWorkoutPage.addRunningWorkout();
        fillAccountForm(workoutModel);
        addWorkoutPage.saveWorkout();
        return this;

    }

    @Step("Fill in  the data")
    private void fillAccountForm(WorkoutModel workoutModel){

        new InputWorkout(driver, "Name").input(workoutModel.getWorkoutName());
        new InputWorkout(driver, "Duration").input(String.valueOf(workoutModel.getDuration()));
        new InputWorkout(driver, "MinHR").input(String.valueOf(workoutModel.getMinHR()));
        new InputWorkout(driver, "kCal").input(workoutModel.getCaloriesBurned());
        new InputWorkout(driver, "hf_great").clickHowIFeel();
        new InputWorkout(driver, "IsRace").clickCheckBoxMarkAsRace();
        new InputWorkout(driver, "Pace").input(String.valueOf(workoutModel.getPace()));
        new DropdownWorkout(driver, "WorkoutTime").selectOption(workoutModel.getTimeOfDay());
        new DropdownWorkout(driver, "PerEffort").selectOption2(workoutModel.getPerceivedEffort());
        new InputWorkout(driver, "OverallPlace").input(String.valueOf(workoutModel.getOverallPlace()));
        new InputWorkout(driver, "AgeGroupPlace").input(String.valueOf(workoutModel.getAgeGroupPlace()));
        new InputWorkout(driver, "Distance").input(String.valueOf(workoutModel.getDistance()));

    }

    @Step("Validation of a properly Created Workout")
    public void validateWorkoutCreated(WorkoutModel expectedModel) {
        WorkoutModel actualModel = getCreatedWorkout();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("New workout is not valid: %s", actualModel)
        );
    }

    @Step("Actual data of created workout")
    private WorkoutModel getCreatedWorkout( ) {
        WorkoutModel actualModel = new WorkoutModel();
        actualModel.setDistance(new CreatedWorkoutComponent(driver, "Workout Statistics:").getValueWorkoutStatistics());
        actualModel.setRun(new CreatedWorkoutComponent(driver, "Run").getValueRunning());
        actualModel.setOverallPlace(new CreatedWorkoutComponent(driver, "Overall Place:").getValueOverallPlace());
        actualModel.setAgeGroupPlace(new CreatedWorkoutComponent(driver, "Age Group Place:").getValueAgeGroupPlace());
        actualModel.setHowIFelt(new CreatedWorkoutComponent(driver, "How I Felt:").getValueHowIFElt());
        actualModel.setPerceivedEffort(new CreatedWorkoutComponent(driver, "Perceived Effort").getValuePerceivedEffort());
        actualModel.setMinHR(new CreatedWorkoutComponent(driver, "Min HR:").getValueMinHR());
        actualModel.setCaloriesBurned(new CreatedWorkoutComponent(driver, "Calories Burned:").getValueCaloriesBurned());
        return actualModel;
    }
}
