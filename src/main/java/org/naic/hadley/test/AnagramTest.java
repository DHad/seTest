package org.naic.hadley.test;


import java.util.HashMap;
import java.lang.IllegalArgumentException;

public class AnagramTest {

    public static void main(String[] args) throws Exception{

        if(args.length < 2) {
            throw new Exception("You must pass exactly two String arguments to this program.");
        }

        if(args.length > 2) {
            throw new IllegalArgumentException("You must pass exactly two String arguments to this program.");
        }

        isAnagram(args[0], args[1]);
    }


    static void isAnagram(String firstWord, String secondWord){
        //Removing white spaces, lowercasing

        String copyOfFirstWord = firstWord.replaceAll("\\s", "").toLowerCase();

        String copyOfSecondWord = secondWord.replaceAll("\\s", "").toLowerCase();

        boolean isAnagram = true;

        if(firstWord.length() != copyOfSecondWord.length()){
            //quick fail if not the same length

            isAnagram = false;
        }
        else{

            //make a hashmap with key: value format of "character: occurrences"
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();


            //increment and decrement occurrences value each time a character is matched -- so if a character is present
            // more times in one word, its occurrences value will be non zero, ie characters occurring more in the
            // first word have a positive number of occurrences

            for (int i = 0; i < copyOfFirstWord.length(); i++){

                char characterToMatch = copyOfFirstWord.charAt(i);
                int numberOfCharOccurrences = 0;

                if(map.containsKey(characterToMatch)){
                    numberOfCharOccurrences = map.get(characterToMatch);
                }

                map.put(characterToMatch, ++numberOfCharOccurrences);

                characterToMatch = copyOfSecondWord.charAt(i);

                numberOfCharOccurrences = 0;

                if(map.containsKey(characterToMatch)){
                    numberOfCharOccurrences = map.get(characterToMatch);
                }

                map.put(characterToMatch, --numberOfCharOccurrences);
            }

            for (int value : map.values()){
                if(value != 0){
                    isAnagram = false;
                }
            }

        }

        System.out.println(isAnagram);
    }
}
