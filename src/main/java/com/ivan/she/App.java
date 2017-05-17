package com.ivan.she;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	new Fiber<Doit>() {
    		  /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
    		  protected Doit run() throws SuspendExecution, InterruptedException {
				System.out.println("111");
				return null;
    		        // your code
    		    }
    		}.start();

    }
}

class Doit{
	
}
