package io.github.mrspock182.lambda;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class TestSetup {

	@BeforeAll
	public static void setUp() {
		FixtureFactoryLoader.loadTemplates("io.github.mrspock182");
	}

	@Before
	public abstract void init();
}
