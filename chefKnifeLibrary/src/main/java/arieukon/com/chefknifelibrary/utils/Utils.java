package arieukon.com.chefknifelibrary.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by arieukon on 21/02/18.
 */

public class Utils {
    /**
     * Represent to show toast message with long duration
     *
     * @param context
     * @param message
     */
    public static void showToastLong(Context context, CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * Represent to show toast message with short duration
     *
     * @param context
     * @param message
     */
    public static void showToastShort(Context context, CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Response to get screen width of device
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * Resize View
     * @param v = view
     * @param width = view width
     * @param height = view height
     */
    public static void resize(View v, int width, int height) {
        v.getLayoutParams().width = width;
        v.getLayoutParams().height = height;
    }

    /**
     * helper class for converting dp to pixel
     *
     * @param context
     * @param dp
     * @return
     */
    public static float pxFromDp(final Context context, final float dp) {
        if (context != null) {
            return dp * context.getResources().getDisplayMetrics().density;
        }
        return 0;
    }

    /**
     * Covert number to IDR format
     * @param number
     * @param isWithSymbol
     * @return
     */
    public static String numberToIDR(int number, boolean isWithSymbol) {
        String numberIDR = NumberFormat.getInstance(Locale.GERMANY).format(number);
        if (isWithSymbol) {
            return "Rp " + numberIDR;
        } else {
            return numberIDR;
        }
    }

    /**
     * Covert number to IDR format
     * @param number
     * @param isWithSymbol
     * @return
     */
    public static String numberToIDR(Long number, boolean isWithSymbol) {
        String numberIDR = NumberFormat.getInstance(Locale.GERMANY).format(number);
        if (isWithSymbol) {
            return "Rp " + numberIDR;
        } else {
            return numberIDR;
        }
    }

    /**
     * Covert number to IDR format
     * @param number
     * @param isWithSymbol
     * @return
     */
    public static String numberToIDR(long number, boolean isWithSymbol) {
        String numberIDR = NumberFormat.getInstance(Locale.GERMANY).format(number);
        if (isWithSymbol) {
            return "Rp " + numberIDR;
        } else {
            return numberIDR;
        }
    }

    /**
     * Covert number to IDR format
     * @param number
     * @param isWithSymbol
     * @return
     */
    public static String numberToIDR(double number, boolean isWithSymbol) {
        String numberIDR = NumberFormat.getInstance(Locale.GERMANY).format(number);
        if (isWithSymbol) {
            return "Rp " + numberIDR;
        } else {
            return numberIDR;
        }
    }

    public static String getSimpleTime(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String time = sdf.format(new Date());
        return time;
    }

    public static String formatDate(String format, String dateTime){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = fmt.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat fmtOut = new SimpleDateFormat(format);
        return fmtOut.format(date);
    }

    public static String formatDate(String dateTime, String format, String originFormat){
        SimpleDateFormat fmt = new SimpleDateFormat(originFormat);
        Date date = null;
        try {
            date = fmt.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat fmtOut = new SimpleDateFormat(format);
        return fmtOut.format(date);
    }

    /**
     * Get Time Stamp
     *
     * @return
     */
    public static String getTimestamp(){
        Long timestampLong = System.currentTimeMillis() / 1000;
        return timestampLong.toString();
    }

    /**
     * Get Nano Time
     *
     * @return
     */
    public static String getNanoTime(){
        Long nanoTime = System.nanoTime();
        return nanoTime.toString();
    }

    /**
     * Set specific margin
     * @param v = View
     * @param l = margin left
     * @param t = margin top
     * @param r = margin right
     * @param b = margin bottom
     */
    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    /**
     * This method for show progress bar dialog
     *
     * @param context
     * @return dialog
     */
    public static Dialog getProgressDialog(Context context, int layoutId) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layoutId);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        return dialog;
    }

    /**
     * Replace country code with zero
     * @param number
     * @return
     */
    public static String countryCodeReplacedWithZero(String number) {
        String validNumber = number.replaceAll("\\+|\\-|\\ ", "");

        if (!("0".equals(validNumber.substring(0, 1)))) {
            String tempNumber = validNumber.substring(2);
            validNumber = "0" + tempNumber;
        }
        return validNumber;
    }

    /**
     * Remove currency format
     * @param input
     * @return
     */
    public static String removeCurrencyFormat(String input){
        String result = input.replaceAll("[a-zA-Z]|\\.|\\ ", "");
        return result;
    }

    /**
     * Get Alphabet only from text
     * @param input
     * @return
     */
    public static String getAlphabetOnly(String input){
        String result = input.replaceAll("[^a-zA-Z\\s]", "");
        return result;
    }

    /**
     * Get HTML Content
     *
     * @param content
     * @return
     */
    public static Spanned getHTMLContent(String content){
        return Html.fromHtml(content);
    }

    /**
     * Get Age
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }
}
