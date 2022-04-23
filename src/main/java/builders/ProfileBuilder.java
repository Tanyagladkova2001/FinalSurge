package builders;


import model.ProfileModel;

public class ProfileBuilder {

    public ProfileBuilder(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    public static  ProfileBuilder defaultProfile() {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setGender("Female");
        profileModel.setBirthday("11/20/1991");
        profileModel.setWeight("48");
        profileModel.setWeightType("kg");
        profileModel.setCountry("Belarus");
        profileModel.setState("Minskaya voblasts");
        profileModel.setCity("Borisov");
        profileModel.setZip("202101");
        return new ProfileBuilder(profileModel);
    }

    ProfileModel profileModel = new ProfileModel();

    public static ProfileBuilder newValues() {
        return new ProfileBuilder();
    }

    public ProfileBuilder() {}

    public ProfileBuilder setGender(String gender){
        this.profileModel.setGender(gender);
        return this;
    }
    public ProfileBuilder setBirthday(String birthday){
        this.profileModel.setBirthday(birthday);
        return this;
    }
    public ProfileBuilder setWeight(String weight){
        this.profileModel.setWeight(weight);
        return this;
    }
    public ProfileBuilder setCountry(String country){
        this.profileModel.setCountry(country);
        return this;
    }
    public ProfileBuilder setState(String state){
        this.profileModel.setState(state);
        return this;
    }
    public ProfileBuilder setCity(String city){
        this.profileModel.setCity(city);
        return this;
    }
    public ProfileBuilder setZip(String zip){
        this.profileModel.setZip(zip);
        return this;
    }
    public ProfileModel build() {
        return profileModel;
    }
}
