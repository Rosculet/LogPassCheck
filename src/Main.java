public class Main {
    public static void main(String[] args) {

        System.out.println(createAccount("123c_``", "123", "123"));

    }

    // Хочу создать метод который будет выявлять ВСЕ ошибки ввода при создании логина и пароля.
    public static boolean createAccount(String login, String password, String confirmPassword) {

        boolean switchKey = true ;

        // Login checking
        try {
            if (!login.matches("[A-Za-z0-9_]+") || login.length() > 20) {
                throw new WrongLoginException();
            }
        } catch (WrongLoginException logEx) {
            System.out.println(logEx.getMessage());
            switchKey  = false;}

        // Password symbols checking
        try {
            if (!password.matches("[A-Za-z0-9_]+") || password.length() > 20)
                throw new WrongPasswordException();
        } catch (WrongPasswordException passEx) {
            System.out.println(passEx.getMessage());
            switchKey  = false;
        }

        // Password match checking
        try{
            if(!password.equals(confirmPassword))
                throw new WrongPasswordException();
        } catch (WrongPasswordException matchEx) {
            System.out.println("Passwords doesn't match ");
            switchKey  = false;
        }
        return switchKey ;
    }
}