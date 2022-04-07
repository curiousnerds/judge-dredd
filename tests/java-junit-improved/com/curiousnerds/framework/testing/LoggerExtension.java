package com.curiousnerds.framework.testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoggerExtension implements TestWatcher, AfterAllCallback {

    List<Wrap> existing = new ArrayList<>();

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        ExtensionContext.Store store = getStore(extensionContext);
       // System.out.println(store);
        ObjectMapper Obj = new ObjectMapper();
        String s = Obj.writerWithDefaultPrettyPrinter().writeValueAsString(existing);
        System.out.println(s);
    }

    class Wrap <T>{
        public String testCase; // name of the test case,
        public T expected;
        public T actual;
        public boolean status;
        public String failReason;


        public Wrap(String testCase, T expected, T actual, boolean status, String failReason) {
            this.testCase = testCase;
            this.expected = expected;
            this.actual = actual;
            this.status = status;
            this.failReason = failReason;
        }


        @Override
        public String toString() {
            return "Wrap{" +
                    "testCase='"+ testCase +'\''+
                    ",expected='" + expected + '\'' +
                    ", actual='" + actual + '\'' +
                    ", status=" + status + '\'' +
                    ",failedReason='" + failReason+ '\'' +
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
        CuriousTestable o1 = (CuriousTestable) extensionContext.getTestInstance().get();
        ExtensionContext.Store store = getStore(extensionContext);
        if (store != null) {
            //       ArrayList<Wrap> existing = (ArrayList<Wrap>) store.get("STORE");
        /*    if (existing == null) {
                existing= new ArrayList<>();
                existing.add(new Wrap(o1.expected.toString(), o1.actual.toString(), true));
            } else {*/
            existing.add(new Wrap(extensionContext.getDisplayName(),o1.expected.toString(), o1.actual.toString(), true,""));
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
        CuriousTestable o1 = (CuriousTestable) extensionContext.getTestInstance().get();
        ExtensionContext.Store store = getStore(extensionContext);
       /* if (store != null) {
            ArrayList<Wrap> existing = (ArrayList<Wrap>) store.get("STORE");
            if (existing == null) {
                existing= new ArrayList<>();
                existing.add(new Wrap(o1.expected.toString(), o1.actual.toString(), true));
            } else {
           */
            if(o1!=null ){
                try {
                    existing.add(new Wrap(extensionContext.getDisplayName(), o1.expected.toString(), o1.actual.toString(), false, throwable.getMessage()));
                }catch (Exception e){
                    existing.add(new Wrap(extensionContext.getDisplayName(), "Error", "Error", false, throwable.getMessage()));
                }
            }else{
               //TODO:  existing.add(new Wrap(extensionContext.getDisplayName(),"N/A", "N/A", false,"AUTHOR: Please make sure you provide the extected and actual in the @Test method"));
            }

          /*  }
            store.put("STORE", existing);*/
       // System.out.println(existing);
        //  }
    }
}
