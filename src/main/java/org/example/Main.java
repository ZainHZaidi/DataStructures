package org.example;
import Java.

public class Main {

    public static String encode(String key, String word){
        String newthing = "";
        for(int i = 0; i < word.length(); i++){
            newthing += (char)((int)word.charAt(i) + (int)key.charAt(i) - 97);
        }
        System.out.println(newthing);
        return "s";
    }


    public static void main(String[] args) {
        String key;
        String word;
        String keyOrg = key;
        if (key.length() <= word.length()){
            for(int i = 0; i < word.length() / key.length(); i++){
                key = key + keyOrg;
            }
        }
        encode("abcde", "hello");
    }
}