package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class dataStream {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream input = new FileInputStream("/Users/steve/Documents/javafx/search_engine_test/src/sample/box.stl");
        FileChannel channel = input.getChannel();
        byte[] buffer = new byte[256 * 1024];
        ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);

        try {
            for (int length = 0; (length = channel.read(byteBuffer)) != -1;) {
                System.out.write(buffer, 0, length);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}//class
