package finalsurge;


import builders.ProfileBuilder;
import model.ProfileModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ProfileModelUtils;
import utils.TestListener;

@Listeners({TestListener.class})
public class AddProfileTest extends BaseTest {

    ProfileModel testProfile = ProfileModelUtils.getDefaultProfileModel();
    ProfileModel testProfile2 = ProfileBuilder.defaultProfile().build();


    @Test(description =  "Тестирование нового профиля")
    public void addNewProfileTest() {
        mainStep
                .openFinalLoginPage()
                .loginWithValidCred()
                .openSettingPage()
                .openEditProfilePage()
                .createNewProfile(testProfile)
                .validateProfileCreated(testProfile2)
        ;

    }
}

