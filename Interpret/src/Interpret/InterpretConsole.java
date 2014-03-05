package Interpret;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class InterpretConsole extends OutputStream {

    private JTextArea _area;
    private ByteArrayOutputStream _buf;

    public InterpretConsole(JTextArea area) {
        _area = area;
        _buf = new ByteArrayOutputStream();
    }
    
    @Override
    public void write(int b) throws IOException {
        _buf.write(b);
    }
    
    @Override
    public void flush() throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                _area.append(_buf.toString());
                _buf.reset();
            }
        });
    }
}