package pp.FinalProject;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import pp.FinalProject.exceptions.*;

public class GrammarChecker extends GrammarBaseListener{

    /**
     * @invariant generator
     */
    private GrammarGenerator generator; // delete
    /**
     * @invariant getTable() != null
     */
    private MySymbolTable s = new MySymbolTable();
    /**
     * @invariant mistakes.size() > 0
     */
    private Set<String> mistakes = new HashSet<>();
    // Map < Name, Type > which stores the variables and its type class
    private Map<String, String> dictionary = new HashMap<>();
    private ParseTree tree;

    /**
     * Checks grammar mistakes in a file
     * @requires file != null
     * @ensures Set of mistakes
     * @return Set of mistakes
     */
    public Set<String> check(String file) {
        generator = new GrammarGenerator();
        Lexer lexer = null;
        try {
            lexer = new GrammarLexer(CharStreams.fromFileName(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));
        tree = parser.program();
        new ParseTreeWalker().walk(this, tree);
        if (mistakes.size() == 0){
            //tree.accept(generator);
        }
        return mistakes;
    }

    /**
     * @return this.MySymbolTable
     */
    public MySymbolTable getTable(){
        return this.s;
    }

    public ParseTree getTree() {
        return tree;
    }

    /**
     *Checks whether the given parameter (Data type) is a integer or not
     * @requires x != null type String
     * @ensures true if x is an integer, false otherwise
     */
    public boolean isInteger(String x){
        boolean result = true;
        try{
            Integer.parseInt(x);
        }catch (NumberFormatException ex){
            result = false;
        }
        return result;
    }

    /**
     *Checks whether the given parameter (Data Type) is boolean or not
     * @requires x != null type String
     * @ensures true if x is of type boolean, false otherwise
     */
    public boolean isBoolean(String x){
        return !(!x.equals("True") & !x.equals("False"));
    }


    public boolean checkOperator(String operator, String type){
        switch (type){
            case "int":
                return !operator.equals("||") && !operator.equals("&&");
            case "boolean":
                return operator.equals("||") || operator.equals("&&");
            case "string":
                return operator.equals("+");
                // ToDo : Array operations implementation if it has one
            case "array":
                return operator.equals("");
            default: return false;
        }
    }

    /**
     * Enters program
     * @param ctx!= null
     * @ensures GrammarParser.ProgramContext is initialized
     */
    @Override
    public void enterProgram(GrammarParser.ProgramContext ctx) {
        s.openScope();
    }

    /**
     * Exit program
     * @param ctx != null
     * @ensures GrammarParser.ProgramContext is closed
     */
    @Override
    public void exitProgram(GrammarParser.ProgramContext ctx) {
        s.closeScope();
    }

    /**
     * Initialized classes
     * @param ctx != null
     * @ensures class is opened
     */
    @Override
    public void enterClasses(GrammarParser.ClassesContext ctx) throws LineException {
        String typeClass = ctx.type().getText();
        String nameClass = ctx.identifier().getText();

        if(Character.isUpperCase(typeClass.charAt(0))){
            mistakes.add("Mistake. Line :" + typeClass + " should be lower case.");
            throw new LineException("Mistake. Line :" + typeClass + " should be lower case.");
        }
        if (!Character.isUpperCase(nameClass.charAt(0))){
            mistakes.add("Mistake. Line :" + nameClass + " should be upper case.");
            throw  new LineException("Mistake. Line :" + nameClass + " should be upper case.");
        }
        s.openScope();
    }

    /**
     * Close class
     * @param ctx!= null && ctx instanceof ClassesContext
     * @ensures class is closed
     */
    @Override
    public void exitClasses(GrammarParser.ClassesContext ctx) {
        s.closeScope();
        dictionary = new HashMap<>();
    }

    /**
     * Open declarations, check types
     * @param ctx!= null && ctx instanceof DeclarationContext
     */
    @Override
    public void enterDeclaration(GrammarParser.DeclarationContext ctx) throws LineException, TypeClassException {
        String nameClass = ctx.identifier().getText();
        String result_value = ctx.expression().getText();
        String typeClass = null;
        if (ctx.type() != null ) {
            typeClass = ctx.type().getText();
        } else if(dictionary.containsKey(nameClass)) {
            typeClass = dictionary.get(nameClass);
        } else {
            mistakes.add("Mistake. Line : Variable " + nameClass +
                    " is not declared.");
            throw new LineException("Mistake. Line : Variable " + nameClass +
                    " is not declared.");
        }

        if (typeClass == null){
            mistakes.add("Mistake. Line : Variable " + nameClass +
                    " is not declared.");
            throw new LineException("Mistake. Line : Variable " + nameClass +
                    " is not declared.");

        }

        // Look into variable with type
        if (typeClass != null && result_value != null){

            // Check whether the declaration is an array
            if (result_value.charAt(0) == '[') {

                // Remove '[', ',' and ']',  and put them into the array
                String temp = result_value.substring(1, result_value.length() - 1);
                String[] variables = temp.split(",");
                Boolean containsDicKey = false;

                for (int j = 0; j < variables.length; j++) {

                    //System.out.println(dictionary.containsKey(variables[j]));
                    if (dictionary.containsKey(variables[j])) {
                        containsDicKey = true;
                        //System.out.println("it is entering the condition");
                    }
                }
                //System.out.println(containsDicKey);

                if (containsDicKey == true) {

                    //handle every case that a variable can be
                    String vartype = dictionary.get(variables[0]);

                    // Check if Boolean
                    if (isBoolean(variables[0])
                            || (dictionary.get(variables[0]) != null && (dictionary.get(variables[0]).equals("boolean"))) ) {
                        for (int i = 0; i < variables.length; i++) {
                            if (!isBoolean(variables[i])
                                    || (dictionary.get(variables[i]) != null && !(dictionary.get(variables[i]).equals("boolean"))) ) {
                                mistakes.add("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be a boolean");
                                throw new LineException("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be a boolean");
                            }
                        }
                    }

                    // Check if Integer
                    if (isInteger(variables[0])
                            || (dictionary.get(variables[0]) != null && dictionary.get(variables[0]).equals("int") ) ) {
                        //System.out.println("entering int condition");
                        for (int i = 0; i < variables.length; i++) {
                                //System.out.println(variables[i]);
                            if (!isInteger(variables[i])
                                    || (dictionary.get(variables[i]) != null && !(dictionary.get(variables[i]).equals("int"))) ) {
                                mistakes.add("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be an integer");
                                throw new LineException("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be an integer");
                            }
                        }
                    }

                    // check if Strings
                    if ((variables[0].charAt(0) == '"')
                            || (dictionary.get(variables[0]) != null && dictionary.get(variables[0]).equals("string")) ){
                        for (int i = 0; i < variables.length; i++) {
                            if ((variables[i].charAt(0) != '"')
                                    || (dictionary.get(variables[i]) != null && !dictionary.get(variables[i]).equals("string"))) {
                                mistakes.add("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be a string");
                                throw new LineException("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be a string");
                            }
                        }
                    }
                } else {
                    if (isBoolean(variables[0])) {
                        for (int i = 0; i < variables.length; i++) {
                            if (!isBoolean(variables[i])) {
                                mistakes.add("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be a boolean");
                                throw new LineException("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be a boolean");
                            }
                        }
                    } else if (isInteger(variables[0])) {
                        for (int i = 0; i < variables.length; i++) {
                            if (!isInteger(variables[i])) {
                                mistakes.add("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be an integer");
                                throw new LineException("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be an integer");
                            }
                        }
                    } else if (variables[0].charAt(0) == '"') {
                        for (int i = 0; i < variables.length; i++) {
                            if (variables[i].charAt(0) != '"') {
                                mistakes.add("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be an array");
                                throw new LineException("Mistake. Line : " + ctx.getStart().getLine() + " Variable should be an array");
                            }
                        }
                    }
                }


            } else {

                String[] variables = new String[ctx.expression().variable().size()];
                for (int i = 0; i < variables.length; i++) {
                    variables[i] = ctx.expression().variable(i).getText();
                }

                // Check whether there are more variables in a declaration statement
                if (variables.length > 1) {
                    int counter = 0;
                    int ind = 0;
                    for (String c : variables) {
                        String operator = "";
                        if (ind < (variables.length -1)) {
                            operator = ctx.expression().OPERATORS().get(ind).getText();
                        }
                        // Check if the terms are not variables that were declared before
                        if(isBoolean(c) ||  isInteger(c) || ctx.expression().variable(ind).QUOTES().size() != 0){
                            if (!operator.equals("") && !checkOperator(operator, typeClass)) {
                                mistakes.add("Mistake. Line : "+ ctx.getStart().getLine() + ", " + c +
                                        ". You cannot perform that operation on a " + typeClass + ".");
                                throw new TypeClassException("Mistake. Line : "+ ctx.getStart().getLine() + ", " + c +
                                        ". You cannot perform that operation on a " + typeClass + ".");
                            }
                        } else {
                            if (dictionary.containsKey(c) && s.contains2(c)) {
                                if (!typeClass.equals(dictionary.get(c))) {
                                    mistakes.add("Mistake. Line : "+ ctx.getStart().getLine() + ", " + c +
                                            ". You cannot perform that operation on a " + typeClass + ".");
                                    counter++;
                                    throw new TypeClassException("Mistake. Line : "+ ctx.getStart().getLine() + ", " + c +
                                            ". You cannot perform that operation on a " + typeClass + ".");

                                } else {
                                    if (!operator.equals("") && !checkOperator(operator, dictionary.get(c))) {
                                        mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + ", " + c +
                                                ". You cannot perform that operation on a " + typeClass + ".");
                                        throw new TypeClassException("Mistake. Line :" + ctx.getStart().getLine() + ", " + c +
                                                ". You cannot perform that operation on a " + typeClass + ".");
                                    }
                                }
                            } else {
                                mistakes.add("Mistake. Line " + ctx.getStart().getLine() + ", Variable " + c +
                                        " is not declared.");
                                throw new LineException("Mistake. Line " + ctx.getStart().getLine() + ", Variable " + c +
                                        " is not declared.");
                            }
                        }
                        ind++;
                    }
                    if (counter == 0) {
                        dictionary.put(nameClass, typeClass);
                        s.add(nameClass);
                    }
                } else {

                    if (dictionary.containsKey(result_value)) {
                        if (!typeClass.equals(dictionary.get(result_value))) {
                            mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + "," + result_value +
                                    ". The result should be " + typeClass + ".");
                            throw new LineException("Mistake. Line :" + ctx.getStart().getLine() + "," + result_value +
                                    ". The result should be " + typeClass + ".");

                        } else if (!s.contains2(result_value)) {
                            mistakes.add("Mistake. Line : " + ctx.getStart().getLine() + ",Variable " + result_value +
                                    " is not declared.");
                            throw new LineException("Mistake. Line : " + ctx.getStart().getLine() + ",Variable " + result_value +
                                    " is not declared.");
                        } else {
                            dictionary.put(nameClass, typeClass);
                            s.add(nameClass);
                        }
                    } else if (typeClass.equals("boolean")) {
                        if (isBoolean(result_value)) {
                            dictionary.put(nameClass, typeClass);
                            s.add(nameClass);
                        } else {
                            mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + "," + result_value +
                                    ". The result should be either True or False.");
                            throw new TypeClassException("Mistake. Line :" + ctx.getStart().getLine() + "," + result_value +
                                    ". The result should be either True or False.");
                        }

                    } else if (typeClass.equals("int")) {
                        if (isInteger(result_value)) {
                            dictionary.put(nameClass, typeClass);
                            s.add(nameClass);
                        } else {
                            mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + "," + result_value +
                                    ". The result should be an integer.");
                            throw new TypeClassException("Mistake. Line :" + ctx.getStart().getLine() + "," + result_value +
                                    ". The result should be an integer.");
                        }
                    }
                    else if (typeClass.equals("string")) {
                        if (ctx.expression().variable(0).QUOTES().size() != 0) { // isString()
                            dictionary.put(nameClass, typeClass);
                            s.add(nameClass);
                        } else {
                            mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + "," + result_value +
                                    ". The result should be an string.");
                            throw new TypeClassException("Mistake. Line :" + ctx.getStart().getLine() + "," + result_value +
                                    ". The result should be an string.");
                        }
                    }

