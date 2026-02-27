import java.net.*;
import java.io.*;
class FileDownloadServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Download Server Started on 1234...");
        Socket cs = ss.accept();
        DataInputStream sin = new DataInputStream(cs.getInputStream());
        DataOutputStream sout = new DataOutputStream(cs.getOutputStream());
        String fn = sin.readUTF();              // client asks file name
        FileInputStream fin = new FileInputStream(fn);   // file must be in Server folder
        int ch;
        while ((ch = fin.read()) != -1) {
            sout.write(ch);                     // send bytes
        }
        fin.close();
        cs.shutdownOutput();                    // tells client "finished"
        cs.close();
        ss.close();
        System.out.println("Sent: " + fn);
    }
}