package Interpret;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class InterpretConsole extends OutputStream {

    private TextArea _area;
    private ByteArrayOutputStream _buf;

    public InterpretConsole(TextArea area) {
        _area = area;
        _buf = new ByteArrayOutputStream();
    }

    @Override
    public void write(int b) throws IOException {
        _buf.write(b);
    }

    @Override
    public void flush() throws IOException {

    	 EventQueue.invokeLater(new Runnable() {
            public void run() {
                _area.append(_buf.toString());
                _buf.reset();
            }
        });
    }
}