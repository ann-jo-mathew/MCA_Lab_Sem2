import java.net.*;
import java.io.*;
class CUWeb{
    public static void main(String args[]) throws Exception{
        URL url=new URL("https://www.google.com");
        BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer=new BufferedWriter(new FileWriter("index.html"));
        String line;
        while((line=reader.readLine())!=null){
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}