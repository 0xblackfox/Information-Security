public class PlayFair {
    private String keyword="";
    private String key="";
    private char[][] matrix= new char[5][5];

    public void ModifyKey(String key){
        String k = key.toUpperCase();
        String KeyAdjust="";
        boolean flag= false;
        KeyAdjust= KeyAdjust+ k.charAt(0);

        for(int i=0;i<k.length();i++){
            for(int j=0;j<KeyAdjust.length();j++){
                if(k.charAt(i)==KeyAdjust.charAt(j)){
                    flag=true;
                }
            }
            if(flag==false){
                KeyAdjust = KeyAdjust+k.charAt(i);
            }
            flag=false;
        }
        keyword=KeyAdjust;
    }

    public void KeyGenerate(){
        boolean flag=true;
        char current;
        key = keyword;
        for(int i=0;i<26;i++){
            current = (char) (i+65);
            if(current=='J'){
                continue;
            }
            for(int j=0;j<keyword.length();j++){
                if(current == keyword.charAt(j)){
                    flag= false;
                    break;
                }
            }
            if(flag){
                key = key+current;
            }
            flag=true;
        }
        System.out.println(key);

        int counter =0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                matrix [i][j]=key.charAt(counter);
                System.out.println(matrix[i][j]+ "  ");
                counter++;
            }
            System.out.println();
        }
    }

    public String format(String old_text)
    {
        int i = 0;
        int len = 0;
        String text = new String();
        len = old_text.length();
        for (int tmp = 0; tmp < len; tmp++)
        {
            if (old_text.charAt(tmp) == 'j')
            {
                text = text + 'i';
            }
            else
                text = text + old_text.charAt(tmp);
        }
        len = text.length();
        for (i = 0; i < len; i = i + 2)
        {
            if (text.charAt(i + 1) == text.charAt(i))
            {
                text = text.substring(0, i + 1) + 'x' + text.substring(i + 1);
            }
        }
        return text;
    }

    public String[] Dividetext(String new_string){
        String original = format(new_string);
        int size = original.length();
        if(size%2 !=0){
            size++;
            original = original + 'x';
        }
        String x[] = new String[size/2];
        int counter =0;
        for(int i=0;i< size/2 ;i++){
            x[i] = original.substring(counter,counter+2);
            counter+=2;
        }
        return x;
    }

    public int[] getcharpos (char ch){
        int[] keypos = new int[2];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(matrix[i][j]==ch){
                    keypos[0]=i;
                    keypos[1]=j;
                    break;
                }
            }
        }
        return keypos;
    }

    public String encrypt(String msg){
        String[] msg_pair = Dividetext(msg);
        String encryptmsg= "";
        for(int i=0;i< msg_pair.length;i++){
            char ch1= msg_pair[i].charAt(0);
            char ch2= msg_pair[i].charAt(1);
            int[] ch1pos = getcharpos(ch1);
            int[] ch2pos = getcharpos(ch2);

            //if both the characters are in the same row
            if(ch1pos[0]==ch2pos[0]){
                ch1pos[1]=(ch1pos[1]+1)%5;
                ch2pos[1]=(ch2pos[1]+1)%5;
            }
            //if both the characters are in the same column
            else if(ch1pos[1]==ch2pos[1]){
                ch1pos[0]=(ch1pos[0]+1)%5;
                ch2pos[0]=(ch2pos[0]+1)%5;
            }
            else{
                int temp= ch1pos[1];
                ch1pos[1]=ch2pos[1];
                ch2pos[1]=temp;
            }

            encryptmsg=encryptmsg+ matrix[ch1pos[0]][ch1pos[1]]+matrix[ch2pos[0]][ch2pos[1]];
        }
        return encryptmsg;
    }
//    public String decrypt(String msg){
//        String[] msg_pair = Dividetext(msg);
//        String decryptmsg= "";
//        for(int i=0;i< msg_pair.length;i++){
//            char ch1= msg_pair[i].charAt(0);
//            char ch2= msg_pair[i].charAt(1);
//            int[] ch1pos = getcharpos(ch1);
//            int[] ch2pos = getcharpos(ch2);
//
//            //if both the characters are in the same row
//            if(ch1pos[0]==ch2pos[0]){
//                ch1pos[1]=(ch1pos[1]-1)%5;
//                if(ch1pos[1]<0) ch1pos[1]+=5;
//                ch2pos[1]=(ch2pos[1]-1)%5;
//                if(ch2pos[1]<0) ch2pos[1]+=5;
//            }
//            //if both the characters are in the same column
//            else if(ch1pos[1]==ch2pos[1]){
//                ch1pos[0]=(ch1pos[0]-1)%5;
//                if(ch1pos[0]<0) ch1pos[0]+=5;
//                ch2pos[0]=(ch2pos[0]-1)%5;
//                if(ch2pos[0]<0) ch2pos[0]+=5;
//            }
//            else{
//                int temp= ch1pos[1];
//                ch1pos[1]=ch2pos[1];
//                ch2pos[1]=temp;
//            }
//
//            decryptmsg=decryptmsg+ matrix[ch1pos[0]][ch1pos[1]]+matrix[ch2pos[0]][ch2pos[1]];
//        }
//        decryptmsg= formatdecrypt(decryptmsg);
//        return decryptmsg;
//    }
//
//    public String formatdecrypt(String old_text)
//    {
//        int i = 0;
//        int len = 0;
//        String text = new String();
//        len = old_text.length();
//        for (i = 0; i < len-2;  i++)
//        {
//            if (old_text.charAt(i)==old_text.charAt(i+2))
//            {
//                System.out.println("First char : "+old_text.charAt(i));
//                System.out.println("Second char : "+old_text.charAt(i+2));
//                text = text+(old_text.substring(i, i+1) + old_text.substring(i + 1));
//            }
//            System.out.println("text: "+text);
//        }
//        return text;
//    }
}