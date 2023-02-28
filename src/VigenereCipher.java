public class VigenereCipher {
    private String key;
    private String alphabet;

    public VigenereCipher(String k){
        this.key = k.toLowerCase();
        this.alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    public String getKey() {return key;}
    public void setKey(String k) {key = k;}
    public String getAlphabet() {return alphabet;}
    public void setAlphabet(String a) {alphabet = a;}

    public String encode(String e){
        String f = "";
        key += key;
        key += key;
        for (int i = 0; i<e.length(); i++){
            if(alphabet.indexOf(e.charAt(i)) == -1){f += e.charAt(i);}
            else{
                int s = alphabet.indexOf(e.charAt(i)) + alphabet.indexOf(key.charAt(i));
                if (s > 52) {s -= 26;}
                f += alphabet.charAt(s);
            }
        }
        return f.toLowerCase();
    }

    public String decode(String e){
        String f = "";
        key += key;
        key += key;
        for (int i = 0; i<e.length(); i++) {
            if (alphabet.indexOf(e.charAt(i)) == -1) {f += e.charAt(i);}
            else {
                int s = alphabet.indexOf(e.charAt(i)) - alphabet.indexOf(key.charAt(i));
                if (s < 0) {s += 26;}
                f += alphabet.charAt(s);
            }
        }
        return f.toLowerCase();
    }
    

}
