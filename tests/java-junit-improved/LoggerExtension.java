import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.*;

import java.util.ArrayList;
import java.util.Optional;

public class LoggerExtension implements TestWatcher, AfterAllCallback {

    ArrayList<Wrap> existing = new ArrayList<>();

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        ExtensionContext.Store store = getStore(extensionContext);
       // System.out.println(store);
        ObjectMapper Obj = new ObjectMapper();
        String s = Obj.writeValueAsString(existing);
        System.out.println(s);
    }

    class Wrap {
        public String expected;
        public String actual;
        public boolean status;

        public Wrap(String expected, String actual, boolean status) {
            this.expected = expected;
            this.actual = actual;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Wrap{" +
                    "expected='" + expected + '\'' +
                    ", actual='" + actual + '\'' +
                    ", status=" + status +
                    '}';
        }
    }

    private ExtensionContext.Store getStore(ExtensionContext context) {
        ExtensionContext.Namespace namespace = ExtensionContext.Namespace.create(getClass());
       //  System.out.println(namespace);

        return context.getStore(namespace);
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {

    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        SolutionTest o1 = (SolutionTest) extensionContext.getTestInstance().get();
        ExtensionContext.Store store = getStore(extensionContext);
        if (store != null) {
            //       ArrayList<Wrap> existing = (ArrayList<Wrap>) store.get("STORE");
        /*    if (existing == null) {
                existing= new ArrayList<>();
                existing.add(new Wrap(o1.expected.toString(), o1.actual.toString(), true));
            } else {*/
            existing.add(new Wrap(o1.expected.toString(), o1.actual.toString(), true));
            //   }
            //    store.put("STORE", existing);
         //   System.out.println(existing);
        }
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {

    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        SolutionTest o1 = (SolutionTest) extensionContext.getTestInstance().get();
        ExtensionContext.Store store = getStore(extensionContext);
       /* if (store != null) {
            ArrayList<Wrap> existing = (ArrayList<Wrap>) store.get("STORE");
            if (existing == null) {
                existing= new ArrayList<>();
                existing.add(new Wrap(o1.expected.toString(), o1.actual.toString(), true));
            } else {
           */
        existing.add(new Wrap(o1.expected.toString(), o1.actual.toString(), false));
          /*  }
            store.put("STORE", existing);*/
       // System.out.println(existing);
        //  }
    }
}
