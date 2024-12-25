package Testing;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.List;

public class TestMockito {

    @Test
    public void testMockito() {
        List mocked = mock(List.class);
    }
}
