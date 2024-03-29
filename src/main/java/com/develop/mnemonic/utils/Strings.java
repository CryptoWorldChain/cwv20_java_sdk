package com.develop.mnemonic.utils;

import java.util.List;

public class Strings {
  public static String toCsv(List<String> src) {
    return join(src, ", ");
  }
  
  public static String join(List<String> src, String delimiter) {
    if (src != null) {
      StringBuilder builder = new StringBuilder();
      if (!src.isEmpty())
        builder.append(src.get(0)); 
      for (int i = 1; i < src.size(); i++)
        builder.append(delimiter).append(src.get(i)); 
      return builder.toString();
    } 
    return null;
  }
  
  public static String capitaliseFirstLetter(String string) {
    if (string == null || string.length() == 0)
      return string; 
    return string.substring(0, 1).toUpperCase() + string.substring(1);
  }
  
  public static String lowercaseFirstLetter(String string) {
    if (string == null || string.length() == 0)
      return string; 
    return string.substring(0, 1).toLowerCase() + string.substring(1);
  }
  
  public static String zeros(int n) {
    return repeat('0', n);
  }
  
  public static String repeat(char value, int n) {
    return (new String(new char[n])).replace("\000", String.valueOf(value));
  }
  
  public static boolean isEmpty(String s) {
    return (s == null || s.length() == 0);
  }
}


/* Location:              C:\Users\Administrator\Desktop\mnemonic-sdk-1.0.0.jar!\com\develop\mnemoni\\utils\Strings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */