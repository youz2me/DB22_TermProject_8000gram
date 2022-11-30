public class Operator {
    Database db = null;
    Login mf = null;

    public static void main(String[] args) {
        Operator opt = new Operator();
        opt.db = new Database();
        opt.mf = new Login(opt);
    }
}