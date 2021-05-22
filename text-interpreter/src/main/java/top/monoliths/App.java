package top.monoliths;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import top.monoliths.kernel.TextInterpreter;

public class App {

    public static Log log = LogFactory.getLog(App.class);

    public static void main(String[] args) {
        try {
            TextInterpreter tx = new TextInterpreter("C:\\Users\\asu\\Downloads\\冰川三明治.台词版-release.docx");
            tx.toJson("jsonOutputFile.json");
        } catch (FileNotFoundException e) {
            log.error("err: ", e);
        } catch (EOFException e) {
            log.error("err: ", e);
        } catch (NullPointerException e) {
            log.error("err: ", e);
        } catch (IOException e) {
            log.error("err: ", e);
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }
}
