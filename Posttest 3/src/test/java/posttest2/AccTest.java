package posttest2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AccTest {

    @Test
    public void testGetUsername() {
        Acc acc = new Acc("testUser", "testPassword");
        assertEquals("testUser", acc.getUsername());
    }

    @Test
    public void testGetPass() {
        Acc acc = new Acc("testUser", "testPassword");
        assertEquals("testPassword", acc.getPass());
    }

    @Test
    public void testSetUsername() {
        Acc acc = new Acc("testUser", "testPassword");
        acc.setUsername("newUser");
        assertEquals("newUser", acc.getUsername());
    }

    @Test
    public void testSetPass() {
        Acc acc = new Acc("testUser", "testPassword");
        acc.setPass("newPassword");
        assertEquals("newPassword", acc.getPass());
    }
}
