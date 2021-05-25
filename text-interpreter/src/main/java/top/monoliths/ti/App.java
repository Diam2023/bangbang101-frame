package top.monoliths.ti;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import top.monoliths.ti.kernel.TextInterpreter;
public class App {
    private static final Log log = LogFactory.getLog(App.class);
    public static void main(String[] args) {
        try {
            TextInterpreter tx = new TextInterpreter("C:\\Users\\asu\\Downloads\\冰川三明治-gal部分.docx");
            tx.toJson("jsonOutputFile.json");

        } catch (FileNotFoundException e) {
            log.error("word document file not find", e);
        } catch (EOFException e) {
            log.error("word document unknown error", e);
        } catch (NullPointerException e) {
            log.error("not data error", e);
        } catch (IOException e) {
            log.error("IO type:", e);    
        } catch (Exception e) {
            log.error("unknown of: ", e);
        }
    }
}
