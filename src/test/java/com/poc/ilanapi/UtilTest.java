package com.poc.ilanapi;

import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.ilanapi.util.Util;

/**
 * @author fuatozergil
 *
 */
@SpringBootTest
class UtilTest {

	/**
	 * @throws TestAbortedException
	 * @throws IOException
	 */
	@Test
	void testDetectNotInBadWords() throws TestAbortedException, IOException {
		
		assumeFalse(Util.detectNotInBadWords("caihogel"));
	}

}
