import java.net.*;
import java.io.*;
class FileDownloadClient {
    public static void main(String args[]) throws Exception {
        Socket ss = new Socket("localhost", 1234);
        DataInputStream sin = new DataInputStream(ss.getInputStream());
        DataOutputStream sout = new DataOutputStream(ss.getOutputStream());
        DataInputStream kin = new DataInputStream(System.in);
        System.out.print("Enter file name to download: ");
        String fn = kin.readLine();
        sout.writeUTF(fn);
        FileOutputStream fout = new FileOutputStream(fn);   // saved in Client folder
        int ch;
        while ((ch = sin.read()) != -1) {
            fout.write(ch);
        }
        fout.close();
        ss.close();
        System.out.println("Downloaded: " + fn);
    }
}