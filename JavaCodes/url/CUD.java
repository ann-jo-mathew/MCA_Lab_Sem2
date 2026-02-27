import java.net.*;
import java.io.*;
import java.util.Date;
class CDownload extends Thread{
    public void run(){
        try{
            URL u=new URL("https://beej.us/guide/bgnet/pdf/bgnet_a4_c_1.pdf");
            URLConnection uc=u.openConnection();
            int len=uc.getContentLength();
            FileOutputStream fout=new FileOutputStream("a.pdf");
            if(len>0){
                InputStream input=uc.getInputStream();
                int c,i=0;
                while(((c=input.read())!=-1)&&(i<len)){
                    fout.write((char)c);
                    i++;
                }
                input.close();
            }
            else{
                System.out.println("Not available");
            }   
        }
        
        catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
class CUD{
    public static void main(String args[]){
        CDownload cd=new CDownload();
        cd.start();
    }
}