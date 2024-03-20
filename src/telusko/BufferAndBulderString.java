package telusko;

public class BufferAndBulderString {
    
    public static void main(String[] args) {
        
        // StringBuffer is thread safe and StringBuilder is not and the commands are minimal when you know the seconds are getting too known
        StringBuffer sb = new StringBuffer("navin");
        System.out.println(sb.capacity());
        
        sb.append(" Redy");
        System.out.println(sb);

        String str = sb.toString();


        sb.insert(0, "java ");
        System.out.println(sb);


    }
}
