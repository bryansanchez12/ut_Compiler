package pp.FinalProject;

import org.antlr.v4.runtime.tree.ParseTree;
import pp.FinalProject.Sprockell.*;
import pp.FinalProject.exceptions.NoOperatorException;

import java.io.*;
import java.util.*;

public class GrammarGenerator extends GrammarBaseVisitor<Instances> {

    /**
     * @invariant writer not null
     */
    private BufferedWriter writer;
    /**
     * @invariant reader not null
     */
    private BufferedReader reader;
    /**
     * @invariant symbolTable not null
     */
    private MySymbolTable symbolTable;
    /**
     * @invariant registers.size()>0
     */
    private Stack<String> registers = new Stack<>();
    //private String[]  = {"regA","regB", "regC", "regD", "regE"};
    /**
     * @invariant lineCounter > 0 && lineCounter > Integer.MAX_VALUE
     */
    private int lineCounter;
    /**
     * @invariant instructionCounter >= 0 && instructionCounter > Integer.MAX_VALUE
     */
    private int instructionCounter = 0;
    /**
     * @invariant variableCounter >= 0 && variableCounter > Integer.MAX_VALUE
     */
    private int variableCounter = 0;
    /**
     * @invariant labels!=null && labels.size() > 0
     */
    private Map<String, Integer > labels = new HashMap<>();  // maybe => Map< NameOfVariable , <Line, Scope, SetOfInstructions > > labels
    // Map < Name, Type > which stores the variables and its type class
    /**
     * @invariant dictionary!=null && dictionary.size() > 0
     */
    private Map<String, String> dictionary = new HashMap<>();

    private StringBuilder setOfInstructions = new StringBuilder();
    private int loopCounter = 0;
    private int whileLoopCounter = 0;
    private boolean isVisiting = false;
    private boolean ifStatement = false;
    private boolean whileLoop = false;
    private boolean forLoop = false;
    private String whileLoopTail = "";
    /**
     * set up the registers
     * @ensures registers are initialized
     */
    public void registerInitialization(){
        registers.push("regA");
        registers.push("regB");
        registers.push("regC");
        registers.push("regD");
        registers.push("regE");
        registers.push("regF");
    }

    /**
     * Creates an .hs file containing a list of Sprockell instructions
     * @param tree!= null && tree instanceof ParseTree
     * @return new File
     */
    public File generate(ParseTree tree, String fileName) {
        this.symbolTable = new MySymbolTable();
        this.labels = new HashMap<>();
        this.lineCounter = 0;

        int labelId = 0;
        String endProgLabel = "";

        // give file name
        File file = new File( fileName+".hs");
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("* File \'" + file.getName() + "\' already exists.");
                Scanner myObj = new Scanner(System.in);
                System.out.println("* Do you want to overwrite it?  type: \"Yes\" or \"No\"");

                String userInput = myObj.nextLine();
                if (userInput.equalsIgnoreCase("Yes")){
                    file.delete();
                    file.createNewFile();
                } else {
                    System.out.println("Exiting Compiler...");
                    System.exit(0);
                }
            }
            writer = new BufferedWriter(new FileWriter(file));
            generateHeader();
            tree.accept(this);
            generateFooter();

            writer.flush();
            writer.close();
            //generateLabels(); do we need this?
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


    /**
     * Generate a header
     * @throws IOException
     */
    private void generateHeader() throws IOException {
        // ## We must check the behaviour of this method before we compile it ##
        String[] header = new String[]{
                "import Sprockell",
                "prog :: [Instruction]",
                "prog = ["
        };

        for (String s : header) {
            writer.write(s);
            writer.newLine();
        	lineCounter++;
        }
    }

    /**
     * Generate a footer
     * @throws IOException
     */
    private void generateFooter() throws IOException {
        // ## We must check the behaviour of this method before we compile it ##
        // semantic test
        String temp = "";
        String[] footer = new String[]{
                "\t\t\t\tEndProg]\n\n",
                "main = run [prog] "  //>> putChar '\n'
        };
        for (String s : footer) {
            writer.write(s);
            writer.newLine();
            lineCounter++;
        }
    }


    /**
     * Visit a parse tree produced by {@link GrammarParser#arguments}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Instances visitArguments(GrammarParser.ArgumentsContext ctx) {

        return super.visitArguments(ctx);
    }

    /**
     * Visit a parse tree produced by {@link GrammarParser#declaration}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Instances visitDeclaration(GrammarParser.DeclarationContext ctx) {
        Instances ins = null;
        try {
            if (isVisiting){
                visitDecl(ctx);
                return null;
            }
            else {
                String nameClass = ctx.identifier().getText();
                String result_value = ctx.expression().getText();
                String typeClass = null;
                if (ctx.type() != null ) {
                    typeClass = ctx.type().getText();
                    dictionary.put(nameClass, typeClass);
                    labels.put(nameClass, variableCounter);
                    variableCounter++;
                } else if(dictionary.containsKey(nameClass)) {
                    typeClass = dictionary.get(nameClass);
                }

                // Check whether the declaration is an array
                if (result_value.charAt(0) == '['){
                    // Remove '[', ',' and ']',  and put them into the array
                    String temp = result_value.substring(1, result_value.length() - 1);
                    String[] variables = temp.split(",");

                    if (typeClass.equals("boolean")) {
                        for (String variable : variables) {
                            // ToDo
                        }
                    }
                    if (typeClass.equals("int")) {
                        for (String variable : variables) {
                            // ToDo
                        }
                    }
                } else{
                    String[] variables  = new String[ctx.expression().variable().size()];
                    String[] varAddress = new String[ctx.expression().variable().size()];
                    for (int i = 0 ; i < variables.length ; i++){
                        String temp   = ctx.expression().variable(i).getText();
                        varAddress[i] = recognizeVariable(temp);
                        variables[i]  = temp;
                    }

                    // Check whether there are more variables in a declaration statement
                    if (variables.length > 1) {
                        if(typeClass.equals("int")){
                            String operator = ctx.expression().OPERATORS().get(0).getText();
                            computeNestedOp(operator, labels.get(nameClass), variables);
                        } else if (typeClass.equals("boolean")){
                            String operator = ctx.expression().OPERATORS().get(0).getText();
                            computeNestedOp(operator, labels.get(nameClass), variables);
                        } else {
                            // TODO Strings and arrays if implemented
                        }
                    } else{
                        // simple global memories
                        int index = labels.get(nameClass); // To be modified
                        String insReg = "";
                        boolean intoReg = false;
                        if (dictionary.containsKey(variables[0])) {
                            insReg = "(DirAddr " ;
                            intoReg = true;
                        } else {
                            insReg = "(ImmValue " ;
                        }

                        if (typeClass != null && typeClass.equals("boolean")) {
                            if (dictionary.containsKey(variables[0])){
                                //System.out.println("$$ > " +  ctx.getText());
                                //System.out.println("\t, Load  " + insReg + recognizeVariable(variables[0])+ ") regA");
                                if (intoReg){
                                    declStatConstMemory(Registers.RegA, recognizeVariable(variables[0]));
                                } else {
                                    declStatConstRegister(Registers.RegA, recognizeVariable(variables[0]));
                                }
                                instructionCounter++;
                                //System.out.println("\t, Store regA (DirAddr "+ index +")");
                                storeIntoMemory(Registers.RegA, Integer.toString(index));
                            } else {
                                String bool = "";
                                if (variables[0].equals("True")){
                                    bool = "1";
                                    // System.out.println(">> Load (DirAddr " + index + ") 1";  wrong!!!
                                    //System.out.println("\t, Load (ImmValue 1) regA");
                                    //declStatConstRegister(Registers.RegA, "1");
                                    //instructionCounter++;
                                    //System.out.println("\t, Store regA (DirAddr "+ index +")");
                                    //storeIntoMemory(Registers.RegA, Integer.toString(index));
                                    //instructionCounter++;
                                } else if (variables[0].equals("False")){
                                    bool = "0";
                                    //System.out.println("\t, Load (ImmValue 0) regA");
                                    //declStatConstRegister(Registers.RegA, "0");
                                    //instructionCounter++;
                                    //System.out.println("\t, Store regA (DirAddr "+ index +")");

                                } else {
                                    System.out.println("#### line 276 GrammarGenerator DANGER");
                                    // if it is not called change bool into boolConversion(variables[0])
                                }
                                declStatConstRegister(Registers.RegA, bool);
                                instructionCounter++;
                                storeIntoMemory(Registers.RegA, Integer.toString(index));
                                instructionCounter++;
                            }
                        } else if (typeClass.equals("int")) {
                            if (intoReg){
                                declStatConstMemory(Registers.RegA, variables[0]);
                                System.out.println("$$$$ I am called, if so go to line 288");
                            } else {
                                declStatConstRegister(Registers.RegA, variables[0]);
                            }
                            //System.out.println("\t, Load " + insReg + varAddress[0] +") regA");
                            instructionCounter++;
                            //.out.println("\t, Store regA (DirAddr " + index +")");
                            storeIntoMemory(Registers.RegA, Integer.toString(index));
                            instructionCounter++;
                        } else {
                            // TODO String implementation
                            // System.out.println(ctx.getText());
                            System.out.println("If you see this, get to line 176 on GrammarGenerator");
                        }
                    }
                }

                return super.visitDeclaration(ctx);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ins;
    }

    @Override
    public Instances visitPrint(GrammarParser.PrintContext ctx) {
        String varName = ctx.variable().getText();
        if (dictionary.containsKey(varName)){
            String type = dictionary.get(varName);
            String regAddres = recognizeVariable(varName);
            //System.out.println("\t, Load (DirAddr " + regAddres + ") regA");
            declStatConstMemory(Registers.RegA, regAddres);
            instructionCounter++;
            if (type.equals("int")){
                //System.out.println("\t, WriteInstr regA numberIO");
                declWriteOutput(Registers.RegA, "numberIO");
            } else{
                // TODO print other data types
            }
            instructionCounter++;
        } else {
            if(varName != null && isInteger(varName)){
                //System.out.println("\t, Load (ImmValue " + varName + ") regA");
                declStatConstRegister(Registers.RegA, varName);
                instructionCounter++;
                //System.out.println("\t, WriteInstr regA numberIO");
                declWriteOutput(Registers.RegA, "numberIO");
                instructionCounter++;
            } else if (varName != null && isBoolean(varName)){
                // String bool = boolConversion(varName);
                //System.out.println("\t, Load (ImmValue " + boolConversion(varName) + ") regA");
                declStatConstRegister(Registers.RegA, boolConversion(varName));
                instructionCounter++;
                // TODO print other data types
                //System.out.println("\t, WriteInstr regA numberIO");
                declWriteOutput(Registers.RegA, "numberIO"); // TODO change into char
                instructionCounter++;
            } else {
                // TODO Strings and arrays if implemented
            }
        }
        return super.visitPrint(ctx);
    }

    /**
     * Returns the result of calling
     * @requires ctx!= null && ctx instanceof If_conditionContext
     * @return the visitor result
     */
    @Override
    public Instances visitIf_condition(GrammarParser.If_conditionContext ctx) {
        ifStatement = true;
        int copyInsCount = instructionCounter;  //create a copy of the counter
        instructionCounter = 0;                 // initialize the counter
        isVisiting = true;                      // set to true in order to only count the instructions
        visitBody(ctx.body(0));              // visit all statement inside the body
        isVisiting = false;                     // set to false in order to emit the instructions
        loopCounter = instructionCounter;       //
        instructionCounter = copyInsCount;
        return super.visitIf_condition(ctx);
    }

    @Override
    public Instances visitWhile_loop(GrammarParser.While_loopContext ctx)  {
        try {
            whileLoop = true;
            int copyInsCount = instructionCounter;  //create a copy of the counter
            instructionCounter = 0;                 // initialize the counter
            isVisiting = true;                      // set to true in order to only count the instructions
            visitBody(ctx.body());                  // visit all statement inside the body
            isVisiting = false;                     // set to false in order to emit the instructions
            loopCounter        = instructionCounter + 1 ;
            whileLoopCounter   = copyInsCount ;
            instructionCounter = copyInsCount;
            visitCondition(ctx.condition());
            visitBody(ctx.body());
            int temp = (instructionCounter + 2) - whileLoopCounter;
            //System.out.println("\t, Jump (Rel (-" + temp + "))");
            jumpOp(Integer.toString(temp));
            instructionCounter++;
            whileLoop = false;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Return visitFor_loop
     * @param ctx!=null && ctx instanceof {@link GrammarParser.For_loopContext}
     * @return super.visitFor_loop(ctx)
     */
    @Override
    public Instances visitFor_loop(GrammarParser.For_loopContext ctx) {
        try {
            int copyInsCount = instructionCounter;  //create a copy of the counter
            instructionCounter = 0;                 // initialize the counter
            isVisiting = true;                      // set to true in order to only count the instructions
            visitDecl(ctx.declaration().get(0));
            visitDecl(ctx.declaration().get(1));
            visitBody(ctx.body());                  // visit all statement inside the body
            visitCondition(ctx.condition());
            isVisiting = false;                     // set to false in order to emit the instructions
            loopCounter        = instructionCounter;
            instructionCounter = copyInsCount;
            int forLoopCounter   = copyInsCount ;
            visitDeclaration(ctx.declaration().get(0));
            visitCondition(ctx.condition());
            visitBody(ctx.body());
            visitDeclaration(ctx.declaration().get(1));
            int temp = instructionCounter  - forLoopCounter;
            //System.out.println("\t, Jump (Rel (-" + temp + "))");
            jumpOp(Integer.toString(temp));
            instructionCounter++;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Visit a parse tree produced by {@link GrammarParser#condition}.
     * @param ctx instanceof ConditionContext
     * @return the visitor result
     */
    @Override
    public Instances visitCondition(GrammarParser.ConditionContext ctx) {
        Instances ins = null;
        try{
            if (isVisiting){
                // Register A will be the final boolean
                int ic = 0;
                // Check if there are multiple conditions.
                if (ctx.multiple_conditions() != null && ctx.multiple_conditions().condition().size() != 0){
                    // should I do something different by calling another method
                } else if ((ctx.COMPARATIVES() != null) && ctx.variable().size() >1){
                    String var1     = ctx.variable().get(0).getText();
                    String varType  = dictionary.get(var1);
                    String var2     = ctx.variable().get(1).getText();
                    String operator = ctx.COMPARATIVES().getText();

                    if (labels.get(var1) == null || labels.get(var1) == null){
                        // skip for now
                    } else {
                        String[] variables = {var1, var2};
                        visitOp( variables );
                    }
                } else {
                    // At this point, there should only be either True or False or a variable already defined
                    String var = ctx.getText();
                    if (dictionary.containsKey(var)){
                        instructionCounter++;
                        instructionCounter++;
                    } else {
                        instructionCounter++;
                        instructionCounter++;
                    }
                }
                instructionCounter++;
                instructionCounter++;
                instructionCounter++;
                if (whileLoop){
                    instructionCounter++;
                }
                return null;
            }
            else {
                // Register A will be the final boolean
                int ic = 0;
                // Check if there are multiple conditions.
                if (ctx.multiple_conditions() != null && ctx.multiple_conditions().condition().size() != 0){
                    // should I do something different by calling another method
                } else if ((ctx.COMPARATIVES() != null) && ctx.variable().size() >1){
                    String var1     = ctx.variable().get(0).getText();
                    String varType  = dictionary.get(var1);
                    String var2     = ctx.variable().get(1).getText();
                    String operator = ctx.COMPARATIVES().getText();

                    if (labels.get(var1) == null || labels.get(var1) == null){
                        // skip for now
                    } else {
                        String[] variables = {var1, var2};
                        int index = variableCounter + 1;
                        computeNestedOp(operator, index, variables );
                    }
                } else {
                    // At this point, there should only be either True or False or a variable already defined
                    String var = ctx.getText();
                    if (dictionary.containsKey(var)){
                        //System.out.println("\t, Load (DirAddr " + var + ") regA");
                        declStatConstMemory(Registers.RegA, var);
                        instructionCounter++;
                        ic++;
                    } else {
                        if (isInteger(var)){
                            System.out.println("$$$$ line 491, I am reached??? with var = " + var);
                            //System.out.println("\t, Load (ImmValue " + boolConversion(var) + ") regA");
                            declStatConstMemory(Registers.RegA, boolConversion(var));
                        } else { //if (isBoolean(var))
                            //System.out.println("\t, Load (ImmValue " + boolConversion(var) + ") regA");
                            declStatConstMemory(Registers.RegA, boolConversion(var));
                        }
                        instructionCounter++;
                        ic++;
                    }
                }
                //System.out.println("\t, Load (ImmValue 1) regB");
                declStatConstRegister(Registers.RegB, "1");
                ic++;
                //System.out.println("\t, Compute Xor regA regB regA");
                OpXor(Registers.RegA, Registers.RegB, Registers.RegA);
                ic++;
                ic = ic + instructionCounter + loopCounter + 1;
                //System.out.println("\t, Branch regA (Abs " + ic + ")");
                branchOp(Registers.RegA, Integer.toString(ic));
                instructionCounter++;
                if (ifStatement){
                    ifStatement = false;
                } else if (whileLoop){
                    //whileLoopTail = "\t, Jump (Rel (-" + loopCounter + "))";
                    jumpOp(Integer.toString(loopCounter));
                    instructionCounter++;
                    whileLoop = false;
                }
                loopCounter = 0;
                ins = super.visitCondition(ctx);
                return ins;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ins;
    }

    // ticks a counter of instructions during an operation
    public void visitDecl(GrammarParser.DeclarationContext ctx) {

        int varCount = variableCounter;

        String nameClass = ctx.identifier().getText();
        String result_value = ctx.expression().getText();
        String typeClass = null;
        if (ctx.type() != null ) {
            typeClass = ctx.type().getText();
            varCount++;
        } else if(dictionary.containsKey(nameClass)) {
            typeClass = dictionary.get(nameClass);
        }

        // Check whether the declaration is an array
        if (result_value.charAt(0) == '['){
            // Remove '[', ',' and ']',  and put them into the array
            String temp = result_value.substring(1, result_value.length() - 1);
            String[] variables = temp.split(",");

            if (typeClass.equals("boolean")) {
                for (String variable : variables) {
                    // ToDo
                }

            }

            if (typeClass.equals("int")) {
                for (String variable : variables) {
                    // ToDo
                }
            }
        } else{
            String[] variables  = new String[ctx.expression().variable().size()];
            String[] varAddress = new String[ctx.expression().variable().size()];
            for (int i = 0 ; i < variables.length ; i++){
                String temp   = ctx.expression().variable(i).getText();
                varAddress[i] = recognizeVariable(temp);
                variables[i]  = temp;
            }

            // Check whether there are more variables in a declaration statement
            if (variables.length > 1) {
                if (dictionary.containsKey(nameClass)){
                    visitOp(variables);
                } else {
                    if(typeClass != null && typeClass.equals("int")){
                        visitOp(variables);
                    } else if (typeClass != null && typeClass.equals("boolean")){
                        visitOp(variables);
                    } else {
                        // TODO Strings and arrays if implemented
                    }
                }
            } else{
                if (typeClass.equals("boolean")) {
                    if (dictionary.containsKey(variables[0])){
                        instructionCounter++;
                    } else {
                        if (variables[0].equals("True")){
                            instructionCounter++;
                            instructionCounter++;
                        } else if (variables[0].equals("False")){
                            instructionCounter++;
                            instructionCounter++;
                        }
                    }
                } else if (typeClass.equals("int")) {
                    instructionCounter++;
                    instructionCounter++;
                } else {

                }
            }
        }
    }


    /**
     * get the address of such a variable
     * @param variableName!=null
     */
    public String recognizeVariable(String variableName){
        if (dictionary.containsKey(variableName)){
            return labels.get(variableName).toString();
        } else if (isBoolean(variableName)){
            return boolConversion(variableName);
        } else {
            // Thus it's a integer
            return variableName;
        }
    }

    /**
     * Return arithmetic operator or logic operator
     * @param operator!=null
     */
    public String getOperator(String operator) throws NoOperatorException {
        String op = "";
        if (operator.equals("+")){
            op = Operators.ADD.toString();
        } else if (operator.equals("-")){
            op = Operators.SUB.toString();
        } else if(operator.equals("*")){
            op = Operators.MUL.toString();
        } else if (operator.equals("||") || operator.equals("or")){
            op = Operators.OR.toString();
        } else if (operator.equals("&&") || operator.equals("and")){
            op = Operators.AND.toString();
        } else if(operator.equals(">")){
            op = Operators.GT.toString();
        } else if (operator.equals("<")){
            op = Operators.LT.toString();
        } else if (operator.equals("<=")){
            op = Operators.LTE.toString();
        } else if (operator.equals(">=")){
            op = Operators.GTE.toString();
        } else if (operator.equals("==")){
            op = Operators.EQUAL.toString();
        } else if (operator.equals("!=")){
            op = Operators.NEQ.toString();
        } else if (operator.equals("/")) {
            op = Operators.DIV.toString();
        } else {
            // TODO throw exception
            throw new NoOperatorException("Incorrect o missing arithmetic operator.");
        }
        return op;
    }

    /**
     * Perform basic arithmetic operations such as addition, subtraction,
     * multiplication and division.
     * @param operator!= null
     * @param index data type integer
     * @requires variables.length >= 2 && variables!= null
     * @ensures arithmetic operations performed correctly
     */
    public void computeNestedOp(String operator, int index, String[] variables) throws NoOperatorException{
        //check if the operator is a division
        if (operator.equals("/")){
            if (variables.length == 2) {
                System.out.println("Division : " + variables[0] + " / " + variables[1] + " at index: " + index);
                setDivision(variables[0],variables[1], Integer.toString(index));
            } else {
                throw new NoOperatorException("The following operator is not valid.");
            }
        } else {
            char rg = 'A';
            //String insReg = "";
            String op = getOperator(operator);

            if (dictionary.containsKey(variables[0])) {
                //insReg = "(DirAddr " + recognizeVariable(variables[0]);
                declStatConstMemory(Registers.RegA, recognizeVariable(variables[0]));
            } else {
                //insReg = "(ImmValue " + recognizeVariable(variables[0]);
                declStatConstRegister(Registers.RegA, recognizeVariable(variables[0]));
            }

            //System.out.println("\t, Load " + insReg +") regA");
            instructionCounter++;
            for (int i = 1 ; i < variables.length ; i++){
                rg +=1;
                if (rg == 'E') {
                    rg = 'B';
                }

                if (dictionary.containsKey(variables[i]) ) {
                    //insReg = "(DirAddr " + recognizeVariable(variables[i]);
                    declStatConstMemory(getRegisterFromChar(rg), recognizeVariable(variables[i]));
                } else {
                    //insReg = "(ImmValue " + recognizeVariable(variables[i]);
                    declStatConstRegister(getRegisterFromChar(rg), recognizeVariable(variables[i]));
                }

                //System.out.println("\t, Load " + insReg +") reg" + rg);
                instructionCounter++;

                //System.out.println("\t, Compute " + op + " regA " + getRegisterFromChar(rg)+ " regA");
                computeOPSwitcher(op, Registers.RegA, getRegisterFromChar(rg), Registers.RegA);

                instructionCounter++;

            }
            //System.out.println("\t, Store regA (DirAddr "+ index +")");
            storeIntoMemory(Registers.RegA, Integer.toString(index));
            instructionCounter++;
        }

    }

    /**
     *Check whether bool is "True" or "False"; "1" => True, "0" => False
     * @param bool!= null
     * @return "1" if "True", "0" otherwise
     */
    public String boolConversion (String bool){
        if (bool.equals("True")){
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * Do basic boolean operations, such as OR operations (||), and AND operations (&&)
     * @param operator!= null
     * @param index!=null && index datatype integer
     * @requires variables.length >= 2
     * @ensures AND and OR operations performed correctly
     */
    public void booleanOperations(String operator, int index, String[] variables) throws NoOperatorException {
        char rg = 'A';
        String insReg = "";
        String op = getOperator(operator);

        if (dictionary.containsKey(variables[0])) {
            insReg = "(DirAddr ";
            declStatConstMemory(Registers.RegA, boolConversion(variables[0]));
        } else {
            declStatConstRegister(Registers.RegA,boolConversion(variables[0]));
        }

        //System.out.println("\t, Load " + insReg + boolConversion(variables[0]) +") regA");
        instructionCounter++;
        for (int i = 1 ; i < variables.length ; i++){
            rg +=1;
            if (rg == 'E') {
                rg = 'B';
            }

            if (dictionary.containsKey(variables[0])) {
                //insReg = "(DirAddr ";
                declStatConstMemory(getRegisterFromChar(rg), boolConversion(variables[i]));
            } else {
                //insReg = "(ImmValue ";
                declStatConstRegister(getRegisterFromChar(rg), boolConversion(variables[i]));
            }
            //System.out.println("\t, Load " + insReg + boolConversion(variables[i]) +") reg" + rg);
            instructionCounter++;
            //System.out.println("\t, Compute " + op + " regA reg" + rg+ " regA");
            computeOPSwitcher(op,Registers.RegA, getRegisterFromChar(rg), Registers.RegA);
            instructionCounter++;

        }
        //System.out.println("\t, Store regA (DirAddr "+ index +")");
        storeIntoMemory(Registers.RegA, Integer.toString(index));
        instructionCounter++;
    }

    // ticks a counter of instructions during an operation
    public void visitOp(String[] variables){
        instructionCounter++;
        for (int i = 1 ; i < variables.length ; i++){
            instructionCounter+=2;
        }
        instructionCounter++;
    }

    /**
     * Check whether the given @param x is of type {@link Integer}
     * @return true if x instanceof Integer, false otherwise
     */
    public boolean isInteger(String x){
        boolean result = true;
        try{
            Integer.parseInt(x);
        } catch (NumberFormatException ex){
            result = false;
        }
        return result;
    }

    public Registers getRegisterFromChar (char c){
        switch (c) {
            case 'A': return Registers.RegA;
            case 'B': return Registers.RegB;
            case 'C': return Registers.RegC;
            case 'D': return Registers.RegD ;
            case 'E': return Registers.RegE;
            case 'F': return Registers.RegF;
        }
        return null;
    }

    public void computeOPSwitcher(String operator, Registers r1, Registers r2, Registers r3){
        switch (operator) {
            case "Add":
                OpAddition(r1,r2,r3);
                break;
            case "Sub":
                OpSubstraction(r1,r2,r3);
                break;
            case "Mul":
                ;OpMultiplication(r1,r2,r3);
                break;

            case "Equal":
                OpEqual(r1,r2,r3);
                break;
            case "NEq":
                OpNotEqual(r1,r2,r3);
                break;
            case "Gt":
                OpGreaterThan(r1,r2,r3);
            case "Lt":
                OpLowerThan(r1,r2,r3);
                break;
            case "GtE": OpGreaterThan(r1,r2,r3);
                break;
            case "LtE":
                OpLowerEqual(r1,r2,r3);
                break;

            case "And":
                OpAnd(r1,r2,r3);
                break;
            case "Or":
                OpOr(r1,r2,r3);
                break;
            case "Xor":
                OpXor(r1,r2,r3);
                break;
            case "LShift":
                OpLShift(r1,r2,r3);
                break;
            case "RShift":
                OpRShift(r1,r2,r3);
                break;

            case "Incr":
                OpIncr(r1);
                break;
            case "Decr":
                OpDecr(r1);
                break;
        }
    }

    // do an integer division of two variables
    public void setDivision(String var1, String var2, String register){
        if(isVisiting){
            instructionCounter = instructionCounter + 13;
            if (isInteger(register)){
                storeIntoMemory(Registers.RegA, register);
                instructionCounter++;
            }
        } else {

            // load a counter and initializing to 0
            declStatConstRegister(Registers.RegA, "0");
            // load x value 0 into register
            declStatConstRegister(Registers.RegB, "0");


            // check if var1 was already declared before
            if (dictionary.containsKey(var1)){
                System.out.println(">> " + labels.get(var1));
                declStatConstMemory(Registers.RegD, recognizeVariable(var1));
                System.out.println("at register: " + recognizeVariable(var1));
            } else {
                declStatConstRegister(Registers.RegA, var1);
            }
            // check if var1 was already declared before
            if (dictionary.containsKey(var2)){
                System.out.println(">> " + labels.get(var2));
                declStatConstMemory(Registers.RegD, recognizeVariable(var2));
                System.out.println("at register: " + recognizeVariable(var1));
            } else {
                declStatConstRegister(Registers.RegD, var2);
            }

            // checks if x > var1, then stores the boolean in regF
            OpGreaterThan(Registers.RegB, Registers.RegD, Registers.RegF);
            System.out.println(">> " + instructionCounter);
            int count = 9 + instructionCounter;
            // set a branch point
            branchOp(Registers.RegF, Integer.toString(count));
            // do counter + 1 by an increment
            OpIncr(Registers.RegA);
            // var1 - var2, stores in regD
            OpSubstraction(Registers.RegD, Registers.RegC, Registers.RegD);
            // jump before our branch as a for-loop
            jumpOp("4");
            // decrement the counter by 1, which it also will be our result
            OpDecr(Registers.RegA);
            instructionCounter = instructionCounter + 12;
            if (isInteger(register)){
                storeIntoMemory(Registers.RegA, register);
                instructionCounter++;
            } else{
                System.out.println("##### line 903");
            }
        }
    }

    /**
     * Check whether the given @param x is a boolean
     * @param x!= null
     * @return x if x is boolean, false otherwise
     */
    public boolean isBoolean(String x){
        return !(!x.equals("True") & !x.equals("False"));
    }

    /**
     * Declare a constant variable in a register -> put value n in register r
     * @param r!= null && r instanceof {@link Registers}
     * @param value!= null
     * @ensures value is put in Register r
     */
    public void declStatConstRegister(Registers r, String value){
        genInstance(Instructions.LOAD, "(ImmValue "+ value +")",r.toString());
    }

    /**
     * Declare a constant variable in a register -> put value on memory address a in r
     * @param r!= null && r instanceof {@link Registers}
     * @param value!= null
     * @ensures value on memory address is put in {@link Registers} r
     */
    public void declStatConstMemory(Registers r, String value){
        genInstance(Instructions.LOAD, "(DirAddr "+ value +")",r.toString());
    }

    /**
     * store from memory address contained in register
     * @requires r1!= null && r2!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers}
     */
    public void storeIntoRegister(Registers r1, Registers r2 ){
        genInstance(Instructions.STORE, r1.toString(), "(IndAddr " + r2.toString() +")");
    }

    /**
     * store from register r to memory address a
     * @requires r1!= null && r2!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers}
     */
    public void storeIntoMemory(Registers r1, String address ){
        genInstance(Instructions.STORE, r1.toString(), "(DirAddr " + address +")");
    }

    /**
     * Compute Add regA regE regA -> do "Add" on regs r1, r2, and put result in reg r3
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpAddition(Registers r1, Registers r2, Registers r3){
       genInstance(Instructions.COMPUTE, Operators.ADD.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    public void OpDivision(Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.DIV.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute Subs regA regE regA -> do "Subs" on regs r1, r2, and put result in reg r3
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpSubstraction(Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.SUB.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute Mul regA regE regA -> do "Mul" on regs r1, r2, and put result in reg r3
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpMultiplication(Registers r1, Registers r2, Registers r3) {
        genInstance(Instructions.COMPUTE, Operators.MUL.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute Eq regA regE regA -> do "Eq" on regs r1, r2, and put result in reg r3  -> True == 1 , False == 0
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpEqual(Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.EQUAL.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute NEq regA regE regA -> do "NEq" on regs r1, r2, and put result in reg r3  -> True == 1 , False == 0
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpNotEqual(Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.NEQ.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute Lt regA regE regA -> do "Lt" on regs r1, r2, and put result in reg r3  -> True == 1 , False == 0
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpLowerThan(Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.LT.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute Eq regA regE regA -> do "Eq" on regs r1, r2, and put result in reg r3  -> True == 1 , False == 0
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpGreaterThan(Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.GT.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute GtE regA regE regA -> do "GtE" on regs r1, r2, and put result in reg r3  -> True == 1 , False == 0
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpGreaterEqual (Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.GTE.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute LtE regA regE regA -> do "LtE" on regs r1, r2, and put result in reg r3  -> True == 1 , False == 0
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpLowerEqual(Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.LTE.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute And regA regE regA -> do "And" on regs r1, r2, and put result in reg r3  -> True == 1 , False == 0
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpAnd (Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.AND.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute Or regA regE regA -> do "Or" on regs r1, r2, and put result in reg r3  -> True == 1 , False == 0
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpOr (Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.OR.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute Xor regA regE regA -> do "Eq" on regs r1, r2, and put result in reg r3
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpXor(Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.XOR.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute LShift regA regE regA -> do "LShift" on regs r1, r2, and put result in reg r3
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpLShift (Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.LSHIFT.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute RShift regA regE regA -> do "RShift" on regs r1, r2, and put result in reg r3
     * @requires r1!= null && r2!=null && r3!=null && r1 instanceof {@link Registers} && r2 instanceof {@link Registers} && r3 instanceof {@link Registers}
     */
    public void OpRShift(Registers r1, Registers r2, Registers r3){
        genInstance(Instructions.COMPUTE, Operators.RSHIFT.toString(), r1.toString(), r2.toString(), r3.toString());
    }

    /**
     * Compute Decr regA regA regA -> do "Decr" on regs r1, and put result in reg r1
     *@requires r1!= null && r1 instanceof {@link Registers}
     */
    public void OpDecr (Registers r1){
        genInstance(Instructions.COMPUTE, Operators.DECR.toString(), r1.toString(), r1.toString(), r1.toString());
    }

    /**
     * Compute Incr regA regA regA -> do "Incr" on regs r1, and put result in reg r1
     *@requires r1!= null && r1 instanceof {@link Registers}
     */
    public void OpIncr(Registers r1){
        genInstance(Instructions.COMPUTE, Operators.INCR.toString(), r1.toString(), r1.toString(), r1.toString());
    }

    /**
     * Put the top of the stack in register r1  and adapts the stack pointer
     *@requires r1!= null && r1 instanceof {@link Registers}
     */
    public void Pop(Registers r1){
        genInstance(Instructions.POP, r1.toString());
    }

    /**
     * put the value from register r1 on the stack
     *@requires r1!= null && r1 instanceof {@link Registers}
     */
    public void Push(Registers r1){
        genInstance(Instructions.PUSH, r1.toString());
    }

    /**
     *  Write content of reg r to shMem address a, especially integers
     *@requires r!= null && r instanceof {@link Registers}
     */
    public void declWriteOutput(Registers r, String address){
        genInstance(Instructions.WriteInstr, r.toString(), address);
    }

    /**
     * Jump operation that jump to target line
     * @param counter!= null
     */
    public void jumpOp(String counter){
        genInstance(Instructions.JUMP, "(Rel (-"+ counter + "))");
    }

    /**
     * Declare a constant variable in a register
     *@requires r!= null && r instanceof Registers
     * @param counter
     */
    public void branchOp(Registers r, String counter){
        genInstance(Instructions.BRANCH, r.toString(), "(Abs "+ counter + ")");
    }

    /**
     * Generate Instances
     * @param instances!= null && instances instanceof {@link Instances}
     */
    private void genInstance(Instances instances) {
        genInstance(instances.getLabel(), instances.getInstruction(), instances.getOperations());
    }


    /**
     * Generate Instances given instructions and operations
     * @param instructions!= null && instructions instanceof {@link Instructions}
     * @param operations!= null
     */
    private void genInstance(Instructions instructions, String... operations) {
        genInstance(null, instructions, operations);
    }

    /**
     * Generate instance given a label, instructions and operations
     * @param label!= null
     * @param instructions!= null && instructions instanceof {@link Instructions}
     * @param operations!= null
     */
    private void genInstance(String label, Instructions instructions, String... operations) {
        StringBuilder temp = new StringBuilder();
        for (String string : operations) {
            temp.append(string).append(" ");
        }
        if (label != null) {
            labels.put(label, lineCounter);
        }
        lineCounter++;
        try {
            writer.write("\t\t\t\t" + instructions.toString() + " " + temp.toString() + ",");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GrammarGenerator gen = new GrammarGenerator();
        GrammarChecker checker =  new GrammarChecker();
        ParseTree tree = null;
        String fileName = "pruebasBryan";

        String root = System.getProperty("user.dir") + "\\pp\\FinalProject\\Test-Files\\";
        String filePath = root + "pruebasBryan.txt";

        boolean check = false;
        Set<String> possibleMistakes = checker.check(filePath);
        if (possibleMistakes.size() == 0){
            check = true;
            tree = checker.getTree();
        }
        System.out.println("-------\t\tStatus\t\t  ------");
        System.out.println("check flag: " + check);
        System.out.println("tree flag:  " + (tree!=null));
        System.out.println("generating file: " + (check && tree != null));
        System.out.println("---------------------------------------\n");

        if (check && tree != null) {
            System.out.println("Generating file....");
            //tree.accept(gen);
            File hs = gen.generate(tree, fileName);
            if (hs != null) {
                System.out.println("File generated successfully");
            } else{
                System.out.println("File was not generated!");
            }

        } else {
            // throw exception
            System.out.println("Something went wrong :C");
            System.out.println("-------\t\tStatus\t\t------");
            System.out.println("check flag: " + check);
            System.out.println("tree flag:  " + (tree!=null));
        }

    }
}