package org.brownsocks.payments;

import org.brownsocks.payments.gateways.PaymentListenerSupportTests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTests {
	
    public static Test suite() {

        TestSuite suite = new TestSuite();
        
        suite.addTest( PaymentListenerSupportTests.suite() );
        
        return suite;
    }
    
    public static void main(String args[]) {
        TestRunner.run( suite() );
    }
}
