package posttest2;
public class Acc {
    protected String username;
    protected String password;

    public Acc(String user, String pw) {
        this.username = user;
        this.password = pw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String password) {
        this.password = password;
    }
}