                    else {
                        mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + ",Variable " + result_value +
                                " is not declared.");
                        throw new LineException("Mistake. Line :" + ctx.getStart().getLine() + ",Variable " + result_value +
                                " is not declared.");
                    }
                }
            }
        }

    }

    /**
     *Inserts arguments
     * @param ctx!= null && ctx instanceof ArgumentsContext
     */
    @Override
    public void enterArguments(GrammarParser.ArgumentsContext ctx) {
        String[] identifiers = new String[ctx.identifier().size()];
        for (int i = 0 ; i < identifiers.length ; i++){
            String varName = ctx.identifier(i).getText();
            identifiers[i] = varName;
            s.add(varName);
            dictionary.put(varName, ctx.type(i).getText());
        }
    }

    /**
     * Insert condition to a ConditionText
     * @requires ctx!= null && ctx instanceof {@link GrammarParser.ConditionContext}
     */
    @Override
    public void enterCondition(GrammarParser.ConditionContext ctx) throws VariableException, LineException {
        //Map<String, String> variables1 = new HashMap<>();  for storing multiple variables in nested comparison
        String[] varTypes = new String[ctx.variable().size()];

        if (ctx.multiple_conditions() == null) {

            if (ctx.COMPARATIVES() == null && ctx.identifier() != null) {
                String b1 = ctx.identifier().getText();
                if (dictionary.containsKey(b1) && dictionary.get(b1).equals("boolean")) {
                }
                else {
                    mistakes.add("Mistake. Line" + ctx.getStart().getLine() + ", Variable " + b1 +
                            " has not been declared or is not a boolean");
                    throw new VariableException("Mistake. Line" + ctx.getStart().getLine() + ", Variable " + b1 +
                            " has not been declared or is not a boolean");
                }
            }

            // Case for a single condition
            for (int i = 0; i < varTypes.length; i++) {
                String temp = ctx.variable(i).getText();
                // Use of variables that have already been declared
                if (dictionary.containsKey(temp)) {
                    varTypes[i] = dictionary.get(temp);

                    if (dictionary.get(temp).equals("boolean")) {
                            if (ctx.COMPARATIVES().getText().equals('>') || ctx.COMPARATIVES().getText().equals('<')
                                    || ctx.COMPARATIVES().getText().equals(">=")
                                    || ctx.COMPARATIVES().getText().equals("<=")) {
                                mistakes.add("Mistake. Line" + ctx.getStart().getLine() + ", Variable " + temp +
                                        " is a boolean. That operation cannot be performed");
                                throw new VariableException("Mistake. Line" + ctx.getStart().getLine() + ", Variable " + temp +
                                        " is a boolean. That operation cannot be performed");
                            }
                    }
                    if (dictionary.get(temp).equals("int")) {
                        if (ctx.COMPARATIVES().getText().equals("||")
                                || ctx.COMPARATIVES().getText().equals("&&")) {
                            mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + ", Variable " + temp +
                                    " is a boolean. That operation cannot be performed");
                            throw new VariableException("Mistake. Line :" + ctx.getStart().getLine() + ", Variable " + temp +
                                    " is a boolean. That operation cannot be performed");
                        }
                    }
                    // Use of Integers
                } else if (isInteger(temp)) {
                    varTypes[i] = "int";
                    if (ctx.COMPARATIVES().getText().equals("||")
                            || ctx.COMPARATIVES().getText().equals("&&")) {
                        mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + ", Variable " + temp +
                                " is a boolean. That operation cannot be performed");
                        throw new VariableException("Mistake. Line :" + ctx.getStart().getLine() + ", Variable " + temp +
                                " is a boolean. That operation cannot be performed");
                    }
                    // Use of Booleans
                } else if (isBoolean(temp)) {
                    varTypes[i] = "boolean";
                    if (ctx.COMPARATIVES().getText().equals('>') || ctx.COMPARATIVES().getText().equals('<')
                            || ctx.COMPARATIVES().getText().equals(">=")
                            || ctx.COMPARATIVES().getText().equals("<=")) {
                        mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + ", Variable " + temp +
                                " is a boolean. That operation cannot be performed");
                        throw new VariableException("Mistake. Line :" + ctx.getStart().getLine() + ", Variable " + temp +
                                " is a boolean. That operation cannot be performed");
                    }
                    // ToDo Strings
                    // Rest of the cases, add a mistake
                } else {
                    mistakes.add("Mistake. Line : " + ctx.getStart().getLine() + "," + temp + " is not declared.");
                }
            }
            // check if variable1 and variable 2 are of the same type

            if (varTypes.length == 0) {
                // check if is either True or false or a variable of type boolean

            } else if (varTypes.length == 2 && !varTypes[0].equals(varTypes[1])) {
                mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + ", variables are not of the same type");
                throw new LineException("Mistake. Line :" + ctx.getStart().getLine() + ", variables are not of the same type");
            }
        }
    }

    /**
     *
     * @param ctx!= null && ctx instanceof {@link GrammarParser.Multiple_conditionsContext}
     * @ensures
     */
    @Override
    public void enterMultiple_conditions(GrammarParser.Multiple_conditionsContext ctx){

    }


    /**
     *
     * @param ctx!=null && ctx instanceof {@link GrammarParser.If_conditionContext}
     */
    @Override
    public void exitIf_condition(GrammarParser.If_conditionContext ctx) {

    }

    /**
     * Enter identifier from a word and respective token
     * @param ctx!= null && ctx instance of IdentifierContext
     */
    @Override
    public void enterIdentifier(GrammarParser.IdentifierContext ctx) throws LineException {
        String word = ctx.getText();
        Token token = ctx.getStart();
        int counter = 0;
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]_`{|}";
        for (int i=0; i < word.length() ; i++) {
            char character = word.charAt(i);
            if (specialCharactersString.contains(Character.toString(character))) {
                counter++;
            }
            if (word.charAt(0) == ('a')){

            }
        }
        if(counter > 0) {
            int check_word = s.contains(word.substring(0, word.length() - counter));
            if (counter > check_word) {
                mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + "," + token.getLine());
                throw new LineException("Mistake. Line :" + ctx.getStart().getLine() + "," + token.getLine());
            }
        }
    }

    /**
     * Opens Body
     * @param ctx!= null && ctx instanceof BodyContext
     * @ensures  MySymbolTable.openScope()
     */
    @Override
    public void enterBody(GrammarParser.BodyContext ctx) {
        s.openScope();
        // System.out.println(ctx.LOCK() != null);

    }


    /**
     *Enters statements
     * @param ctx!= null && ctx instanceof StatementsContext#
     */
    @Override
    public void enterStatements(GrammarParser.StatementsContext ctx) {
        // Map < Name, Type>
        //private Map<String, String> dictionary_statement = new HashMap<>();

        //s.openScope();
    }

    /**
     *Exits statements
     * @param ctx!= null && ctx instanceof StatementsContext
     */
    @Override
    public void exitStatements(GrammarParser.StatementsContext ctx) {
        //s.closeScope();
    }

    /**
     *Exists body
     * @param ctx!= null && ctx instanceof BodyContext
     * @ensures MySymbolTable.closeScope()
     */
    @Override
    public void exitBody(GrammarParser.BodyContext ctx) {
        s.closeScope();
    }

    @Override
    public void enterPrint(GrammarParser.PrintContext ctx) throws VariableException {
        String var2 = ctx.variable().getText();
        Boolean string = (ctx.variable().QUOTES().size() != 0);
        Boolean array = (ctx.variable().OPENBRT() != null );
        if (dictionary.containsKey(var2) || isInteger(var2) || isBoolean(var2) || string || array) {

        } else {
            mistakes.add("Mistake. Line :" + ctx.getStart().getLine() + "variable needs to be declared, or be a basic type");
            throw new VariableException("Mistake. Line :" + ctx.getStart().getLine() + "variable needs to be declared, or be a basic type");
        }
    }

    @Override
    public void enterVariable(GrammarParser.VariableContext ctx) {

    }

    public static void main(String args[]){
        String rootFatima = "/Users/manuelgonzaleznovo/IdeaProjects/module8/pp/FinalProject/Test-Files/";

        String rootBryan = "C:\\Users\\Gebruiker\\Desktop\\Second Year CS\\M6 Intelligent Interaction" +
                "\\Project\\module8\\pp\\FinalProject\\Test-Files\\";

        String root = System.getProperty("user.dir") + "\\pp\\FinalProject\\Test-Files\\";

        GrammarChecker c = new GrammarChecker();

        //Set<String> errors = c.check(root + "pruebasBryan.txt");
        //System.out.println(errors);

        String rt = "cd C:\\Users\\Gebruiker\\Desktop\\Second Year CS\\M6 Intelligent Interaction\\Project\\module8\\pp\\FinalProject\\Test-Files";

        Process mProcess;
        try{
            mProcess = Runtime.getRuntime().exec(new String[]{ "ghci"});
            InputStream stdin  = mProcess.getInputStream();
            OutputStream stout =  mProcess.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stdin, StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stout));
            String line;
            writer.write(":load temp.hs");
            writer.flush();
            writer.close();
            while((line = reader.readLine()) != null){
                System.out.println("stdout: "+ line);
            }
        }catch(Exception e) {
            System.out.println("Exception Raised" + e.toString());
        }
    }
}