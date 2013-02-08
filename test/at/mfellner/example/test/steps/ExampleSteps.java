// Copyright 2013 Maximilian Fellner
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package at.mfellner.example.test.steps;

import at.mfellner.example.cuke.Example;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ExampleSteps {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream oldOut = System.out;

    @When("^I run the program$")
    public void run_the_program() throws Throwable {
        System.setOut(new PrintStream(outContent));
        Example.main(null);
        System.setOut(oldOut);
    }

    @Then("^I see (.*) in the out stream.$")
    public void see_text_in_out_stream(String expectedText) throws Throwable {
        assertEquals(expectedText, outContent.toString().trim());
    }
}
