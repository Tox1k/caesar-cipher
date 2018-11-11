package sol;

public class Text {

    private char[] text;

    Text(String s){
        text = s.toCharArray();
    };
    Text(char[] c){
        text = c;
    };

    public void setText(String s){
        text = s.toCharArray();
    };

    public String getString(){
        return String.valueOf(text);
    }

    public char[] getCharArray(){
        return text;
    }

    public int[] getAsciiArray(){
        int[] ascii = new int[text.length];
        for(int i = 0; i < text.length; i++) {
            ascii[i] = (int) text[i];
        }
        return ascii;
    };

    public int length(){
        return text.length;
    }

    public char charAt(int index){
        return getCharArray()[index];
    }

    public int asciiAt(int index){
        return getAsciiArray()[index];
    }
}
