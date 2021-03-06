package cc.blynk.core.http;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 05.01.16.
 */
public class UriTemplateTest {

    @Test
    public void testCorrectMatch() {
        UriTemplate template1 = new UriTemplate("http://example.com/admin/users/{name}");
        UriTemplate template2 = new UriTemplate("http://example.com/admin/users/changePass/{name}");

        assertFalse(template1.matcher("http://example.com/admin/users/changePass/dmitriy@blynk.cc").matches());
        assertTrue(template1.matcher("http://example.com/admin/users/dmitriy@blynk.cc").matches());

        assertTrue(template2.matcher("http://example.com/admin/users/changePass/dmitriy@blynk.cc").matches());
        assertFalse(template2.matcher("http://example.com/admin/users/dmitriy@blynk.cc").matches());
    }

}
