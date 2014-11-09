package JPL.ch20.ex20_07;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Attr {

        private final String name;
        private Object value = null;

        public Attr(String name) {
            this.name = name;
        }

        public Attr(String name, Object value) {
                this.name = name;
                this.value = value;
        }

        public Attr(DataInputStream in) throws IOException, ClassNotFoundException{
        	this.name = in.readUTF();

        	byte[] b = new byte[in.readInt()];
        	in.read(b);
        	ByteArrayInputStream bais = new ByteArrayInputStream(b);
        	ObjectInputStream ois = new ObjectInputStream(bais);
        	this.value = ois.readObject();
        }

        public String getName() {
                return name;
        }

        public Object getValue() {
                return value;
        }

        public Object setValue (Object newValue) {
                Object oldValue = value;
                value = newValue;
                return oldValue;
        }

        public String toString() {
                return name + "='" + value + "'";
        }

        public void writeStream(DataOutputStream out) throws IOException {
    			out.writeUTF(name);

    			ByteArrayOutputStream bout= new ByteArrayOutputStream();
    			ObjectOutputStream oout = new ObjectOutputStream(bout);
    			oout.writeObject(value);

    			oout.close();
    			bout.close();
    			out.writeInt(bout.toByteArray().length);
    			out.write(bout.toByteArray());

    	}
}