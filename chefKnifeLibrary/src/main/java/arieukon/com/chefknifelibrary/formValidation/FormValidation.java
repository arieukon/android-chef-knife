package arieukon.com.chefknifelibrary.formValidation;

/**
 * Created by arieukon on 04/12/16.
 */

public class FormValidation {

    public static boolean required(String value) {
        if (value.trim().length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean validEmail(String email) {
        boolean validEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        if (validEmail) {
            return true;
        }
        return false;
    }

    public static boolean validPhone(String phone) {
        if (phone.trim().length() > 9) {
            return true;
        }
        return false;
    }

    public static boolean validKodePos(String input) {
        if (input.trim().length() == 5) {
            return true;
        }
        return false;
    }

    public static boolean validNoKTP(String input) {
        if (input.trim().length() == 16) {
            return true;
        }
        return false;
    }

    public static boolean validKodePelanggan(String input) {
        if (input.trim().length() > 5) {
            return true;
        }
        return false;
    }

    public static boolean validKodePelangganPLN(String input) {
        if (input.trim().length() > 9) {
            return true;
        }
        return false;
    }

    public static boolean validPin(String pin) {
        if (pin.trim().length() == 6) {
            return true;
        }
        return false;
    }

    public static boolean validUsername(String username) {
        if (username.trim().length() > 3) {
            return true;
        }
        return false;
    }

    public static boolean validAmount(String input) {
        if (input.trim().length() > 2) {
            return true;
        }
        return false;
    }

    public static boolean validNominalPHL(String input) {
        if (Integer.valueOf(input.trim()) >= 1000) {
            return true;
        }
        return false;
    }

    public static boolean validFullname(String input) {
        String result = input.replaceAll("[^a-zA-Z\\s]", "");

        int originalLeng = input.length();
        int newLeng = result.length();

        if (originalLeng == newLeng) {
            return true;
        }
        return false;
    }
}
