public class HillCipher {
    public int msg_row;
    public int msg_column;
    public int key_row;
    public int key_column;
    public String Encrypt(String msg,int size,int[][] key){
        String ciphertext="";
        key_row=size;
        key_column=size;
        int[][] matrix = plaintextmatrix(msg,size);
        int[][] dematrix = matrixmultiple(matrix,key);

        for(int i=0;i<msg_row;i++){
            for(int j=0;j<msg_column;j++){

                dematrix[i][j]=dematrix[i][j]%26;
                ciphertext=ciphertext+ (char) (dematrix[i][j]+65);
            }
        }
        return ciphertext;
    }

    private int[][] plaintextmatrix(String m, int size) {
        String msg=m.toUpperCase();
        msg_row=size;
        msg_column=msg.length()/size;
        int[][] matrix=new int [msg_row][msg_column];
        int counter =0;
        for(int j=0;j<msg_column;j++){
            for(int i=0;i<msg_row;i++){
                matrix[i][j]=msg.charAt(counter)-65;
                counter++;
            }
        }
        return matrix;
    }

    private  int[][] matrixmultiple(int[][] matrix, int[][] key) {

        int dematrix[][]= new int[key_row][msg_column];
        for(int i=0;i<msg_row;i++){
            for(int j=0;j<msg_column;j++){
                dematrix[i][j]=0;
                for(int k=0;k<msg_row;k++){
                    dematrix[i][j] = dematrix[i][j]  + (key[i][k]*matrix[k][j]);
                }
            }
        }
        return dematrix;
    }
}