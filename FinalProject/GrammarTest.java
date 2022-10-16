package pp.FinalProject;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;
import org.stringtemplate.v4.ST;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GrammarTest {

    // get current working directory + path from project
    String root = System.getProperty("user.dir") + "\\pp\\FinalProject\\Test-Files\\";

    /**
     * Contextual errors tests
     */
    // ------------------- Correct Test --------------------------------------------
    @Test
    public void CCtest_1(){
        GrammarChecker grammar = new GrammarChecker();
        Set<String> mistake = new HashSet<>();
        mistake = grammar.check(root + "Context_errors\\" + "Correct_programs\\" +"contextual_test1.txt"); //change root path
        System.out.println(mistake);
        assertEquals(mistake.size(),0);
    }

    @Test
    public void CCtest_2(){
        GrammarChecker grammar = new GrammarChecker();
        Set<String> mistake = new HashSet<>();
        mistake = grammar.check(root + "Context_errors\\" + "Correct_programs\\" +"contextual_test2.txt");
        System.out.println(mistake);
        assertEquals(mistake.size(),0);
    }

    @Test
    public void CCtest_3() {
        GrammarChecker grammar =new GrammarChecker();
        Set<String> mistake= new HashSet<>();
        mistake = grammar.check(root + "Context_errors\\" + "Correct_programs\\" +"contextual_test3.txt");
        System.out.println(mistake);
        assertEquals(mistake.size(),0);
    }

    @Test
    public void CCtest_4() {
        GrammarChecker grammar =new GrammarChecker();
        Set<String> mistake= new HashSet<>();
        mistake = grammar.check(root + "Context_errors\\" + "Correct_programs\\" +"contextual_test4.txt");
        System.out.println(mistake);
        assertEquals(mistake.size(),0);
    }

    // ------------------- Incorrect Test --------------------------------------------

    @Test
    public void CWtest_1(){
        GrammarChecker grammar = new GrammarChecker();
        Set<String> mistake = new HashSet<>();
        try {
            mistake = grammar.check(root + "Context_errors\\" + "Incorrect_programs\\" +"contextual_test1.txt"); //change root path
        } catch (Exception e){
            // Expected behaviour
        }
    }

    @Test
    public void CWtest_2(){
        GrammarChecker grammar = new GrammarChecker();
        Set<String> mistake = new HashSet<>();
        try {
            mistake = grammar.check(root + "Context_errors\\" + "Incorrect_programs\\" +"contextual_test2.txt");
            Assert.fail();
        } catch (Exception e){
            // Expected behaviour
        }
    }

    @Test
    public void CWtest_3() {
        GrammarChecker grammar =new GrammarChecker();
        Set<String> mistake= new HashSet<>();
        try{
            mistake = grammar.check(root + "Context_errors\\" + "Incorrect_programs\\" +"contextual_test3.txt");
        } catch (Exception e){
            // Expected behaviour
        }
    }

    @Test
    public void CWtest_4() {
        GrammarChecker grammar =new GrammarChecker();
        Set<String> mistake= new HashSet<>();
        try {
            mistake = grammar.check(root + "Context_errors\\" + "Incorrect_programs\\" +"contextual_test4.txt");
        } catch (Exception e){
            // Expected behaviour
        }
    }


}