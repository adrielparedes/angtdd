package com.rh.tickets.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.rh.tickets.model.Avion;

@RunWith(Arquillian.class)
public class ArquillianTest {

	@Deployment
	public JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "arquillian-test")
				.addPackages(true, "com.rh.tickets.model");
	}

	@Test
	public void test() {
		Avion avion = new Avion();
	}

}
