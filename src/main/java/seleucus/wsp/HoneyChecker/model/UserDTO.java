package seleucus.wsp.HoneyChecker.model;

public class UserDTO {

    private String id;
    private String userName;

    public UserDTO() {
    }

   public UserDTO(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
