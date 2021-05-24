package top.monoliths;

import static org.junit.Assert.assertTrue;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import top.monoliths.kernel.TextInterpreter;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private static final Log log = LogFactory.getLog(AppTest.class);
    /**
     * test word file to json
     */
    @Test
    public void testTextTransfrom()
    {
        try {
            TextInterpreter tx = new TextInterpreter("C:\\Users\\asu\\Downloads\\冰川三明治.台词版-release.docx");
            tx.toJson("jsonOutputFile.json");
            assertTrue( true );

        } catch (FileNotFoundException e) {
            log.error("word document file not find", e);
            assertTrue(false);
        } catch (EOFException e) {
            log.error("word document unknown error", e);
            assertTrue(false);
        } catch (NullPointerException e) {
            log.error("not data error", e);
            assertTrue(false);
        } catch (IOException e) {
            log.error("IO type:", e);    
            assertTrue(false);
        } catch (Exception e) {
            log.error("unknown of: ", e);
            assertTrue(false);
        }
        
    }
}
