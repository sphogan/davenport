package rocks.davenport.views;

import com.fizzed.rocker.RockerModel;
import com.fizzed.rocker.runtime.ArrayOfByteArraysOutput;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class DavenportMessageBodyWriter implements MessageBodyWriter<RockerModel> {
    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return RockerModel.class.isAssignableFrom(aClass);
    }

    @Override
    public long getSize(RockerModel rockerModel, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(RockerModel rockerModel, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        for (byte[] bytes : rockerModel.render(ArrayOfByteArraysOutput.FACTORY).getArrays()) {
            outputStream.write(bytes);
        }
        outputStream.flush();
    }
}
