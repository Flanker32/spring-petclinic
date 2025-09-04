/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test to verify Java version is 21 or higher
 *
 * @author Copilot
 */
class JavaVersionTest {

	@Test
	void shouldRunOnJava21OrHigher() {
		String javaVersion = System.getProperty("java.version");
		String javaVendor = System.getProperty("java.vendor");

		System.out.println("Java Version: " + javaVersion);
		System.out.println("Java Vendor: " + javaVendor);

		// Extract major version number
		String majorVersion = extractMajorVersion(javaVersion);
		int majorVersionInt = Integer.parseInt(majorVersion);

		assertThat(majorVersionInt).isGreaterThanOrEqualTo(21);
	}

	private String extractMajorVersion(String version) {
		if (version.startsWith("1.")) {
			// Java 8 format: 1.8.0_XXX
			return version.split("\\.")[1];
		}
		else {
			// Java 9+ format: 21.0.1, 17.0.2, etc.
			return version.split("\\.")[0];
		}
	}

}