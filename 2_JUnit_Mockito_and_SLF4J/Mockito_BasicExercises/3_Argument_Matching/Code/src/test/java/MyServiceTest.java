import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.*;

class MyServiceTest {

    @Test
    public void testArgumentMatching(){
        ExternalAPI mockAPI = mock(ExternalAPI.class);

        MyService service = new MyService(mockAPI);

        service.setData("jashwanth", 20);

        verify(mockAPI).send("jashwanth", 20);
        verify(mockAPI).send(eq("jashwanth"), anyInt());
        verify(mockAPI).send(anyString(), anyInt());
        verify(mockAPI).send(startsWith("jashwanth"), anyInt());
        verify(mockAPI).send(endsWith("anth"), gt(15));

        System.out.println();
    }
}