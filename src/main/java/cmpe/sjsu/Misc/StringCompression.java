package cmpe.sjsu.Misc;

public class StringCompression {

    /**
     *
     * @param str
     * @return
     */
    public String compress(String str){
        int count = 1;
        int size = str.length();
        String compressedString="";
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i<str.length(); i++){
            //compare with previous character. If matches increase the count.
            if(str.charAt(i) == str.charAt(i-1) && i < size-1){
                count++;
            }
            else if(i == str.length()-1 && str.charAt(i) == str.charAt(i-1)){
                count++;
                compressedString+=str.charAt(i);
                compressedString+=count;
                //builder.append(str.charAt(i));
                //builder.append(count);
            }

            // case where the last letter is NOT in the sequence preceding it. Add it to string.
            else if(i == size-1 && str.charAt(i) != str.charAt(i-1)){
                compressedString+=str.charAt(i-1);
                compressedString+=count;
                //builder.append(str.charAt(i-1));
                //builder.append(count);
                count = 1;
                compressedString+=str.charAt(i);
                compressedString+=count;
                //builder.append(str.charAt(i));
                //builder.append(count);
            }
            else{
                // appending the character and THEN appending the count works.

                compressedString+=str.charAt(i-1);
                //builder.append(str.charAt(i-1));
                if(count!=1)
                    compressedString+=count;
                    //builder.append(count);
                count = 1;
            }

        }

        //str = builder.toString();
        System.out.println(compressedString);

        return compressedString;
    }

    public static void main(String[] args){
        StringCompression test = new StringCompression();
        test.compress("aaaaabbbbbbbbbccccpqrstuv");
    }
}
