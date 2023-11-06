public class DoubleTransposition {
    public char[][] makeArray(String msg,int row, int column){
        int k=0;
        msg=msg.toLowerCase();
        int n= msg.length();
        while (n%column !=0){
            msg +="z";
            n++;
        }

        char[] msg1 = new char[n];
        msg1= msg.toCharArray();
        char[][] temp = new char[row][column];

        for(int i=0;i< row;i++){
            for(int j=0;j< column;j++){
                temp[i][j]=msg1[k];
                k++;
            }
        }

        return temp;
    }

    public String Encrypt(char[][] temp , int row,int column){
        char[][] temp1 = new char[row][column];
        char[][] temp2 = new char[row][column];

        int[] k1={2,1,0};
        int[] k2 ={3,1,0,2};
//row transposition
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                temp1[j][i] = temp[k1[j]][i];
            }
        }
        //column transposition
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                temp2[j][i] = temp1[j][k2[i]];
            }
        }

        String ciphertext="";

        for(int i=0;i<row;i++){
            for(int j=0;j< column;j++){
                ciphertext += temp2[i][j];
            }
        }
        return ciphertext;
        //System.out.println("After Encryption : "+ciphertext);
    }

    public String decrypt(char[][] temp , int row,int column){
        char[][] temp1 = new char[row][column];
        char[][] temp2 = new char[row][column];

        int[] k1={2,1,0};
        int[] k2 ={3,1,0,2};

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                temp1[j][k2[i]] = temp[j][i];
            }
        }
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                temp2[k1[j]][i] = temp1[j][i];
            }
        }

        String plaintext="";

        for(int i=0;i<row;i++){
            for(int j=0;j< column;j++){
                plaintext += temp2[i][j];
            }
        }
        return plaintext;
        //System.out.println("After Encryption : "+plaintext);
    }
}
