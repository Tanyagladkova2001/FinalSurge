package utils;

import model.ProfileModel;

public class ProfileModelUtils {

    public static  ProfileModel getDefaultProfileModel() {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setGender("Female");
        profileModel.setBirthday("11/20/1991");
        profileModel.setWeight("48");
        profileModel.setWeightType("kg");
        profileModel.setCountry("Belarus");
        profileModel.setState("Minskaya voblasts");
        profileModel.setCity("Borisov");
        profileModel.setZip("202101");
        return profileModel;
    }
}
