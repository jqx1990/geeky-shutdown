import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

/**
 * @author John Hite
 * This code is created by John Hite. Lee (I) brought this code from Mr. Hite's page (http://goo.gl/ZgG6W).
 * Mr. Hite did not mention any license related requirement or his contact information. I do feel that he may
 * be okay with me using his code in a open source non commercial project. I contacted him by leaving a comment
 * on his blog.
 */
public class TextAreaOutputStream extends OutputStream
{
    private static int BUFFER_SIZE = 8192;
    private JTextArea target;
    private byte[] buffer = new byte[BUFFER_SIZE];
    private int pos = 0;

    public TextAreaOutputStream(JTextArea target)
    {
        this.target = target;
    }

    @Override
    public void write(int b) throws IOException
    {
        buffer[pos++] = (byte)b;
        //Append to the TextArea when the buffer is full
        if (pos == BUFFER_SIZE) 
        {
            flush();
        }
    }

    @Override
    public void flush() throws IOException
    {
        byte[] flush = null;
        if (pos != BUFFER_SIZE) 
        {
            flush = new byte[pos];
            System.arraycopy(buffer, 0, flush, 0, pos);
        }
        else 
        {
            flush = buffer;
        }

        target.append(new String(flush));
        pos = 0;
    }
}