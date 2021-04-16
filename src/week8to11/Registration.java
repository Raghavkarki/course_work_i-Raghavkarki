package week8to11;

public class Registration {
	public String registerUser(String[] userDetail) {
        FileHandler fh = new FileHandler();
        return fh.CreateOrAdd(Constants.userDetailFileName, userDetail);
    }


}
