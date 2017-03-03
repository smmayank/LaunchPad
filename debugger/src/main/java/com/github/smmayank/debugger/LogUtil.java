package com.github.smmayank.debugger;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.IllegalFormatException;
import java.util.Locale;

/**
 * Util class used for logging and debugging
 *
 * @author Mayank Saxena
 * @version 1.0
 * @since 2017-03-02
 */
public final class LogUtil {

    /**
     * Flag denotes whether in debug more or not.
     */
    public static final boolean DEBUGGABLE = BuildConfig.DEBUG;

    /**
     * method get's the class name from any object
     * in case static caller can pass class instance
     *
     * @param caller
     *     caller instance or class instance in case of static
     *
     * @return Class name {{@link Class#getSimpleName()}}
     */
    @NonNull
    private static String getTag(@NonNull Object caller) {
        if (caller instanceof Class<?>) {
            return ((Class) caller).getSimpleName();
        }
        return caller.getClass().getSimpleName();
    }

    /**
     * Returns a formatted string using the {{@link Locale#ENGLISH}}, format string,
     * and arguments.
     *
     * @param format
     *     A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args
     *     Arguments referenced by the format specifiers in the format
     *     string.  If there are more arguments than format specifiers, the
     *     extra arguments are ignored.  The number of arguments is
     *     variable and may be zero.  The maximum number of arguments is
     *     limited by the maximum dimension of a Java array as defined by
     *     <cite>The Java&trade; Virtual Machine Specification</cite>.
     *     The behaviour on a
     *     <tt>null</tt> argument depends on the <a
     *     href="../util/Formatter.html#syntax">conversion</a>.
     *
     * @return A formatted string
     *
     * @throws IllegalFormatException
     *     If a format string contains an illegal syntax, a format
     *     specifier that is incompatible with the given arguments,
     *     insufficient arguments given the format string, or other
     *     illegal conditions.  For specification of all possible
     *     formatting errors, see the <a
     *     href="../util/Formatter.html#detail">Details</a> section of the
     *     formatter class specification
     * @throws NullPointerException
     *     If the <tt>format</tt> is <tt>null</tt>
     * @see java.util.Formatter
     */
    @NonNull
    private static String getMessage(@NonNull String format, @Nullable Object[] args) {
        if (null == args) {
            return format;
        }
        return String.format(Locale.ENGLISH, format, args);
    }

    /**
     * Debug Logs formatted string using the {{@link Locale#ENGLISH}}, format string, and
     * arguments, only when {{@link #DEBUGGABLE}} is set also see {{@link Log#d(String, String)}}
     *
     * @param caller
     *     caller instance or class instance in case of static
     * @param format
     *     A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args
     *     Arguments referenced by the format specifiers in the format
     *     string.  If there are more arguments than format specifiers, the
     *     extra arguments are ignored.  The number of arguments is
     *     variable and may be zero.  The maximum number of arguments is
     *     limited by the maximum dimension of a Java array as defined by
     *     <cite>The Java&trade; Virtual Machine Specification</cite>.
     *     The behaviour on a
     *     <tt>null</tt> argument depends on the <a
     *     href="../util/Formatter.html#syntax">conversion</a>.
     *
     * @throws IllegalFormatException
     *     If a format string contains an illegal syntax, a format
     *     specifier that is incompatible with the given arguments,
     *     insufficient arguments given the format string, or other
     *     illegal conditions.  For specification of all possible
     *     formatting errors, see the <a
     *     href="../util/Formatter.html#detail">Details</a> section of the
     *     formatter class specification
     * @throws NullPointerException
     *     If the <tt>format</tt> is <tt>null</tt>
     * @see java.util.Formatter
     */
    public static void logD(@NonNull Object caller, @NonNull String format,
        @Nullable Object... args) {
        if (DEBUGGABLE) {
            String tag = getTag(caller);
            String message = getMessage(format, args);
            Log.d(tag, message);
        }
    }

    /**
     * Info Logs formatted string using the {{@link Locale#ENGLISH}}, format string, and
     * arguments, see {{@link Log#i(String, String)}}
     *
     * @param caller
     *     caller instance or class instance in case of static
     * @param format
     *     A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args
     *     Arguments referenced by the format specifiers in the format
     *     string.  If there are more arguments than format specifiers, the
     *     extra arguments are ignored.  The number of arguments is
     *     variable and may be zero.  The maximum number of arguments is
     *     limited by the maximum dimension of a Java array as defined by
     *     <cite>The Java&trade; Virtual Machine Specification</cite>.
     *     The behaviour on a
     *     <tt>null</tt> argument depends on the <a
     *     href="../util/Formatter.html#syntax">conversion</a>.
     *
     * @throws IllegalFormatException
     *     If a format string contains an illegal syntax, a format
     *     specifier that is incompatible with the given arguments,
     *     insufficient arguments given the format string, or other
     *     illegal conditions.  For specification of all possible
     *     formatting errors, see the <a
     *     href="../util/Formatter.html#detail">Details</a> section of the
     *     formatter class specification
     * @throws NullPointerException
     *     If the <tt>format</tt> is <tt>null</tt>
     * @see java.util.Formatter
     */
    public static void logI(@NonNull Object caller, @NonNull String format,
        @Nullable Object... args) {
        String tag = getTag(caller);
        String message = getMessage(format, args);
        Log.i(tag, message);
    }
}
